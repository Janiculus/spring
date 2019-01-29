package spring.services;

import spring.entities.Employee;
import spring.repositories.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Product service implement.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmpRepository empRepository;

    public Iterable<Employee> listAllEmployees() {
        return empRepository.findAll();
    }

   
    public Employee getEmployeeById(Integer emp_id) {
        return empRepository.findOne(emp_id);
    }

    
    public Employee saveEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    public void deleteEmployee(Integer emp_id) {
        empRepository.delete(emp_id);
    }

    public Boolean checkIfExist(Integer emp_id) {
        if (empRepository.checkIfExist(emp_id) > 0)
            return true;
        else
            return false;
    }


}