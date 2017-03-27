/**
 * 
 */
package com.test.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Contains methods to generate detailed report for Appium tests with Testng
 * 
 * @author Ashraf Iftekhar, Mar 27, 2017
 *
 */
public class Reporting {

	public static void GenerateTestReport() throws ParserConfigurationException, SAXException, IOException {
		String path = System.getProperty("user.dir") + "/test-output/testng-results.xml";

		File fXmlFile = new File(path);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();

		System.out.println("Total : " + doc.getDocumentElement().getAttribute("total"));
		System.out.println("Passed : " + doc.getDocumentElement().getAttribute("passed"));
		System.out.println("Failed : " + doc.getDocumentElement().getAttribute("failed"));
		System.out.println("Skipped : " + doc.getDocumentElement().getAttribute("skipped"));

	}

}
