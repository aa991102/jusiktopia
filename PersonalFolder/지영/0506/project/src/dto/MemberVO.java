//200503 �ų��� memberVO���� �� ȸ�����̺� �÷��� �ּ�

package dto;

import java.sql.Date;

public class MemberVO {
	
	private int mno; //ȸ����ȣ(mno)
	private String id; //ȸ��ID(id)
	private String nickname; //�г���(mnick)
	private String pw; //��й�ȣ(mpw)
	private String name; //�̸�(mname)
	private String mail; //�̸���(mname)
	private String phone; //��ȭ��ȣ(mphone)
	private Date regdate; //������(mdate)
	private int deposit; //����������Ʈ(mdeposit)
	private int asset; //�ڻ�����Ʈ(masset)

	public MemberVO() {}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getAsset() {
		return asset;
	}

	public void setAsset(int asset) {
		this.asset = asset;
	}

	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", id=" + id + ", nickname=" + nickname + ", pw=" + pw + ", name=" + name
				+ ", mail=" + mail + ", phone=" + phone + ", regdate=" + regdate + ", deposit=" + deposit + ", asset="
				+ asset + "]";
	}

	
}
