package controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.command.CommandHandler;
import controller.command.NullHandler;

//p540
//Controller������ �ϴ�  Servlet������ �ϴ� ����
//��û�� �м��ϴ� ���̴�
//�� Ŭ����������  ��û�� �м��Ͽ� ��� ��Ʈ�ѷ����Ϸ� ��������ִ� ���� �Ѵ�
//��û�� ������  http://ip�ּ�:��Ʈ��ȣ/���ؽ�Ʈ�н�/~~?cmd=��û����&~~~ ����
//cmd�Ķ������ ���� �޾ƿ;� �Ѵ�

/*���� p529 
	�̷��� �о���� cmd�Ķ������ ���� ���� �� ��ɾ �ش��ϴ� Ŭ������ ȣ���ϰ� �ȴ�.
	=>�� �� �� ��ɾ �ش��ϴ� ����ó���ڵ带 ���� Ŭ������ �ۼ��ϴ� ������ 
	command pattern�̶�� �Ѵ� */
public class ControllerUsingURI extends HttpServlet {

    // <Ŀ�ǵ�, �ڵ鷯�ν��Ͻ�> ���� ���� ����
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();

    //���� ��û�� �� �ѹ��� ȣ��Ǵ� �Լ��μ�
    //�������� �� �����ÿ� ���ȴ�
    public void init() throws ServletException {
    	//configFile �ʱ�ȭ �Ķ������ ���� �о�´�
        String configFile = getInitParameter("configFile");
        
        //map������� ó���Ǵ� �ڹ��� PropertiesŬ������ �̿�
        Properties prop = new Properties();
        
        //���������� ����ִ��� ��θ� �����Ѵ�
        String configFilePath = getServletContext().getRealPath(configFile);
        
        //�������Ϸκ��� ���������� �о�� Properties��ü�� �����Ѵ�
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new ServletException(e);
        }
        
        //Properties�� ����� �� ���������� Ű���� ���� �ݺ����� �۾��� ����
        Iterator keyIter = prop.keySet().iterator();
        while (keyIter.hasNext()) {
        	//1.command������  command�̸����� ������Ƽ���� �����Ѵ� 
            String command = (String) keyIter.next();
            //2.���������� command������ ����� ������Ƽ���� �̿��Ͽ�
            //Properties���� ���� ������  handlerClassName������ �����Ѵ�
            String handlerClassName = prop.getProperty(command);
            try {
            	//handlerClassName������ ����� ����  ����Ŭ�������Ͽ��� ã�´�
                Class<?> handlerClass = Class.forName(handlerClassName);
                //ã�� Ŭ���������� ������ �� �ֵ��� ��ü�� �����Ѵ�
                CommandHandler handlerInstance = 
                        (CommandHandler) handlerClass.newInstance();
                //������ ��ü�� commandHandlerMap�� ������Ų��
                //map�� �����͸� �߰��� ����
                //��.put(Ű��,value)
                //���⿡����  ��.put(Ŭ���̾�Ʈ�ǿ�û����, �ڵ鷯Ŭ������)
                commandHandlerMap.put(command, handlerInstance);
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    //get��� ��û�� ȣ��Ǵ� �����Լ�
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    //Post��� ��û�� ȣ��Ǵ� �����Լ�
    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    	
    	//Ŭ���̾�Ʈ�� ��û�� ��ɾ ���Ѵ�
    	//request.getRequestURI()�� �̿��Ͽ� ��üURI�� ���ϰ�
		String command = request.getRequestURI();
		//��üURI���� ContextPath�� �����Ѵ�
		if (command.indexOf(request.getContextPath()) == 0) {
			//������ ��ûURI���� ������
			//����ڿ�.substring(����idx,��idx): ����ڿ����� ����idx���� ��idx-1���� ����
			//"abcdef".substring(0,3)=> abc
			command = command.substring(request.getContextPath().length());
		}
		
		//commandHandlerMap����  �ش�Ű���� ����
		//��� ��Ʈ�ѷ������� ������ handler������ �����Ѵ�
        CommandHandler handler = commandHandlerMap.get(command);
        
        if (handler == null) {//���handler�� ���� ���
            handler = new NullHandler(); //
        }
        
        //���handler�� �ִ� ��쿡�� 
        String viewPage = null;
        try {//���handler�� process()�Լ��� ȣ���ϰ�
        	//process()�� �������ִ�  StringŸ���� viewPage�� �޴´�
        	//viewPage������ ����� ���ڿ���
        	//user���� �������� view�� �Ǿ�����
            viewPage = handler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        
        //view�������� forwading�ϱ�
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}




