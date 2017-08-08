package walkme.editor.publish;

import static walkme.automation.core.common.FlowExtensions.editorService;
import org.junit.Test;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

public class Publish extends SystemTestCase4 {


	public Publish(){
		
	}
	
	@Test
	@TestProperties(name = "Publish Fast All user Data" )
	public void publishAll() throws Exception {
		editorService().Publish.publishFast();
	}

	
}
