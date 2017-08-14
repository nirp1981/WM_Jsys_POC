package walkme.analytics;
import static walkme.automation.core.common.FlowExtensions.analyticsService;

import org.junit.Test;

import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;
import walkme.automation.core.testsetup.CommonFlows;

public class Login extends SystemTestCase4 {

	private String email;
	private String password;
	
	public Login(){
		
	}
	
	
	@Test
	@TestProperties(name = "Login to the Walkme analytics with user" ,paramsInclude = { "email", "password"})
	public void LoginWithUser() throws Exception {
		analyticsService().LogInOut.loginIfNotLoggedIn(getEmail(),getPassword());
	}
	
	@Test
	@TestProperties(name = "LoginOut from Walkme analytics")
	public void LogOut() throws Exception {
		analyticsService().LogInOut.logOut();
	}
	
	
	@Test
	@TestProperties(name = "Login to the Walkme analytics with the current test user")
	public void LoginWithCurrentUser() throws Exception {
		analyticsService().LogInOut.loginIfNotLoggedIn(CommonFlows.getEmail(), CommonFlows.getPassword());
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
}

