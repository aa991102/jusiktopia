package controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//�� �������̽��� 
//HandlerŬ������ ���������� �����ؾ��ϴ�
//�Լ����� �����Ͽ���
public interface CommandHandler {
	public String process(HttpServletRequest request, 
			HttpServletResponse response)
	throws Exception;
}
