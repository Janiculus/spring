package spring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "EMPLOYEE")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name="employee_generator", sequenceName = "emp_seq", allocationSize=50)
    @Column(name = "emp_id")
    private int emp_id;
	
	@Column(name = "emp_name")
	private String emp_name;
	
	@Column(name = "emp_birth")
    private String emp_birth;
	
	@Column(name = "spec_id")
    private int spec_id;
	
	public Employee() {}
	
	//Setters
	
	 public void setId(int Id) {
         this.emp_id = Id;
	 }
	 public void setName(String Name) {
	        this.emp_name = Name;
	    }
	 public void setBirth(String Birth) {
	        this.emp_birth = Birth;
	    }
	 public void setSpecID(int SpecId) {
	        this.spec_id = SpecId;
	    }

	//Getters
	 
	public int getId() {
        return emp_id;
    }
	public String getName() {
        return emp_name;
    }
	public String getBirth() {
        return emp_birth;
    }
	public int getSpecID() {
        return spec_id;
    }
}