package editor.deployables.classes;

import java.util.ArrayList;
import java.util.List;

import walkme.automation.core.common.classes.deployables.Deployable;

public class DeployablesStack {
	
	static List<Deployable> testDeployables = new ArrayList<Deployable>();
	
	public static void addDeployable(Deployable deployable){
		testDeployables.add(deployable);
	}
	
	public static Deployable getDeployable(String deployableName) throws Exception{
		if(deployableName == null || deployableName.isEmpty()){
			return null;
		}
		for (Deployable deployable : testDeployables) {
			if(deployable.getName().equals(deployableName)){
				return deployable;
			}
		}
		throw new Exception("Cannot find a deployable named : " + deployableName);
	}
	
}
