package core;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import okhttp3.*;
import okhttp3.Request.Builder;

public class EmployeesOkHttp3 {

    public static boolean validateXMLSchema(File xsd_file, URL xml_url) throws SAXException, IOException {
	OkHttpClient client = new OkHttpClient();
	Builder b = new Request.Builder();
	ByteArrayInputStream xml_str = new ByteArrayInputStream(
		client.newCall(b.url(xml_url).get().build()).execute().body().string().getBytes());

	SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsd_file).newValidator()
		.validate(new StreamSource(xml_str));
	return true;
    }

    public static void main(String[] args) throws Exception {
	String xml = "http://alex.academy/xml/employee.xml";
	validateXMLSchema(new File("test_data/xsd/employees.xsd"), new URL(xml));
	OkHttpClient client = new OkHttpClient();
	Request request = new Request.Builder().url(xml).get().build();
	// MediaType mediaType = MediaType.parse("application/xml");
	// RequestBody body = RequestBody.create(mediaType, "<user> </user>");
	// Request request = new Request.Builder().url(xml).post(body).build();
	StringReader sr = new StringReader((String) client.newCall(request).execute().body().string());
	// Response response = client.newCall(request).execute();
	// String doc = response.body().string();
	// StringReader sr = new StringReader(doc);
	EmployeesType o = (EmployeesType) JAXBContext.newInstance(EmployeesType.class).createUnmarshaller()
		.unmarshal(sr);
	// JAXBContext jaxbC = JAXBContext.newInstance(EmployeesType.class);
	// Unmarshaller jaxbU = jaxbC.createUnmarshaller();
	// EmployeesType o = (EmployeesType) jaxbU.unmarshal(sr);

	System.out.println("Employee ID: " + o.employee.id + "; " + "First name: " + o.employee.firstname + "; "
		+ "Last Name: " + o.employee.lastname + "; " + "Title: " + o.employee.title + "; " + "Hire date: "
		+ o.employee.hiredate + "; " + "Phone: " + o.employee.phone + "; " + "Email: " + o.employee.email);
    }
}
