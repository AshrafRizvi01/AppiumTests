package com.test.utils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class NewTest {
	@Test
	public void f() {
		System.out.println("xyz");
	}

	@AfterClass
	public void afterClass() throws ParserConfigurationException, SAXException, IOException {
		System.out.println("running");
		Reporting.addTestDetails("Ashraf.Iftekhar", "test", "Android", "Galaxy");
		Reporting.AddTesterNotes("I am very gratefull to you");
		String[] emails = { "ashraf.iftekhar@mutualmobile.com", "sandeep.akula@mutualmobile.com" };
		Reporting.generate(emails);
	}

}