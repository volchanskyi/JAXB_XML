package core;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employees")
public class EmployeesType {

	@XmlElement(name = "employee")
	protected Level2 employee;

	static class Level2 {

		@XmlAttribute(name = "id")      String id;
		
		@XmlElement(name = "firstname") String firstname;
		@XmlElement(name = "lastname")  String lastname;
		@XmlElement(name = "title")     String title;
		@XmlElement(name = "hiredate")  String hiredate;
		@XmlElement(name = "phone")     String phone;
		@XmlElement(name = "email")     String email;
      }
}
