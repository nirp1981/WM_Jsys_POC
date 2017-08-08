package walkme.player.deployables;

import static walkme.automation.core.common.FlowExtensions.*;
import static walkme.automation.core.common.FlowExtensions.playerApi;

import org.junit.Test;

import walkme.editor.deployables.classes.DeployablesStack;
import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.common.classes.deployables.Deployable;
import walkme.automation.core.common.classes.deployables.WalkThru;
import walkme.automation.core.infrastracture.player.PlayerElements.BalloonButtons;

public class WalkThrus extends SystemTestCase4 {

	private String walkThruName;
	private BalloonButtons balloonButton;
	private int stepIndex;
	
	public WalkThrus(){
		
	}
	
	@Test
	@TestProperties(name = "Play a WalkThru named '${walkThruName}' (click play from the editor)" ,paramsInclude = { "walkThruName" })
	public void PlayWalkThru() throws Exception {
		editorService().PlayPreview.generatePlay(getStoredWalkThru(getWalkThruName()));
	}
	
	@Test
	@TestProperties(name = "Click current Step '${balloonButton}' button" ,paramsInclude = { "balloonButton"})
	public void ClickStepButton() throws Exception {
		playerApi().Balloon.clickBalloonButton(getBalloonButton());
	}
	
	@Test
	@TestProperties(name = "Validate a Step num '${stepIndex}' of WT named '${walkThruName}' appears on the screen" ,paramsInclude = { "walkThruName" ,"stepIndex"})
	public void ValidateStepOnScreen() throws Exception {
		playerApi().Balloon.validate(getStoredWalkThru(getWalkThruName()).getStep(getStepIndex()));
	}
	
	@Test
	@TestProperties(name = "Validate a complete WT named '${walkThruName}' Plays correctly" ,paramsInclude = { "walkThruName"})
	public void ValidateCompleteWT() throws Exception {
		playerService().Validate.walkThru(getStoredWalkThru(getWalkThruName()));
	}
	
	public WalkThru getStoredWalkThru(String name) throws Exception{
		Deployable fromStack = DeployablesStack.getDeployable(name);
		if(fromStack instanceof WalkThru){
			return (WalkThru)fromStack;
		}
		else{
			throw new Exception("The found deployable: " + name +" is not a walkThru.");
		}
	}

	public String getWalkThruName() {
		return walkThruName;
	}

	@ParameterProperties(description = "The walkThru name that the action will be performed on")
	public void setWalkThruName(String walkThru) {
		this.walkThruName = walkThru;
	}

	public int getStepIndex() {
		return stepIndex  -1;
	}

	@ParameterProperties(description = "The step index inside the WT , starts from 1")
	public void setStepIndex(int stepIndex) {
		this.stepIndex = stepIndex;
	}

	public BalloonButtons getBalloonButton() {
		return balloonButton;
	}

	public void setBalloonButton(BalloonButtons balloonButton) {
		this.balloonButton = balloonButton;
	}
	
}
