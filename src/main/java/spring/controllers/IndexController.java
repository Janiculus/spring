package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.entities.Employee;
import spring.services.EmployeeService;

@RestController
@RequestMapping("/")

public class IndexController {
	
	@Autowired
	private EmployeeService employeeService;
	
	 @RequestMapping("")
	    String index() {
	        return "index";
	    }
	 
	 @RequestMapping(value = "generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	    public String generateModel() {
		 
		 Employee emp2 = new Employee();
		 emp2.setName("Sam");
         emp2.setBirth("1988-04-12");
         emp2.setSpecID(2);

         Employee emp3 = new Employee();
		 emp3.setName("Bill");
         emp3.setBirth("1981-05-02");
         emp3.setSpecID(3);
         
         Employee emp4 = new Employee();
		 emp4.setName("Anne");
         emp4.setBirth("1976-04-06");
         emp4.setSpecID(4);

	     employeeService.saveEmployee(emp2);
	     employeeService.saveEmployee(emp3);
	     employeeService.saveEmployee(emp4);

	        return "Model Generated";
	    }

}
