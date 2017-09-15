/**
 * 
 */
package utility;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import configuration.Automation;
import configuration.TestingCoE;

/**
 * 
 *
 */
public class XMLHelper {

	public static TestingCoE XmlToTestConfig(String filePath) {
		TestingCoE testingConfiguration = null;
		try {

			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(TestingCoE.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			testingConfiguration = (TestingCoE) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(testingConfiguration);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return testingConfiguration;
	}

	public static Automation XmlToAutomationConfig(String filePath) {
		Automation testingConfiguration = null;
		try {

			File file = new File(filePath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Automation.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			testingConfiguration = (Automation) jaxbUnmarshaller
					.unmarshal(file);
			System.out.println(testingConfiguration);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return testingConfiguration;
	}
}