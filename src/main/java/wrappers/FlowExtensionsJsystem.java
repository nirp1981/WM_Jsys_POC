package wrappers;

import walkme.automation.common.config.TestConfig;
import walkme.automation.common.config.XmlConfig;
import walkme.automation.common.config.XmlConfig.ConfigEntry;
import walkme.automation.core.common.FlowExtensions;
import walkme.automation.core.testsetup.CommonFlows;

public class FlowExtensionsJsystem extends FlowExtensions{
	
	public static ConfigEntry originalConf;
	
	public static String getUserEmail(String email){
		if(email.toLowerCase().equals("default")){
			return CommonFlows.getEmail();
		}
		else{
			return email;
		}
	}
	
	
	public static void startBrowserExecution(String browserName) throws Exception {
		originalConf = TestConfig.getInstance().getData();
		XmlConfig.ConfigEntry childConf = new ConfigEntry();
		childConf.put("BrowserName", browserName);
		if(browserName.toLowerCase().contains("firefox")){
			childConf.put("BrowserPath", "C:\\Firefox46\\firefox.exe");
		}
		try{
			TestConfig.getInstance().setData(childConf);
			createNewData(null);
			browser().Activate.currentBrowserFast();
		}
		catch(Throwable e){
			finishBrowserExecution();
		}
	}

	public static void finishBrowserExecution() throws Exception {
		swapBack();
		TestConfig.getInstance().setData(originalConf);
	}
}
