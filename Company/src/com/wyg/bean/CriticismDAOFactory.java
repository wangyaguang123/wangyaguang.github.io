package com.wyg.bean;




public class CriticismDAOFactory {
	public static CriticismDAO getCriticismDAOInstance(){	//工厂方法，用来返回DAO实现类实例
		return new CriticismDAOImpl();						//返回DAO实现类实例
	}
}
