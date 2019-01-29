package spring.controllers;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import spring.entities.Employee;
import spring.services.EmployeeService;


@RestController
@RequestMapping("/api")


public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	//List All
	
	 @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Iterable<Employee> list(Model model) {
	        return employeeService.listAllEmployees();
	    }
	 
	//Get ID
	 
	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Employee getByPublicId(@PathVariable("id") Integer publicId) {
	        return employeeService.getEmployeeById(publicId);
	    }
	 
	//Get param ID
	 
	 @RequestMapping(value = "/employee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public Employee getByParamPublicId(@RequestParam("id") Integer publicId) {
	        return employeeService.getEmployeeById(publicId);
	    }

	 //Save employee to database.
	 
	 @RequestMapping(value = "/employee", method = RequestMethod.POST)
	    public ResponseEntity<Employee> create(@RequestBody @Valid @NotNull Employee emp) {
	        emp.setName(UUID.randomUUID().toString());
	        employeeService.saveEmployee(emp);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	    }
	 
	 //Edit employee
	 
	 @RequestMapping(value = "/employee", method = RequestMethod.PUT)
	    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Employee emp) {
	        if(!employeeService.checkIfExist(emp.getId()))
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        else {
	            employeeService.saveEmployee(emp);
	            return new ResponseEntity<>(HttpStatus.CREATED);
	        }
	    }
	 
	 //Delete employee
	 
	 @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
	    public RedirectView delete(@PathVariable Integer id) {
	        employeeService.deleteEmployee(id);
	        return new RedirectView("/api/employees", true);
	    }

	 
}
