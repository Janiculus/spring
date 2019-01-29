package spring.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import spring.entities.Employee;

public interface EmpRepository extends CrudRepository<Employee, Integer> {
	
	 @Query("select count(*) from Employee p where p.id = ?1")
	    Integer checkIfExist(Integer emp_id);
}
