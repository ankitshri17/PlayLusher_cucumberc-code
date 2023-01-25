package StepDefinitions;

import java.io.IOException;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;

import Pages.Credentialspage;
import Pages.Loginpage;
import Pages.Projectpage;
import io.cucumber.java.en.Then;

public class CredentialsTest {
	WebDriver driver;
	Loginpage page;
	Projectpage project;
	JSONFileClass file;
	JSONObject user;
	Credentialspage credentials;

	@Then("^click on credentials icon$")
	public void click_on_credentials_icon() throws InterruptedException {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.ClickOnCredentialsIcon();

	}

	@Then("^click on credential edit button$")
	public void click_on_credential_edit_button() {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.ClickOnEditButton();

	}

	@Then("^enter credential description$")
	public void enter_credential_description() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray CreadentialsArray = (JSONArray) user.get("Credentials");

		for (int i = 0; i < CreadentialsArray.size(); i++) {
			JSONObject details = (JSONObject) CreadentialsArray.get(i);
			long number = (long) new Date().getTime();

			credentials.enterDescriptionOfCredential((String) details.get("CredentialsDescription") + number);

		}

	}

	@Then("^credential upload file$")
	public void credential_upload_file() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.CredentialUploadFileButton();

	}

	@Then("^enter the comment$")
	public void enter_the_comment() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray CommentArray = (JSONArray) user.get("Credentials");

		for (int i = 0; i < CommentArray.size(); i++) {
			JSONObject details = (JSONObject) CommentArray.get(i);
			long number = (long) new Date().getTime();

			credentials.enterCommentOfCredential((String) details.get("CredentialsComment") + number);

		}

	}

	@Then("^upload file for comment$")
	public void upload_file_for_comment() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.CommentUploadFileButton();

	}

	@Then("^click on post comment button$")
	public void click_on_post_comment_button() {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.ClickOnPostButton();
	}

	@Then("^click on save button$")
	public void click_on_save_button() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.ClickOnSaveButton();

	}

	@Then("enter updated credential description")
	public void enter_updated_credential_description() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray UpdatedCreadentialsArray = (JSONArray) user.get("Credentials");

		for (int i = 0; i < UpdatedCreadentialsArray.size(); i++) {
			JSONObject details = (JSONObject) UpdatedCreadentialsArray.get(i);
			long number = (long) new Date().getTime();

			credentials.enterUpdatedDescriptionOfCredential(
					(String) details.get("UpdatedCredentialsDescription") + number);

		}

	}

	@Then("enter updated comment")
	public void enter_updated_comment() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray UpdatedCommentArray = (JSONArray) user.get("Credentials");

		for (int i = 0; i < UpdatedCommentArray.size(); i++) {
			JSONObject details = (JSONObject) UpdatedCommentArray.get(i);

			credentials.enterUpdatedCommentOfCredential((String) details.get("UpdatedCredentialsComment"));

		}

	}

	@Then("^validate credential message and comment message$")
	public void validate_credential_message_and_comment_message() throws Exception {
		credentials = new Credentialspage(DriverFactory.getDriver());
		credentials.CredentialCreateMessage();
		credentials.CredentialCommentCreateMessage();

	}

}
