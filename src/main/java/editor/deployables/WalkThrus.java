package editor.deployables;

import static walkme.automation.core.common.FlowExtensions.editorService;

import org.junit.Test;

import editor.deployables.classes.DeployablesStack;
import editor.deployables.classes.OStep;
import editor.deployables.classes.OWalkThru;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import jsystem.framework.scenario.UseProvider;
import junit.framework.SystemTestCase4;
import walkme.automation.core.common.classes.deployables.WalkThru;

public class WalkThrus extends SystemTestCase4 {

	private OWalkThru walkThru;
	private String walkThruName;
	private OStep[] stepsList;
	private int numOfSteps;

	public WalkThrus(){
		
	}
	
	/**
	 * Create a new WT via editorAPI , The steps locators are "#num1" "#num2" etc.
	 * @throws Exception
	 */
	@Test
	@TestProperties(name = "Create a new Generic WalkThru by api , named :'${walkThruName}'" ,paramsInclude = { "walkThruName" ,"numOfSteps"})
	public void CreateNewGenericFast() throws Exception {
		report.report("crteate : "+ getWalkThruName() + getNumOfSteps());
		WalkThru toCreate = editorService().WTs.createSimpleWTFast(getWalkThruName(), getNumOfSteps());
		DeployablesStack.addDeployable(toCreate);
	}
	
	@Test
	@TestProperties(name = "Create a new WalkThru , named :'${walkThruName}'" ,paramsInclude = { "walkThruName" ,"stepsList"})
	public void CreateNew() throws Exception {
		WalkThru toCreate = getWalkThru().toWMWalkThru();
		editorService().WTs.createNew(toCreate, true);
		DeployablesStack.addDeployable(toCreate);
	}
	
	public OWalkThru getWalkThru() {
		return walkThru;
	}

	@UseProvider(provider = jsystem.extensions.paramproviders.GenericObjectParameterProvider.class)
	public void setWalkThru(OWalkThru walkThru) {
		this.walkThru = walkThru;
	}

	public String getWalkThruName() {
		return walkThruName;
	}

	@ParameterProperties(description = "The WalkThru name that the action will be performed on")
	public void setWalkThruName(String walkThruName) {
		this.walkThruName = walkThruName;
	}
	
	public OStep[] getStepsList() {
		return stepsList;
	}

	public void setStepsList(OStep[] stepsList) {
		this.stepsList = stepsList;
	}

	public int getNumOfSteps() {
		return numOfSteps;
	}

	@ParameterProperties(description = "The Number of steps to add to the WT , The steps locators are '#num1' '#num2' etc ")
	public void setNumOfSteps(int numOfSteps) {
		this.numOfSteps = numOfSteps;
	}
	
}
