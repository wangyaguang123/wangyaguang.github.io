package com.wyg.bean;





public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance(){	//������������������DAOʵ����ʵ��
		return new EmployeeDAOImpl();						//����DAOʵ����ʵ��
	}
}
