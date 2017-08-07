package browser;

import static walkme.automation.core.common.FlowExtensions.*;
import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import wrappers.FlowExtensionsJsystem;

public class Navigation extends SystemTestCase4 {
	
	
	private String URL;

	public Navigation(){
		
	}
	
	@Test
	@TestProperties(name = "Navigate to a custom URL '${URL}'" ,paramsInclude = { "URL"})
	public void navigateToURL() throws Exception {
		browser().Navigate.to( getURL());
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}
	
	
}
