package walkme.editor.navigation;

import org.junit.Test;

import walkme.editor.setup.EditorSetup;

import static walkme.automation.core.common.FlowExtensions.editorService;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.editor.elements.GeneralFrame.WMGridOptions;

public class Navigate extends SystemTestCase4 {

	private WMGridOptions workspace;

	public Navigate(){
		
	}
	
	@Test
	@TestProperties(name = "Navigate to workspace ${workspace}" ,paramsInclude = { "workspace" })
	public String goToWorkspace() throws Exception {
		editorService().SwitchPages.goToWorkSpace(getWorkspace());
		return "123";
	}

	public WMGridOptions getWorkspace() {
		return workspace;
	}

	@ParameterProperties(description = "Select the workspace you want to navigate to")
	public void setWorkspace(WMGridOptions workspace) {
		this.workspace = workspace;
	}





	
}
