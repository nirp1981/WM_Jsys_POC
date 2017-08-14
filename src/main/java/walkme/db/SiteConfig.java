package walkme.db;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.service.db.DBQuerys;
import walkme.automation.core.shared.Enums.Features;
import walkme.automation.core.testsetup.CommonFlows;
import wrappers.FlowExtensionsJsystem;

public class SiteConfig extends SystemTestCase4 {

	private Features feature;
	private String email = "default";
	
	public SiteConfig(){
		
	}
	
	
	@Test
	@TestProperties(name = "Validate that the current user has the feature '${features}' (Via DB)" ,paramsInclude = { "features" ,"email"})
	public void ValidateUserHasFeature() throws Exception {
		String featuresList = DBQuerys.getSiteConfigFeatures(FlowExtensionsJsystem.getUserEmail(getEmail()));
		List<String> listOfFeatures = Arrays.asList(featuresList.split(","));
		Assert.assertTrue(listOfFeatures.contains( getFeatures().toString()));
	}
	
	@Test
	@TestProperties(name = "Validate that the current user does not have the feature '${features}' (Via DB)" ,paramsInclude = { "features","email" })
	public void ValidateUserDoesntHaveFeature() throws Exception {
		String featuresList = DBQuerys.getSiteConfigFeatures(FlowExtensionsJsystem.getUserEmail(getEmail()));
		List<String> listOfFeatures = Arrays.asList(featuresList.split(","));
		Assert.assertTrue(!listOfFeatures.contains(getFeatures().toString()));
	}
	
	
	public String getEmail() {
		return email;
	}

	@ParameterProperties(description = "Enter a user email or leave as \"default\" in order to use the current test user" , section = "User Data")
	public void setEmail(String email) {
		this.email = email;
	}


	public Features getFeatures() {
		return feature;
	}


	public void setFeatures(Features features) {
		this.feature = features;
	}


 
	
}
