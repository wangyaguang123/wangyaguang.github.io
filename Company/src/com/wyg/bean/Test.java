package com.wyg.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;


public class Test {
	public static void main(String[] args) throws ParseException, SQLException {
		MessageDAO dao = MessageDAOFactory.getMessageAOInstance();
		Message message = new Message();
		message.setMessageTitle("今天要开会!");
		message.setMessageContent("今天要开会");
		message.setEmployeeID(20180412);
		message.setPublishTime(new Date());
		
		dao.addMessage(message);
	}	
}
