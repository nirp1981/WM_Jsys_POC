package walkme.portal.features;

import static walkme.automation.core.common.FlowExtensions.editorService;

import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.portal.elements.ManageFeatures;
import wrappers.CommonEnums.CheckedState;
import wrappers.CommonEnums.EnabledState;
import wrappers.CommonEnums.PageState;

public class FeaturesPage extends SystemTestCase4 {

	private ManageFeatures.Features feature;
	private PageState pageState;
	private CheckedState checkedState;
	private EnabledState enabledState;
	private String nameText;
	

	
	public FeaturesPage(){
		
	}
	
	@Test
	@TestProperties(name = "Go to the portal features page"  ,paramsInclude = { "" })
	public void goToFeaturesPage() throws Exception {
		editorService().SwitchPages.goToManageFeatures();
	}


	@Test
	@TestProperties(name = "Select the feature/plugin '${feature}'"  ,paramsInclude = { "feature" })
	public void selectFeaturePlugin() throws Exception {
		editorService().ManageFeatures.setFeature(getFeature(),true,false);
	}

	@Test
	@TestProperties(name = "Unselect the feature/plugin '${feature}'"  ,paramsInclude = { "feature" })
	public void unSelectFeaturePlugin() throws Exception {
		editorService().ManageFeatures.setFeature(getFeature(),false,false);
	}
	
	@Test
	@TestProperties(name = "Save the portal features page" ,paramsInclude = { "" })
	public void savePage() throws Exception {
		editorService().ManageFeatures.closeManageFeatures(true);
	}
	
	@Test
	@TestProperties(name = "Cancel the portal features page",paramsInclude = { "" })
	public void cancelPage() throws Exception {
		editorService().ManageFeatures.closeManageFeatures(false);
	}
	
	@Test
	@TestProperties(name = "Validate that the portal features page state is '${pageState}'"  ,paramsInclude = { "pageState" })
	public void validatePageState() throws Exception {
		editorService().ManageFeatures.validatePageState(getPageState().toState());
	}
	
	@Test
	@TestProperties(name = "Validate that the features page/plugin '${feature}' checked state is '${checkedState}'"  ,paramsInclude = { "feature", "checkedState" })
	public void validateFeaturePluginCheckedState() throws Exception {
		editorService().ManageFeatures.validateFeatureChecked(getFeature(), getCheckedState().toState());
	}
	
	@Test
	@TestProperties(name = "Validate that the features page/plugin '${feature}' enabled state is '${enabledState}'"  ,paramsInclude = { "feature", "enabledState" })
	public void validateFeaturePluginDisabledState() throws Exception {
		editorService().ManageFeatures.validateCheckBoxDisable(getFeature(), !getEnabledState().toState());
	}
	
	@Test
	@TestProperties(name = "Validate that the features page/plugin '${feature}' name text contains '${nameText}'"  ,paramsInclude = { "feature", "nameText" })
	public void validateFeaturePluginNameText() throws Exception {
		editorService().ManageFeatures.validateFeatureNameText(getFeature(), getText());
	}
	
	@Test
	@TestProperties(name = "Validate that the features page/plugin '${feature}' description text contains '${nameText}'"  ,paramsInclude = { "feature", "nameText" })
	public void validateFeaturePluginDescriptionText() throws Exception {
		editorService().ManageFeatures.validateDescriptionContainText(getFeature(), getText());
	}
	
	@Test
	@TestProperties(name = "DOES NOT WORK FOR NOW UNTIL WM-31094 WILL BE SOLVED"  ,paramsInclude = {"nameText" })
	public void searchFeaturePlugin() throws Exception {
		editorService().ManageFeatures.searchFeature(getText());
	}
	
	public ManageFeatures.Features getFeature() {
		return feature;
	}

	public void setFeature(ManageFeatures.Features feature) {
		this.feature = feature;
	}

	public PageState getPageState() {
		return pageState;
	}

	public void setPageState(PageState pageState) {
		this.pageState = pageState;
	}

	public CheckedState getCheckedState() {
		return checkedState;
	}

	public void setCheckedState(CheckedState checkedState) {
		this.checkedState = checkedState;
	}

	public EnabledState getEnabledState() {
		return enabledState;
	}

	public void setEnabledState(EnabledState enabledState) {
		this.enabledState = enabledState;
	}

	public String getText() {
		return nameText;
	}

	public void setText(String text) {
		this.nameText = text;
	}

	
}