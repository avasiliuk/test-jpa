package org.example;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class MyTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        jdbcTemplate.update("INSERT INTO employee VALUES (3,'bbb')");
    }

    @After
    public void clear() {
        jdbcTemplate.update("DELETE FROM employee");
    }

    @Test
    public void testSaveNewEntity() {

        final Employee employee = new Employee();
        employee.setName("bbb");

        employeeRepository.save(employee);
        System.out.println("some code");

    }
}
