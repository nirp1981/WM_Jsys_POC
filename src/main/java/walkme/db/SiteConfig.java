package walkme.db;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import jsystem.framework.scenario.UseProvider;
import junit.framework.SystemTestCase4;
import walkme.automation.core.service.db.DBQuerys;
import walkme.automation.core.testsetup.CommonFlows;

public class SiteConfig extends SystemTestCase4 {

	private String[] features;
	
	public SiteConfig(){
		
	}
	
	
	@Test
	@TestProperties(name = "Validate that the current user has the features : ${features} (Via DB)" ,paramsInclude = { "features" })
	public void ValidateCurrentUserFeaturesContains() throws Exception {
		String featuresList = DBQuerys.getSiteConfigFeatures(CommonFlows.getEmail());
		List<String> listOfFeatures = Arrays.asList(featuresList.split(","));
		for (String feature : getFeatures()) {
			Assert.assertTrue(listOfFeatures.contains(feature));
		}
	}
	
	@Test
	@TestProperties(name = "Validate that the current user does not have the features : ${features} (Via DB)" ,paramsInclude = { "features" })
	public void ValidateCurrentUserFeaturesDoesntContains() throws Exception {
		String featuresList = DBQuerys.getSiteConfigFeatures(CommonFlows.getEmail());
		List<String> listOfFeatures = Arrays.asList(featuresList.split(","));
		for (String feature : getFeatures()) {
			Assert.assertTrue(!listOfFeatures.contains(feature));
		}
	}


	public String[] getFeatures() {
		return features;
	}


	@ParameterProperties(description = "A list of features to validate , Separated by ';'")
	public void setFeatures(String[] features) {
		this.features = features;
	}
	


	
}
