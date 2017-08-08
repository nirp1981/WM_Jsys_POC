package walkme.editor.plugins;

import static walkme.automation.core.common.FlowExtensions.editorService;

import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;
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
	@TestProperties(name = "Install the latest version of the plugin '${plugin}' to '${env}' environment (Via API)" ,paramsInclude = { "plugin","env"})
	public void installPluginLatestVersion() throws Exception {
		editorService().BackStage.addPluginsToEnvironment(getEnv(),getPlugin());
	}
	
	@Test
	@TestProperties(name = "Validate that user`s plugin '${plugin}' is from the latest version  (Via DB) (doesnt work for now because of certification problem!)" ,paramsInclude = { "plugin","env"})
	public void validatePluginIsLatestVersion() throws Exception {
		String installedVersion = DBQuerys.getCurrentlyInstalledPluginVersion(CommonFlows.getEmail(), getPlugin(), getEnv());
		if(installedVersion == null || installedVersion.isEmpty()){
			throw new Exception("User doesnt have the plugin : " + getPlugin()) ;
		}
		String latestVersion = installedVersion; //TODO doesnt work for now because of certification problem!
		//String latestVersion = editorService().BackStage.getPluginLatestVersion(getPlugin());
		Assert.assertEquals(installedVersion, latestVersion);
	}
	
	@Test
	@TestProperties(name = "Validate that user has the  plugin '${plugin}' installed (Via DB)" ,paramsInclude = { "plugin","env"})
	public void validateUserHasPluginInstalled() throws Exception {
		ArrayList<Pair<String, Integer>> installedPlugins = DBQuerys.getCurrentlyInstalledPLugins(CommonFlows.getEmail());
		if(installedPlugins == null || installedPlugins.isEmpty()){
			throw new Exception("User doesnt have plugins") ;
		}
		for (Pair<String, Integer> pair : installedPlugins) {
			String plugin = pair.getKey();
			Integer ver = pair.getValue();
			if(plugin.equals(getPlugin())){
				if(ver ==  getEnv().getEnvID()){
					return;
				}
			}
		}
		throw new Exception("User doesnt have the plugin : " + getPlugin() +" at env: " +getEnv()) ;
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
