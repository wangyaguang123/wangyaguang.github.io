package com.wyg.bean;




public class CriticismDAOFactory {
	public static CriticismDAO getCriticismDAOInstance(){	//������������������DAOʵ����ʵ��
		return new CriticismDAOImpl();						//����DAOʵ����ʵ��
	}
}
