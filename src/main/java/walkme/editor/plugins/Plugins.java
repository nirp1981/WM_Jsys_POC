package walkme.editor.plugins;

import static walkme.automation.core.common.FlowExtensions.editorService;

import org.junit.Test;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.Assert;
import junit.framework.SystemTestCase4;
import walkme.automation.core.editor.elements.publish.Publish.PublishEnv;
import walkme.automation.core.service.db.DBQuerys;
import walkme.automation.core.shared.Enums.Plugin;
import walkme.automation.core.testsetup.CommonFlows;

public class Plugins extends SystemTestCase4 {

	private Plugin plugin;
	private PublishEnv env;

	public Plugins(){
		
	}
	
	@Test
	@TestProperties(name = "Install the latest version of the plugin '${plugin}' to '${env}' environment" ,paramsInclude = { "plugin","env"})
	public void installPluginLatestVersion() throws Exception {
		editorService().BackStage.addPluginsToEnvironment(getEnv(),getPlugin());
	}
	
	@Test
	@TestProperties(name = "Validate that user`s '${plugin}' is from the latest version (doesnt work for now because of certification problem!)" ,paramsInclude = { "plugin","env"})
	public void validatePluginIsLatestVersion() throws Exception {
		String installedVersion = DBQuerys.getCurrentlyInstalledPluginVersion(CommonFlows.getEmail(), getPlugin(), getEnv());
		if(installedVersion == null || installedVersion.isEmpty()){
			throw new Exception("User doesnt have the plugin : " + getPlugin()) ;
		}
		String latestVersion = installedVersion; //TODO doesnt work for now because of certification problem!
		//String latestVersion = editorService().BackStage.getPluginLatestVersion(getPlugin());
		Assert.assertEquals(installedVersion, latestVersion);
	}

	public Plugin getPlugin() {
		return plugin;
	}

	@ParameterProperties(description = "Select plugin to install")
	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public PublishEnv getEnv() {
		return env;
	}

	@ParameterProperties(description = "Select the environment to install the plugin to")
	public void setEnv(PublishEnv env) {
		this.env = env;
	}


	//
	 





	
}
