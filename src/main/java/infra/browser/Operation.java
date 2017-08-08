package infra.browser;

import static walkme.automation.core.common.FlowExtensions.browser;

import java.util.Collection;

import org.junit.Test;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import jsystem.framework.scenario.UseProvider;
import junit.framework.SystemTestCase4;
import walkme.automation.common.config.TestConfig;
import walkme.automation.common.config.XmlConfig;
import walkme.automation.common.config.XmlConfig.ConfigEntry;
import walkme.automation.core.actionwrapper.ExternalWindowAction;
import walkme.automation.core.actionwrapper.ExternalWindowAction.PlayMode;
import walkme.automation.core.common.FlowExtensions;
import walkme.automation.core.common.classes.conditions.Condition;
import walkme.automation.core.editor.elements.ConditionBuilder.BrowserTypes;
import wrappers.FlowExtensionsJsystem;

public class Operation extends SystemTestCase4 {
	
	
	private String browserName;

	public Operation(){
		
	}
	
	@Test
	@TestProperties(name = "Start execution of a test on a browser" ,paramsInclude = { "browserName"})
	public void startBrowserExecution() throws Exception {
		FlowExtensionsJsystem.startBrowserExecution(getBrowserName());
	}
	
	@Test
	@TestProperties(name = "Finish execution of a test on a browser")
	public void finishBrowserExecution() throws Exception {
		FlowExtensionsJsystem.finishBrowserExecution();
	}

	public String getBrowserName() {
		return browserName;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	
	
}
