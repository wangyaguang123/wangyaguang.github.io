package com.wyg.bean;


public class ReplyDAOFactory {
	public static ReplyDAO getReplyDAOInstance(){	//������������������DAOʵ����ʵ��
		return new ReplyDAOImpl();						//����DAOʵ����ʵ��
	}
}
