/**
 * 
 */
package com.test.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Contains methods to generate detailed report for Appium tests using TestNG
 * 
 * @author Ashraf Iftekhar, Mar 27, 2017
 *
 */
public class Reporting {

	static String pass, fail, skip, ignore, total;
	static String Tester = "Empty", project = "Empty", platform = "Empty", device = "Empty",
			Notes = "Notes are not added for this report";

	static String path = System.getProperty("user.dir") + "/test-output/testng-results.xml";
	static File xml = new File(path);

	static char quote = '"';
	static String methodName, status, style;
	static String testrow, fullData = "";
	static int num = 0;
	static List<String> FormViewData = new ArrayList<String>();

	static List<String[]> ArrList = new ArrayList<String[]>();

	/**
	 * generates complete report in HTML format according to the provided
	 * Template, The Template is fixed and please contact
	 * <a href="ashraf.iftekhar@mutualmobile.com">Ashraf Iftekhar</a> for the
	 * template file
	 * 
	 * @param EmailIds
	 *            String Array of email ids
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 * 
	 * @author md.ashrafiftekhar
	 */
	public static void generate(String[] EmailIds) throws ParserConfigurationException, SAXException, IOException {
		parseXML();
		System.out.println("xmlParsed");
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream path = loader.getResourceAsStream("Test.html");
		InputStreamReader r = new InputStreamReader(path);
		StringBuilder sb = new StringBuilder();
		char[] chars = new char[4 * 1024];
		int len;
		while ((len = r.read(chars)) >= 0) {
			sb.append(chars, 0, len);
		}

		writeToHTML(sb);
		System.out.println("done");
		EmailReport.SendReportAsEmail(EmailIds);
	}

	/**
	 * Internal method to parse the testNG-results.xml file
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static void parseXML() throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xml);
		doc.getDocumentElement().normalize();
		NodeList ResultList = doc.getElementsByTagName("testng-results");
		NodeList MethodList = doc.getElementsByTagName("test-method");

		for (int i = 0; i < ResultList.getLength(); i++) {

			NamedNodeMap attributes = ResultList.item(i).getAttributes();
			pass = attributes.getNamedItem("passed").getNodeValue();
			fail = attributes.getNamedItem("failed").getNodeValue();
			skip = attributes.getNamedItem("skipped").getNodeValue();
			try {
				ignore = attributes.getNamedItem("ignored").getNodeValue();
			} catch (Exception e) {
				ignore = "0";
			}
			total = attributes.getNamedItem("total").getNodeValue();

		}
		for (int i = 0; i < MethodList.getLength(); i++) {
			String[] TestDetails = new String[3];
			NamedNodeMap attributes = MethodList.item(i).getAttributes();
			TestDetails[0] = attributes.getNamedItem("name").getNodeValue();
			TestDetails[1] = attributes.getNamedItem("status").getNodeValue();
			if (TestDetails[1].equals("FAIL")) {
				TestDetails[2] = "Style=" + quote + "color:red" + quote;
			} else if (TestDetails[1].equals("PASS")) {
				TestDetails[2] = "Style=" + quote + "color:green" + quote;
			} else if (TestDetails[1].equals("IGNORE")) {
				TestDetails[2] = "Style=" + quote + "color:blue" + quote;
			} else if (TestDetails[1].equals("SKIP")) {
				TestDetails[2] = "Style=" + quote + "color:orange" + quote;
			}

			ArrList.add(TestDetails);
		}
	}

	/**
	 * Writes HTML file after all the values are generated
	 * 
	 * @param TemplatePath
	 * 
	 * @throws IOException
	 */
	public static void writeToHTML(StringBuilder sb) throws IOException {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
		String htmlString = sb.toString();
		htmlString = htmlString.replace("$Heading", "TestReport");

		htmlString = htmlString.replace("$P", pass);
		htmlString = htmlString.replace("$F", fail);
		htmlString = htmlString.replace("$S", skip);
		htmlString = htmlString.replace("$I", ignore);
		htmlString = htmlString.replace("$T", total);

		htmlString = htmlString.replace("$testerName", Tester);
		htmlString = htmlString.replace("$Date", ft.format(date));
		htmlString = htmlString.replace("$projectName", project);
		htmlString = htmlString.replace("$platformName", platform);
		htmlString = htmlString.replace("$Device", device);

		htmlString = htmlString.replace("$Notes", Notes);

		for (String[] S : ArrList) {

			methodName = S[0];
			status = S[1];
			style = S[2];
			num = num + 1;
			testrow = "<tr class=" + quote + "test" + quote + "><td width=" + quote + "70" + quote + ">" + num
					+ "</td><td width=" + quote + 1000 + quote + ">" + methodName + "</td><td width=" + quote + 200
					+ quote + style + ">" + status + "</td></tr>";
			fullData = fullData + testrow;

		}

		htmlString = htmlString.replace("$myrows", fullData);

		File newHtmlFile = new File(System.getProperty("user.dir") + "/" + "report.html");
		FileUtils.writeStringToFile(newHtmlFile, htmlString);
		System.out.println("file written");

	}

	/**
	 * This method should be called before Reporting.generate() method to add
	 * specific info in your report
	 * 
	 * @param TesterName
	 *            Tester Name
	 * @param Project
	 *            Project in test or Application Under Test
	 * @param Platform
	 *            Platform in test
	 * @param Device
	 *            Test Device
	 * 
	 * @author md.ashrafiftekhar
	 */
	public static void addTestDetails(String TesterName, String Project, String Platform, String Device) {
		Tester = TesterName;
		project = Project;
		platform = Platform;
		device = Device;
	}

	/**
	 * This method should be called before Reporting.generate() method to add
	 * notes
	 * 
	 * @param Notes
	 * 
	 * @author md.ashrafiftekhar
	 */
	public static void AddTesterNotes(String Notes) {
		Reporting.Notes = Notes;
	}

}
