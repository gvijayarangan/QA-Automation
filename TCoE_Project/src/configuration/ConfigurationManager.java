/**
 * 
 */
package configuration;

import java.util.List;

import utility.XMLHelper;

/**
 * 
 *
 */
public class ConfigurationManager {
	public static TestingCoE configuration = null;
	public static Automation autoConfiguration = null;

	public static TestingCoE.Environment EnvironmentSetting = null;
	public static Automation.Environments.Environment autoEnvironmentSetting = null;

	/**
	 * 
	 * @param FilePath
	 */
	public ConfigurationManager(String FilePath) {
		configuration = XMLHelper.XmlToTestConfig(FilePath);
	}

	public static void setConfigurationFile(String FilePath) {

		configuration = XMLHelper.XmlToTestConfig(FilePath);

	}

	public static void setAutomationConfigurationFile(String FilePath) {

		autoConfiguration = XMLHelper.XmlToAutomationConfig(FilePath);

	}

	/**
	 * 
	 * @param FilePath
	 */
	public static void getEnvironmentDetails(String FilePath) {
		configuration = XMLHelper.XmlToTestConfig(FilePath);
		List<Automation.TestSetting.Add> configurationKeys = autoConfiguration
				.getTestSetting().getAdd();

		if (configurationKeys.toArray().length > 0) {
			for (Automation.TestSetting.Add key : configurationKeys) {
				if (key.getKey().toUpperCase().equals("ENVIRONMENT")) {
					TypeOfEnvironment environmentType = TypeOfEnvironment
							.valueOf(key.getValue());
					setTestingEnvironment(environmentType);
					break;
				}
			}
		}
	}

	/**
	 * 
	 * @param environmentType
	 */
	public static void setTestingEnvironment(TypeOfEnvironment environmentType) {
		List<configuration.Automation.Environments.Environment> envList = autoConfiguration
				.getEnvironments().getEnvironment();
		if (envList.toArray().length > 0) {
			for (configuration.Automation.Environments.Environment env : envList) {
				if (env.getName().equals(environmentType.toString())) {
					autoEnvironmentSetting = env;
					break;
				}
			}
		}
	}

}
