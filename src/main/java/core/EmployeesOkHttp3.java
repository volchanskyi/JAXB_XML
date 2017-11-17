package core;
import java.io.StringReader;
import javax.xml.bind.*;
import okhttp3.*;

public class EmployeesOkHttp3 {

	public static void main(String[] args) throws Exception {
		String xml = "http://alex.academy/xml/employee.xml";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(xml).get().build();
//           MediaType mediaType = MediaType.parse("application/xml");
//           RequestBody body = RequestBody.create(mediaType, "<user> </user>");
//           Request request = new Request.Builder().url(xml).post(body).build();
		StringReader sr = new StringReader((String) client.newCall(request).execute().body().string());
//		Response response = client.newCall(request).execute();
//		String doc = response.body().string();
//		StringReader sr = new StringReader(doc);
		EmployeesType o = (EmployeesType) JAXBContext.newInstance(EmployeesType.class).createUnmarshaller().unmarshal(sr);
//		JAXBContext jaxbC = JAXBContext.newInstance(EmployeesType.class);
//		Unmarshaller jaxbU = jaxbC.createUnmarshaller();
//		EmployeesType o = (EmployeesType) jaxbU.unmarshal(sr);
		
		System.out.println(	"Employee ID: " + 	o.employee.id + "; "
						     + "First name: " + 	o.employee.firstname + "; "
						     + "Last Name: " + 	o.employee.lastname + "; "
						     + "Title: " + 		o.employee.title + "; "
						     + "Hire date: " + 	o.employee.hiredate + "; "
						     + "Phone: " + 		o.employee.phone + "; "
						     + "Email: " + 		o.employee.email
				);
	}
}
