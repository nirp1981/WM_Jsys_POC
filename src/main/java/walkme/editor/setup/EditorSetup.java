package walkme.editor.setup;

import jsystem.framework.fixture.Fixture;
import walkme.automation.core.testsetup.CommonFlows;


public class EditorSetup extends Fixture {

	
    public EditorSetup() {
    	
    }
    
    public void setUp() throws Exception {
    }
    
    public void tearDown() throws Exception {
    	CommonFlows.tearDown();
    	CommonFlows.testFixtureTearDown();
    }

    public void failTearDown() throws Exception {
    	CommonFlows.tearDown();
    	CommonFlows.testFixtureTearDown();
    }

}
