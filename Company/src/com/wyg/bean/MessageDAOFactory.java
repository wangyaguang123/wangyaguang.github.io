package com.wyg.bean;



public class MessageDAOFactory {
	public static MessageDAO getMessageAOInstance(){	//������������������DAOʵ����ʵ��
		return new MessageDAOImpl();						//����DAOʵ����ʵ��
	}
}
