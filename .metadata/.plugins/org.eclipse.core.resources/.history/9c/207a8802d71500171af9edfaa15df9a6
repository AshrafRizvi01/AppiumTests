package com.test.utils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.AfterClass;
import org.xml.sax.SAXException;

public class Test {

	@org.testng.annotations.Test
	public void test() {
		System.out.println("ran1");
	}

	@AfterClass
	public void after() throws ParserConfigurationException, SAXException, IOException {
		Reporting.addTestDetails("TesterName", "Project", "Platform", "Device");
		String[] emails = { "ashraf.iftekhar@mutualmobile.com", "krishna.chaitanya@mutualmobile.com",
				"Hitender.pannu@mutualmobile.com" };
		Reporting.generate(emails);
	}

}
