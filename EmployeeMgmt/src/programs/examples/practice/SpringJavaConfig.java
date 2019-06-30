package programs.examples.practice;

import org.springframework.stereotype.Component;

import programs.examples.model.EmployeeInfo;

@Component
public class SpringJavaConfig 
{
    public static void main(String args[]){
    	
    }
}

class EmployeeService
{
	private EmployeeInfo employeeInfo;

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

}