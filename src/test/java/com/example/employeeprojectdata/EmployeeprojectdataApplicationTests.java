package com.example.employeeprojectdata;

import com.example.employeeprojectdata.models.Department;
import com.example.employeeprojectdata.models.Employee;
import com.example.employeeprojectdata.models.Project;
import com.example.employeeprojectdata.repositories.DepartmentRepository;
import com.example.employeeprojectdata.repositories.EmployeeRepository;
import com.example.employeeprojectdata.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeprojectdataApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canCreateEmployeeAndDepartment(){
		Department department = new Department("IT");
		departmentRepository.save(department);

		Employee employee = new Employee("Frank", "Violet", 32, department);
		employeeRepository.save(employee);
	}

	@Test
	public void canCreateEmployeesAndDepartmentAndProjects(){
        Department department = new Department("IT");
        departmentRepository.save(department);

        Employee employee = new Employee("Frank", "Violet", 32, department);
        employeeRepository.save(employee);

        Project project = new Project("AI", 5);
        projectRepository.save(project);

        project.addEmployee(employee);
        projectRepository.save(project);
	}

}
