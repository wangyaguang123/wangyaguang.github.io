package com.wyg.bean;

import java.util.List;


public interface CriticismDAO {
	public void addCriticism(Criticism criticism);			//�������
	public Criticism findCriticismByMsgID(int messageID);	//������ID��������
}
