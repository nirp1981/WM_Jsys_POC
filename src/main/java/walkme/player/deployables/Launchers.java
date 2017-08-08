package walkme.player.deployables;

import static walkme.automation.core.common.FlowExtensions.editorService;
import static walkme.automation.core.common.FlowExtensions.playerApi;

import org.junit.Test;

import walkme.editor.deployables.classes.DeployablesStack;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.common.classes.deployables.Deployable;
import walkme.automation.core.common.classes.deployables.Launcher;

public class Launchers extends SystemTestCase4 {

	private String launcherName;
	
	public Launchers(){
		
	}
	
	@Test
	@TestProperties(name = "Play a Launcher named '${launcherName}' (click play from the editor)" ,paramsInclude = { "launcherName" })
	public void PlayLauncher() throws Exception {
		editorService().PlayPreview.generatePlay(getStoredLauncher(getLauncherName()));
	}
	
	@Test
	@TestProperties(name = "Validate a Launcher named '${launcherName}' appears on the screen" ,paramsInclude = { "launcherName" })
	public void ValidateLauncherOnScreen() throws Exception {
		playerApi().Launchers.validateLauncherVisibility(getStoredLauncher(getLauncherName()), true);
	}
	
	public Launcher getStoredLauncher(String name) throws Exception{
		Deployable fromStack = DeployablesStack.getDeployable(name);
		if(fromStack instanceof Launcher){
			return (Launcher)fromStack;
		}
		else{
			throw new Exception("The found deployable: " + name +" is not a launcher.");
		}
	}

	public String getLauncherName() {
		return launcherName;
	}

	@ParameterProperties(description = "The launcher name that the action will be performed on")
	public void setLauncherName(String launcherName) {
		this.launcherName = launcherName;
	}
	
}
