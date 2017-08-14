package walkme.editor.setup;

import org.junit.Test;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.automationwebsite.TestPages;
import walkme.automation.core.testsetup.CommonFlows;
import wrappers.initializers;

public class EditorStart extends SystemTestCase4 {


	public EditorStart(){
	}
	
	/**
	 * *You must add the function "finishEditor" at the end of the test !!!
	 * This function steps:
	 * -Run the walkme editor
	 * -Login with the default user
	 * -Reset the default user
	 * -Run the coupled browser
	 * -Navigate to the automation main website
	 * @throws Exception
	 */
	@Test
	@TestProperties(name = "Start the editor , login with Default user (as defined in the browsers.xml file) and reset user")
	public void startCleanEditor() throws Exception {
	   initializers.initialize();
 	   CommonFlows.start();
 	   CommonFlows.setUp(TestPages.main, CommonFlows.getEmail(), CommonFlows.getPassword(), null, true, false);
	}


	
}
