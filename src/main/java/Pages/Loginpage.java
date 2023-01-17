package Pages;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.factory.WebDriverUtil;
import com.qa.util.JSONFileClass;

public class Loginpage {
	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;

	@FindBy(name = "email")
	WebElement email_txtbx;

	@FindBy(name = "password")
	WebElement password_txtbx;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement click_btn;

	@FindBy(xpath = "//div[@aria-label='Login success']")
	WebElement login_success_msg;

	@FindBy(xpath = "//div[@aria-label='Invalid credentials.']")
	WebElement login_errormsg;

	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterusername(String email) {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(email_txtbx);
		email_txtbx.sendKeys(email);
	}

	public void enterpassword(String password) {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(password_txtbx);
		password_txtbx.sendKeys(password);

	}

	public void clickloginbutton() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_btn);
		util.waitForElementJavaScript(click_btn);

	}

	public void LoginSuccessfullMsg() throws IOException, ParseException {
		String actual = login_success_msg.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray SuccessMessageArray = (JSONArray) user.get("LoginMessage");

		for (int i = 0; i < SuccessMessageArray.size(); i++) {

			JSONObject details = (JSONObject) SuccessMessageArray.get(i);
			String expected = (String) details.get("SuccessMessage");
			Assert.assertEquals(actual, expected);

		}

	}

	public void LoginErrorMsg() throws Exception {
		Thread.sleep(1000);
		String actual = login_errormsg.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray InvalidMessageArray = (JSONArray) user.get("LoginMessage");

		for (int i = 0; i < InvalidMessageArray.size(); i++) {

			JSONObject details = (JSONObject) InvalidMessageArray.get(i);
			String expected = (String) details.get("InvalidMessage");
			Assert.assertEquals(actual, expected);

		}
	}
}
