package com.wyg.bean;

import java.util.List;



public interface EmployeeDAO {
	public void addEmployee(Employee employee);		//�������Ա����Ϣ�ķ���
	public void updateEmployee(Employee employee);	//�����޸�Ա����Ϣ�ķ���
	public void deleteEmployee(int employeeID);		//����ɾ��Ա����Ϣ�ķ���
	public List<Employee> findAllEmployee();		//�����ѯ����Ա����Ϣ�ķ���
	public Employee findEmployeeById(int employeeID);//���尴ID��ѯԱ����Ϣ�ķ���
}
