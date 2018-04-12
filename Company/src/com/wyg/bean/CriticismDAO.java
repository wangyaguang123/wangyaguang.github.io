package com.wyg.bean;

import java.util.List;


public interface CriticismDAO {
	public void addCriticism(Criticism criticism);			//添加批复
	public Criticism findCriticismByMsgID(int messageID);	//按文章ID查找批复
}
