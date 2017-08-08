package walkme.editor.deployables.classes;


import jsystem.framework.scenario.UseProvider;
import walkme.automation.core.common.classes.deployables.WalkThru;

public class OWalkThru extends ODeployable{

	OStep[] stepsList;

	public OStep[] getStepsList() {
		return stepsList;
	}

	@UseProvider(provider = jsystem.extensions.paramproviders.ObjectArrayParameterProvider.class)
	public void setStepsList(OStep[] stepsList) {
		this.stepsList = stepsList;
	}

	public WalkThru toWMWalkThru() {
		return null;
	}
	
}
