package walkme.analytics;

import static walkme.automation.core.common.FlowExtensions.analyticsService;

import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.analytics.elements.AnalyticsGeneralFrame.AnalyticsPanes;
import walkme.automation.core.testsetup.CommonFlows;

public class Navigation extends SystemTestCase4 {

	private AnalyticsPanes pane;
	
	public Navigation(){
		
	}
	
	@Test
	@TestProperties(name = "Navigate to the Walkme analytics URL")
	public void NavigateToAnalyticsURL() throws Exception {
		 CommonFlows.navigateToAnalyticsPage();
	}

	@Test
	@TestProperties(name = "Go to analytics ${pane}" , paramsInclude = {"pane"})
	public void GoToAnalyticsPane() throws Exception {
		analyticsService().AnalyticsFrame.clickPane(getPane());
	}

	public AnalyticsPanes getPane() {
		return pane;
	}

	public void setPane(AnalyticsPanes pane) {
		this.pane = pane;
	}

	
}