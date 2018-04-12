package com.wyg.bean;





public class EmployeeDAOFactory {
	public static EmployeeDAO getEmployeeDAOInstance(){	//工厂方法，用来返回DAO实现类实例
		return new EmployeeDAOImpl();						//返回DAO实现类实例
	}
}
