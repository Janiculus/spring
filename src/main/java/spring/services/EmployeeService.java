package spring.services;

import spring.entities.Employee;
import java.util.Optional;

public interface EmployeeService {

    Iterable<Employee> listAllEmployees();

    Employee getEmployeeById(Integer emp_id);

    Employee saveEmployee(Employee emp);

    void deleteEmployee(Integer emp_id);

    Boolean checkIfExist(Integer emp_id);

}