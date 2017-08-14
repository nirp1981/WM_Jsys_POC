package infra.browser;

import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
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
