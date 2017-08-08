package infra.browser;

import static walkme.automation.core.common.FlowExtensions.*;

import org.junit.Test;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import jsystem.framework.scenario.UseProvider;
import junit.framework.SystemTestCase4;
import walkme.automation.core.common.classes.conditions.Condition;

public class Windows extends SystemTestCase4 {
	
	
	private String windowTitle;
	private Condition condition;

	public Windows(){
		
	}
	
	@Test
	@TestProperties(name = "Switch to a browser popup with the title '${windowTitle}'" ,paramsInclude = { "windowTitle","condition"})
	public void switchToPopUp() throws Exception {
		browser().Window.switchTo(getWindowTitle());
	}
	
	@Test
	@TestProperties(name = "Switch to a browser window with the title '${windowTitle}'" ,paramsInclude = { "windowTitle"})
	public void switchToWindow() throws Exception {
		browser().Window.switchTo(getWindowTitle());
	}
	
	public String getWindowTitle() {
		return windowTitle;
	}

	@ParameterProperties(description = "Select what kind of operation to perform on the element")
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}

	public Condition getCondition() {
		return condition;
	}

	@UseProvider(provider = jsystem.extensions.paramproviders.GenericObjectParameterProvider.class)
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	
}