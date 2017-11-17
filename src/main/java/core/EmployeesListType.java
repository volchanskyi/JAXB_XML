package core;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employees")
public class EmployeesListType {
	List<EmployeeType> employees = new ArrayList<EmployeeType>();

	@XmlElement(name = "employee")
	List<EmployeeType> getEmployees() {return employees;}

	public static class EmployeeType {

		List<String> id = new ArrayList<String>();
		@XmlAttribute(name = "id") List<String> getId()              {return id;}

		List<String> firstname = new ArrayList<String>();
		@XmlElement(name = "firstname") List<String> getFirstNames() {return firstname;}

		List<String> lastname = new ArrayList<String>();
		@XmlElement(name = "lastname") List<String> getLastNames()   {return lastname;}
		
		List<String> title = new ArrayList<String>();
		@XmlElement(name = "title") List<String> getTitle()          {return title;}
		
		List<String> hiredate = new ArrayList<String>();
		@XmlElement(name = "hiredate") List<String> getHireDate()    {return hiredate;}
		
		List<String> phone = new ArrayList<String>();
		@XmlElement(name = "phone") List<String> getPhone()          {return phone;}
		
		List<String> email = new ArrayList<String>();
		@XmlElement(name = "email") List<String> getEmail()          {return email;}
	}
}
