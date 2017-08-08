package walkme.editor.deployables;

import static walkme.automation.core.common.FlowExtensions.*;

import java.util.HashMap;

import org.junit.Test;
import org.openqa.selenium.By;

import walkme.editor.deployables.classes.DeployablesStack;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.common.classes.deployables.Launcher;
import walkme.automation.core.common.classes.wmitems.CapturedElement;
import walkme.automation.core.common.classes.wmitems.DeployableAction;
import walkme.automation.core.editor.elements.ActionSteps.ActionTypes;
import jsystem.framework.scenario.Parameter;

public class Launchers extends SystemTestCase4 {

	private String launcherName ="";
	private String relatedDeployableName ="";
	private String jQueryElement ="";
	private ActionTypes launcherAction = ActionTypes.NONE;
	
	public Launchers(){
		
	}
	
	@Test
	@TestProperties(name = "Create a new Launcher named '${launcherName}'" ,paramsInclude = { "launcherName" ,"launcherAction","relatedDeployableName","jQueryElement"})
	public void CreateNew() throws Exception {
		checkParams();
		Launcher toCreate = new Launcher(getLauncherName());
		toCreate.setDeployableAction(new DeployableAction(getLauncherAction(), DeployablesStack.getDeployable(getRelatedDeployableName())));
		toCreate.setCapturedElement(new CapturedElement(By.cssSelector(getjQueryElement())));
		editorService().Launchers.createNew(toCreate, true);
		DeployablesStack.addDeployable(toCreate);
	}
	
	private void checkParams() throws Exception {
		if(getLauncherName().isEmpty()){
			throw new Exception("You must set a launcher name!");
		}
		if(getjQueryElement().isEmpty()){
			throw new Exception("You must set a launcher jQuery element!");
		}
	}

	public String getLauncherName() {
		return launcherName;
	}

	@ParameterProperties(description = "The launcher name that the action will be performed on")
	public void setLauncherName(String launcherName) {
		this.launcherName = launcherName;
	}


	public ActionTypes getLauncherAction() {
		return launcherAction;
	}

	@ParameterProperties(description = "The launcher action to perform on click" , section = "Launcher Action")
	public void setLauncherAction(ActionTypes launcherAction) {
		this.launcherAction = launcherAction;
	}

	public String getRelatedDeployableName() {
		return relatedDeployableName;
	}

	@ParameterProperties(description = "Enter the deployable name to perform the action on" , section = "Launcher Action")
	public void setRelatedDeployableName(String relatedDeployableName) {
		this.relatedDeployableName = relatedDeployableName;
	}
	
	
	 @Override
     public void handleUIEvent(HashMap<String, Parameter> map, String methodName) throws Exception {
		Parameter actionParameter = map.get("LauncherAction");
		Parameter actionDeployableParameter = map.get("RelatedDeployableName");
		if (actionParameter.getValue() == ActionTypes.PLAY_WALKTHRU.toString()) {
			actionDeployableParameter.setEditable(true);
		}
		else{
			actionDeployableParameter.setValue(actionDeployableParameter.getDefaultValue());
			actionDeployableParameter.setEditable(false);
		}
	}

	public String getjQueryElement() {
		return jQueryElement;
	}

	@ParameterProperties(description = "The jquery selector of the launcher element" , section = "Launcher Element")
	public void setjQueryElement(String jQueryElement) {
		this.jQueryElement = jQueryElement;
	}

	
}
