package com.wyg.bean;

import java.util.List;



public interface ReplyDAO {
	public void addReplay(Reply replay);			//��ӻظ�
	public List<Reply> findReplayByMsgID(int messageID,Page page);//������ID���һظ�
	public int findCountByMsgID(int messageID);//��ѯ��Ϣ�ظ���¼��
}
