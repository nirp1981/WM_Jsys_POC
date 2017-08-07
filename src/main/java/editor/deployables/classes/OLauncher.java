package editor.deployables.classes;


import org.openqa.selenium.By;

import jsystem.framework.ParameterProperties;
import walkme.automation.core.common.classes.deployables.Launcher;
import walkme.automation.core.common.classes.deployables.Names.DeployableText;
import walkme.automation.core.editor.elements.ActionSteps.ActionTypes;


public class OLauncher extends ODeployable{


	public static enum LauncherActionTypes {
		REDIRECT(ActionTypes.REDIRECT),
		JUMP_TO_STEP(ActionTypes.BRANCH_TO_WALKTHRU);

		private ActionTypes name;

		private LauncherActionTypes(ActionTypes _name ) {
			name = _name;
		}
	}
	
	private String toolTip;
	private String jQueryElement;
	public ActionTypes launcherAction;

	public String getjQueryElement() {
		return jQueryElement;
	}
	public void setjQueryElement(String jQueryElement) {
		this.jQueryElement = jQueryElement;
	}
	
	public Launcher toWMLauncher() throws Exception{
		return new Launcher(getName(), getToolTip(), By.cssSelector(getjQueryElement()));
	}
	
	public String getToolTip() {
		return toolTip;
	}
	
	@ParameterProperties(description = "toolTip")
	public void setToolTip(String toolTip) {
		this.toolTip = toolTip;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
	public ActionTypes getLauncherAction() {
		return launcherAction;
	}
	public void setLauncherAction(ActionTypes launcherAction) {
		this.launcherAction = launcherAction;
	}
	
	
	
}
