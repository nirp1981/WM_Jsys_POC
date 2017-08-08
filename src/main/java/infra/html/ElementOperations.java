package infra.html;
import static walkme.automation.core.common.FlowExtensions.*;
import org.junit.Test;
import org.openqa.selenium.By;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

public class ElementOperations extends SystemTestCase4 {
	
	public enum SelectorType{
		Id,Xpath,CssSelector,Name;
	}
	
	public enum HtmlOperation{
		Click,Hover,DoubleClick,RightClick;
	}
	
	private String selector;
	private SelectorType selectorType;
	private HtmlOperation htmlOperation;


	public ElementOperations(){
		
	}
	
	@Test
	@TestProperties(name = "Perform ${htmlOperation} on an element found by ${selectorType} equals to '${selector}'" ,paramsInclude = { "selector" ,"selectorType","htmlOperation"})
	public void performCustomHTMLOperation() throws Exception {
		By selector = assembleSelector(getSelectorType(), getSelector());
		performOperation(selector);
	}
	
	private void performOperation(By selector) throws Exception{
		switch (getHtmlOperation()) {
		case Click:
			htmlApi().Elements.click(selector);
			break;
		case DoubleClick:
			htmlApi().Elements.dblClick(selector);
			break;
		case Hover:
			htmlApi().Elements.hover(selector);
			break;
		case RightClick:
			htmlApi().Elements.rightClick(selector);
			break;
		default:
			break;
		}
	}

	private By assembleSelector(SelectorType selectorType , String selector){
		switch (selectorType) {
		case Id:
			return By.id(selector);
		case Xpath:
			return By.xpath(selector);
		case Name:
			return By.name(selector);
		case CssSelector:
			return By.id(selector);
		default:
			break;
		}
		return null;
	}
	
	public String getSelector() {
		return selector;
	}

	@ParameterProperties(description = "Select the type of the selector")
	public void setSelectorType(SelectorType selectorType) {
		this.selectorType = selectorType;
	}
	
	@ParameterProperties(description = "Enter the string of the selector according to its type")
	public void setSelector(String selector) {
		this.selector = selector;
	}

	public SelectorType getSelectorType() {
		return selectorType;
	}

	public HtmlOperation getHtmlOperation() {
		return htmlOperation;
	}

	@ParameterProperties(description = "Select what kind of operation to perform on the element")
	public void setHtmlOperation(HtmlOperation htmlOperation) {
		this.htmlOperation = htmlOperation;
	}
	

	//@ParameterProperties(description = "The WalkThru name that the action will be performed on")
	
}
