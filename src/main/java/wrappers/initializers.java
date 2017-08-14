package wrappers;

import jsystem.framework.RunProperties;
import walkme.automation.core.common.PertinaciousTester;

public class initializers {

	public static void initialize() throws Exception{
		//Variables.initializeLanguages();
		PertinaciousTester.initializeEssentials();
		RunProperties.getInstance().setRunProperty("MachineBrowsers","Chrome;FireFox");
	}

}
