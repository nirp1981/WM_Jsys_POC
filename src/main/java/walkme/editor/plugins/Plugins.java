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
import wrappers.FlowExtensionsJsystem;

public class Plugins extends SystemTestCase4 {

	private Plugin plugin;
	private PublishEnv env;
	private String version;
	private String email = "default";

	public Plugins(){
		
	}
	
	@Test
	@TestProperties(name = "Install the latest version of the plugin '${plugin}' to '${env}' environment (Via API)" ,paramsInclude = { "plugin","env"})
	public void installPluginLatestVersion() throws Exception {
		editorService().BackStage.addPluginsToEnvironment(getEnv(),getPlugin());
	}
	
	@Test
	@TestProperties(name = "Install the the plugin '${plugin}'  version ${version} to '${env}' environment (Via API)" ,paramsInclude = { "plugin","env","version"})
	public void installPluginSpecificVersion() throws Exception {
		editorService().BackStage.addPluginSpecificVersion(getPlugin(),getEnv(),getVersion());
	}
	
	@Test
	@TestProperties(name = "Remove the latest version of the plugin '${plugin}' on '${env}' environment (Via API)" ,paramsInclude = { "plugin","env"})
	public void removePluginLatestVersion() throws Exception {
		editorService().BackStage.removePluginsToEnvironment(getEnv(),getPlugin());
	}
	
	@Test
	@TestProperties(name = "Remove the plugin '${plugin}' version ${version} on '${env}' environment (Via API)" ,paramsInclude = { "plugin","env","version"})
	public void removePluginSpecificVersion() throws Exception {
		editorService().BackStage.removePluginSpecificVersion(getPlugin(),getEnv(),getVersion());
	}
	
	@Test
	@TestProperties(name = "Validate that user`s plugin '${plugin}' version is ${version}  (Via DB)" ,paramsInclude = { "plugin","env","version","email"})
	public void validateInstalledPluginIsVersion() throws Exception {
		String installedVersion = getPluginInstalledVersion();
		report.report("plugin installed Version : " +    installedVersion);
		Assert.assertEquals(installedVersion, getVersion());
	}

	
	@Test
	@TestProperties(name = "Validate that user`s plugin '${plugin}' is from the latest version  (Via DB)" ,paramsInclude = { "plugin","env","email"})
	public void validateInstalledPluginIsLatestVersion() throws Exception {
		String installedVersion = getPluginInstalledVersion();
		//String latestVersion = installedVersion; //TODO doesnt work for now because of certification problem!
		String latestVersion = editorService().BackStage.getPluginLatestVersion(getPlugin());
		report.report("plugin installed Version : " +    installedVersion);
		report.report("plugin latest Version : " + latestVersion);
		Assert.assertEquals(installedVersion, latestVersion);
	}
	
	private String getPluginInstalledVersion() throws Exception {
		String installedVersion = DBQuerys.getCurrentlyInstalledPluginVersion(FlowExtensionsJsystem.getUserEmail(getEmail()), getPlugin(), getEnv());
		if(installedVersion == null || installedVersion.isEmpty()){
			throw new Exception("User doesnt have the plugin : " + getPlugin()) ;
		}
		return installedVersion;
	}
	
	@Test
	@TestProperties(name = "Remove all plugin '${plugin}' versions on '${env}' environment (Via DB)" ,paramsInclude = { "plugin","env","email"})
	public void DeleteUserPlugin() throws Exception {
		DBQuerys.deleteUserPlugin(FlowExtensionsJsystem.getUserEmail(getEmail()), plugin, env);
	}
	
	@Test
	@TestProperties(name = "Remove plugin '${plugin}' version ${version} on '${env}' environment (Via DB)" ,paramsInclude = { "plugin","env","version","email"})
	public void DeleteUserPluginSpecificVersion() throws Exception {
		DBQuerys.deleteUserPlugin(FlowExtensionsJsystem.getUserEmail(getEmail()), plugin, env, getVersion());
	}
	
	@Test
	@TestProperties(name = "Validate that user has the  plugin '${plugin}' installed (Via DB)" ,paramsInclude = { "plugin","env","email"})
	public void validateUserHasPluginInstalled() throws Exception {
		ArrayList<Pair<String, Integer>> installedPlugins = DBQuerys.getCurrentlyInstalledPLugins(FlowExtensionsJsystem.getUserEmail(getEmail()));
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

	public String getVersion() {
		return version;
	}

	@ParameterProperties(description = "Select plugin version")
	public void setVersion(String version) {
		this.version = version;
	}

	public String getEmail() {
		return email;
	}

	@ParameterProperties(description = "Enter a user email or leave as \"default\" in order to use the current test user" , section = "User Data")
	public void setEmail(String email) {
		this.email = email;
	}


	//
	 





	
}
