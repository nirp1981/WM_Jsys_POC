package infra.browser;

import static walkme.automation.core.common.FlowExtensions.browser;

import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.automationwebsite.TestPages.AutomationWebSites;

public class Navigation extends SystemTestCase4 {
	
	
	private String URL;
	private AutomationWebSites automationPage;

	public Navigation(){
		
	}
	
	@Test
	@TestProperties(name = "Navigate to a custom URL '${URL}'" ,paramsInclude = { "URL"})
	public void navigateToURL() throws Exception {
		browser().Navigate.to( getURL());
	}
	
	/**
	 * This function goes to a predefined automation website and inject the default user snippet.
	 * @throws Exception
	 */
	@Test
	@TestProperties(name = "Navigate to Automation website '${automationPage}'" ,paramsInclude = { "automationPage"})
	public void navigateToAutomationPage() throws Exception {
		browser().Navigate.simpleNavigate(getAutomationPage().getPage().url());
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public AutomationWebSites getAutomationPage() {
		return automationPage;
	}

	public void setAutomationPage(AutomationWebSites automationPage) {
		this.automationPage = automationPage;
	}
	
	
}
