package walkme.editor.setup;

import org.junit.Test;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.automationwebsite.TestPages;
import walkme.automation.core.testsetup.CommonFlows;
import wrappers.initializers;

public class EditorStart extends SystemTestCase4 {

	private String email;

	public EditorStart(){
		setTearDownFixture(EditorSetup.class);
	}
	
	@Test
	@TestProperties(name = "Start the editor , login with ${email} and reset user" ,paramsInclude = { "email" })
	public void startCleanEditor() throws Exception {
	   initializers.initialize();
 	   CommonFlows.start();
 	   CommonFlows.setUp(TestPages.main, CommonFlows.getEmail(), CommonFlows.getPassword(), null, true, false);
	}

	public String getEmail() {
		return email;
	}
	
	@ParameterProperties(description = "Enter email to login with to the editor.")
	public void setEmail(String email) {
		this.email = email;
	}





	
}
