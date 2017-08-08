package walkme.editor.setup;

import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.testsetup.CommonFlows;

public class EditorFinish extends SystemTestCase4 {


	public EditorFinish(){
	}
	
	@Test
	@TestProperties(name = "Logout and close the editor")
	public void finishEditor() throws Exception {
	 	   CommonFlows.miniTearDown();
	 	   CommonFlows.miniTestFixtureTearDown();
	}

	
}

