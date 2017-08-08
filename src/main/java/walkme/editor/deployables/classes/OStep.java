package walkme.editor.deployables.classes;

import java.io.Serializable;

import jsystem.framework.scenario.UseProvider;
import walkme.automation.core.common.classes.deployables.Step;
import walkme.automation.core.shared.Enums.StepType;

public class OStep extends ODeployable implements Serializable{
	private static final long serialVersionUID = 4786227532889432373L;
	private String jQueryElement;
	private StepType stepType;
	private OStepProperties properties;

	public OStep(){
		
	}
	
	public String getjQueryElement() {
		return jQueryElement;
	}

	public void setjQueryElement(String jQueryElement) {
		this.jQueryElement = jQueryElement;
	}
	
	public Step toWMStep() {
		return null;
	}

	public StepType getStepType() {
		return stepType;
	}

	public void setStepType(StepType stepType) {
		this.stepType = stepType;
	}

	public OStepProperties getProperties() {
		return properties;
	}


	public void setProperties(OStepProperties properties) {
		this.properties = properties;
	}
}
