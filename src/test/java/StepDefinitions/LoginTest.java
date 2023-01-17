package StepDefinitions;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;

import Pages.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	JSONFileClass file;
	JSONObject user;
	WebDriver driver;
	Loginpage page;

	@Given("navigate to the baseurl")
	public void navigate_to_the_baseurl() throws InterruptedException, IOException, ParseException {

	}

	@When("^user enter valid credentials(.*) and (.*)$")
	public void user_enter_valid_credentials_and(String email, String password)
			throws InterruptedException, IOException, ParseException {

		// file = new JSONFileClass();
		// user = file.readJson();
		// JSONArray userLogin = (JSONArray) user.get("Login");
		//
		// for (int i = 0; i < userLogin.size(); i++) {
		//
		// JSONObject details = (JSONObject) userLogin.get(i);
		// page = new Loginpage(DriverFactory.getDriver());
		// page.enterusername((String) details.get("Email"));
		// page.enterpassword((String) details.get("Password"));
		// Thread.sleep(2000);
		page = new Loginpage(DriverFactory.getDriver());
		page.enterusername(email);
		Thread.sleep(1000);
		page.enterpassword(password);
	}

	@When("^user enter invalid credentials(.*) and (.*)$")
	public void user_enter_invalid_credentials_and(String email, String password)
			throws InterruptedException, IOException, ParseException {

		// file = new JSONFileClass();
		// user = file.readJson();
		// JSONArray userLogin = (JSONArray) user.get("Login");
		//
		// for (int i = 0; i < userLogin.size(); i++) {
		//
		// JSONObject details = (JSONObject) userLogin.get(i);
		// page = new Loginpage(DriverFactory.getDriver());
		// page.enterusername((String) details.get("Email"));
		// page.enterpassword((String) details.get("Password"));
		// Thread.sleep(2000);
		page = new Loginpage(DriverFactory.getDriver());
		page.enterusername(email);
		Thread.sleep(2000);
		page.enterpassword(password);
	}

	@Then("^clicks login button$")
	public void clicks_login_button() throws InterruptedException {
		page = new Loginpage(DriverFactory.getDriver());
		page.clickloginbutton();
		Thread.sleep(2000);
	}

	@Then("^validate Login success message$")
	public void validate_login_success_message() throws IOException, ParseException, Exception {
		page = new Loginpage(DriverFactory.getDriver());
		page.LoginSuccessfullMsg();

	}

	@Then("^validate Login error message$")
	public void validate_login_error_message() throws Exception, ParseException, Exception {
		page = new Loginpage(DriverFactory.getDriver());
		page.LoginErrorMsg();

	}
}
