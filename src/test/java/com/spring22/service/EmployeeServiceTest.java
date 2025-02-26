package com.spring22.service;

import com.spring22.dao.EmployeeJPAInterface;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.*;
import com.spring22.dao.Employee;

@SpringBootTest
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeJPAInterface employeeJPAInterface;

	@Test
	public void findEmployeeByName() {
		String name = "abc";
		employeeService.findEmployeeByName(name);
	}

	@Test
	public void findEmployeeByNameTODO() {
		String name = "abc";
		Employee expected = new Employee(123, "abc", "abc");
		Employee actual = employeeService.findEmployeeByName(name);

		assertEquals(expected, actual);
	}
}
