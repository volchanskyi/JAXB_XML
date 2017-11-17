package core;
import java.io.File;
import javax.xml.bind.*;
import javax.xml.parsers.*;
import org.w3c.dom.Document;

public class Employees {

	public static void main(String[] args) throws Exception {

		String xml = "http://alex.academy/xml/employee.xml";
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xml);
		doc.getDocumentElement().normalize(); 
		
		File file = new File("employees.xml");
		
		EmployeesType o = (EmployeesType) JAXBContext.newInstance(EmployeesType.class).createUnmarshaller().unmarshal(doc);
	
		System.out.println("Employee ID: " + 	o.employee.id + "; "
							+ "First name: " + 	o.employee.firstname + "; "
							+ "Last Name: " + 	o.employee.lastname + "; "
							+ "Title: " + 	o.employee.title + "; "
							+ "Hire date: " + 	o.employee.hiredate + "; "
							+ "Phone: " + 	o.employee.phone + "; "
							+ "Email: " + 	o.employee.email
							);
      }
}
