package Pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.factory.WebDriverUtil;
import com.qa.util.JSONFileClass;

public class Credentialspage {
	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;
	Loginpage page;
	Projectpage project;

	@FindBy(xpath = "//a[@title='Credentials']")
	WebElement credential_icon;

	@FindBy(xpath = "//button[@type='button']//span[@class='mat-button-wrapper'][normalize-space()='Edit']")
	WebElement edit_button;

	@FindBy(xpath = "//div[@data-placeholder='Insert text here ...']//p")
	WebElement enter_credential_description;

	@FindBy(xpath = "//div[@class='custom-editor ql-toolbar ql-snow']//span[@class='mat-button-wrapper'][normalize-space()='UPLOAD']")
	WebElement credential_upload_file_button;

	@FindBy(xpath = "//div[@data-placeholder='Add comment or attachment...']//p")
	WebElement enter_comment;

	@FindBy(xpath = "//div[@class='custom-editor hide-toolbar-init ql-toolbar ql-snow']//span[@class='mat-button-wrapper'][normalize-space()='UPLOAD']")
	WebElement comment_upload_file_button;

	@FindBy(xpath = "//button[normalize-space()='Post Comment']")
	WebElement Click_PostComment_Btn;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement click_save_button;

	@FindBy(xpath = "//div[@aria-label='Credential created successfully.']")
	WebElement credential_message;

	@FindBy(xpath = "//div[@aria-label='Comment created successfully.']")
	WebElement comment_message;

	public Credentialspage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnCredentialsIcon() throws InterruptedException {
		util = new WebDriverUtil();
		Thread.sleep(2000);
		util.waitForElementToBeClickable(credential_icon);
		util.waitForElementJavaScript(credential_icon);

	}

	public void ClickOnEditButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(edit_button);
		util.waitForElementJavaScript(edit_button);

	}

	public void enterDescriptionOfCredential(String CredentialsDescription) throws Exception {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_credential_description);
		enter_credential_description.sendKeys(CredentialsDescription);
		Thread.sleep(2000);

	}

	public void CredentialUploadFileButton() throws Exception {

		util = new WebDriverUtil();
		util.waitForElementToBeClickable(credential_upload_file_button);
		util.waitForElementJavaScript(credential_upload_file_button);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\ui-qa-22-1\\Documents\\PlayLusher\\PlayLusher\\src\\test\\resources\\Files\\FileUploadscript.exe");
		Thread.sleep(2000);

		System.out.println("file is uploaded successfully");
	}

	public void enterCommentOfCredential(String CredentialsComment) throws Exception {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_comment);
		enter_comment.sendKeys(CredentialsComment);
		Thread.sleep(2000);

	}

	public void CommentUploadFileButton() throws Exception {

		util = new WebDriverUtil();
		util.waitForElementToBeClickable(comment_upload_file_button);
		util.waitForElementJavaScript(comment_upload_file_button);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\ui-qa-22-1\\Documents\\PlayLusher\\PlayLusher\\src\\test\\resources\\Files\\FileUploadscript.exe");
		Thread.sleep(2000);

		System.out.println("file is uploaded successfully");
	}

	public void ClickOnPostButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Click_PostComment_Btn);
		util.waitForElementJavaScript(Click_PostComment_Btn);

	}

	public void ClickOnSaveButton() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_save_button);
		util.waitForElementJavaScript(click_save_button);

	}

	public void enterUpdatedDescriptionOfCredential(String UpdatedCredentialsDescription) throws Exception {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_credential_description);
		enter_credential_description.clear();
		enter_credential_description.sendKeys(UpdatedCredentialsDescription);
		Thread.sleep(2000);

	}

	public void enterUpdatedCommentOfCredential(String UpdatedCredentialsComment) throws Exception {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_comment);
		enter_comment.clear();
		enter_comment.sendKeys(UpdatedCredentialsComment);
		Thread.sleep(2000);

	}

	public void CredentialCreateMessage() throws Exception {
		Thread.sleep(1000);
		String actual = credential_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray credentialSuccessMessageArray = (JSONArray) user.get("Credentials");

		for (int i = 0; i < credentialSuccessMessageArray.size(); i++) {

			JSONObject details = (JSONObject) credentialSuccessMessageArray.get(i);
			String expected = (String) details.get("CreateCredentialMessage");
			Assert.assertEquals(actual, expected);

		}

	}

	public void CredentialCommentCreateMessage() throws Exception {

		String actual = comment_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray credentialCommentSuccessMessageArray = (JSONArray) user.get("Credentials");

		for (int i = 0; i < credentialCommentSuccessMessageArray.size(); i++) {

			JSONObject details = (JSONObject) credentialCommentSuccessMessageArray.get(i);
			String expected = (String) details.get("CommentCreateMessage");
			Assert.assertEquals(actual, expected);

		}

	}

}
