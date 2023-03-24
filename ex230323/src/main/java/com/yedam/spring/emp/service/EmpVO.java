package com.yedam.spring.emp.service;

import java.util.Date;

import lombok.Data;


@Data
public class EmpVO {
	
	// DB테이블의 컬럼명을 그대로 적으면 _때문에 제대로 되지않기 때문에 카멜 표현으로 적는다
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
