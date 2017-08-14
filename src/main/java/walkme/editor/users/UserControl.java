package walkme.editor.users;

import static walkme.automation.core.common.FlowExtensions.editorService;

import org.junit.Test;

import jsystem.framework.ParameterProperties;
import jsystem.framework.TestProperties;
import junit.framework.SystemTestCase4;

public class UserControl extends SystemTestCase4 {

	private String password;
	private String email;

	public UserControl(){
		
	}
	
	/**
	 * This function creates a new user via the create user editor screen.
	 * -You must be logged in in order to use it
	 * -After the new user is created , it will login and become the default user of the test
	 * @throws Exception
	 */
	@Test
	@TestProperties(name = "Create a new random user via the editor" ,paramsInclude = { "" } , returnParam = {"userEmail"})
	public String createNewRandomUserAccount() throws Exception {
		String email = editorService().LogInOut.createNewRandomAccountAndSetUser(true, true);
		return email;
	}
	
	/**
	 * This function creates a new user via the create user editorAPI.
	 * -After the new user is created , it will login and become the default user of the test
	 * @throws Exception
	 */
	@Test
	@TestProperties(name = "Create a new random user via the editor API" ,paramsInclude = { "" } , returnParam = {"userEmail"})
	public String createNewRandomUserAccountFast() throws Exception {
		String email =  editorService().LogInOut.createNewRandomAccountInProd();
		editorService().LogInOut.logOut();
		editorService().LogInOut.loginMainUser();
		return email;
	}
	
	


	public String getPassword() {
		return password;
	}

	@ParameterProperties(description = "Set the password , make sure it is applicable with the system requirements")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	//
 





	
}
