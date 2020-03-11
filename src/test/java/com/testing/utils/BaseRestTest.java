package com.testing.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseRestTest {
	public static Properties prop;

@Parameters("myname")
@BeforeClass
public void RESTstartup(@Optional("Arul")String myname) {

	System.out.println("Starting REST ASSURED Test.......");
	
	System.out.println("My Name :"+myname);
	prop=getProperty();

}

private Properties getProperty() {

	Properties prop = new Properties();
	System.out.println("Getting all the needed property files");
	try {
		prop.load(new FileInputStream("src/test/resources/environment.properties"));
		prop.load(new FileInputStream(prop.getProperty("resourcepath")));
		//prop.loadFromXML(new FileInputStream("src/test/resources/qa/Endpoint.xml"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return prop;
}



}
