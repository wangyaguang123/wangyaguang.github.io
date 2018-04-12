package com.wyg.bean;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MsgPublish extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		//���ò�������
		String title = request.getParameter("title");//����û�����ı���
		String content = request.getParameter("content");//����û�����ı���
		System.out.println(title);
		System.out.println(content);
		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher = null;
		//���ĸ�Ա����������Ϣ
		Employee employee = (Employee) request.getSession().getAttribute("employee");
		if(employee == null) {
			request.setAttribute("error", "Ҫ������Ϣ�������Ƚ������ʶ��");
			dispatcher = servletContext.
					getRequestDispatcher("/publishNewMsg.jsp");//��ת����Ϣ����ҳ��
		}else {
			if(title == null || "".equals(title)) { //����û�û���������
				request.setAttribute("error", "����������Ϣ����");
				dispatcher = servletContext.
						getRequestDispatcher("/publishNewMsg.jsp");//��ת����Ϣ����ҳ��
			}else {
				Message message = new Message();//ʵ����Message����
				message.setEmployeeID(employee.getEmployeeID());//���÷����˱��
				message.setMessageTitle(title);//������Ϣ����
				message.setMessageContent(content);//���ñ�������
				message.setPublishTime(new Date());//���÷�������
				MessageDAO messageDAO = 
					MessageDAOFactory.getMessageAOInstance();//���MessageDAOʵ��
				messageDAO.addMessage(message);		//�����Ϣ
				dispatcher = servletContext.
				getRequestDispatcher("/GetMessageList");//��ת����Ϣ����ҳ��
			}
		}
		dispatcher.forward(request, response);//����ҳ����ת
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
