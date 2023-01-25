package Pages;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.factory.DriverFactory;
import com.qa.factory.WebDriverUtil;
import com.qa.util.JSONFileClass;

public class Projectpage {

	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;

	@FindBy(xpath = "//span[contains(text(),'menu')]")
	WebElement humberger_icon;

	@FindBy(xpath = "//span[normalize-space()='Projects']")
	WebElement project_tab;

	@FindBy(xpath = "//span[contains(text(),'Add Project')]")
	WebElement Add_project_btn;

	@FindBy(xpath = "//input[@id='ProjectId']")
	WebElement enter_project_title;

	@FindBy(xpath = "//span[normalize-space()='Save project']")
	WebElement Save_project_btn;

	@FindBy(xpath = "//div[@aria-label='Project created successfully.']")
	WebElement project_create_msg;

	@FindBy(xpath = "//a[@title='Edit']")
	WebElement Click_Edit_Btn;
	
	//div[@class='col-md-7 col-sm-12 col-2 d-flex d-sm-block justify-content-end']//i[@class='fa fa-pencil-square-o fa-2x']

	@FindBy(name = "project_name")
	WebElement Update_Project_Title;

	@FindBy(xpath = "//label[normalize-space()='Public']")
	WebElement Update_visibility;

	@FindBy(name = "project_tags")
	WebElement Update_project_handle;

	@FindBy(xpath = "//mat-label[contains(text(),'Project Members')]")
	WebElement Click_project_member_dropdown;

	@FindBy(xpath = "//span[normalize-space()='aaaa bbbb']")
	WebElement add_project_member;

	@FindBy(xpath = "//mat-label[contains(text(),'Visible Buckets')]")
	WebElement click_visible_bucket_dropdown;

	@FindBy(xpath = "//span[normalize-space()='Ready for development']")
	WebElement Bucket;

	@FindBy(xpath = "//span[normalize-space()='Update']")
	WebElement Update_button;

	@FindBy(xpath = "//div[@aria-label='Project updated successfully.']")
	WebElement project_update_message;

	@FindBy(xpath = "//button[@data-target='#deleteProject']")
	WebElement Project_Delete_Button;

	@FindBy(xpath = "//button[normalize-space()='Delete']")
	WebElement Delete_button;

	@FindBy(xpath = "//div[@aria-label='Project deleted successfully.']")
	WebElement project_Deleted_message;

	//SoftAssert softassert = new SoftAssert();

	public Projectpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// public void Hamburgericon() {
	// util = new WebDriverUtil();
	// util.waitForElementToBeClickable(humberger_icon);
	// util.waitForElementJavaScript(humberger_icon);
	// }

	public void ProjectTab() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(project_tab);
		util.waitForElementJavaScript(project_tab);

	}

	public void AddProjectButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Add_project_btn);
		util.waitForElementJavaScript(Add_project_btn);

	}

	public void EnterProjectTitle(String ProjectTitle) {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_project_title);
		enter_project_title.sendKeys(ProjectTitle);
	}

	public void ClickSaveProjectButton() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Save_project_btn);
		util.waitForElementJavaScript(Save_project_btn);
		Thread.sleep(1000);

	}

	public void ProjectCreateSuccessfully() throws Exception {
		Thread.sleep(1000);
		String actual = project_create_msg.getText();

		file = new JSONFileClass();
		user = file.readJson();
		JSONArray CreatemessageArray = (JSONArray) user.get("ProjectMessage");

		for (int i = 0; i < CreatemessageArray.size(); i++) {

			JSONObject details = (JSONObject) CreatemessageArray.get(i);
			String expected = (String) details.get("CreateMessage");
			Assert.assertEquals(actual, expected);

		}

	}

	public void ClickonEditIcon() throws InterruptedException {
		Thread.sleep(1000);
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Click_Edit_Btn);
		util.waitForElementJavaScript(Click_Edit_Btn);
		Thread.sleep(2000);

	}

	public void UpdateProjectTitle(String UpdateProjectTitle) throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(Update_Project_Title);
		Update_Project_Title.clear();
		Update_Project_Title.sendKeys(UpdateProjectTitle);
		

	}

	public void visibilityUpdated() throws InterruptedException {

		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Update_visibility);
		util.waitForElementJavaScript(Update_visibility);
		

	}

	public void UpdateProjectHandle(String UpdateProjectHandle) throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(Update_project_handle);
		Update_project_handle.clear();
		Update_project_handle.sendKeys(UpdateProjectHandle);

	}

	public void ClickOnProjectMemberDropDown() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(Click_project_member_dropdown);
		util.waitForElementJavaScript(Click_project_member_dropdown);
	}

	public void AddProjectMember() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(add_project_member);
		util.waitForElementJavaScript(add_project_member);
		Thread.sleep(2000);

	}

	public void hitEscapeKey() throws InterruptedException {
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.ESCAPE).build().perform();
		
	}

	public void ClickVisibleBucketDropDown() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_visible_bucket_dropdown);
		util.waitForElementJavaScript(click_visible_bucket_dropdown);
		

	}

	public void DeSelectVisibleBucket() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Bucket);
		util.waitForElementJavaScript(Bucket);
		Thread.sleep(1000);

	}

	public void ClickOnUpdateButton() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Update_button);
		util.waitForElementJavaScript(Update_button);

	}

	public void ProjectUpdateMessageDisplay() throws Exception {
		Thread.sleep(1000);
		String actual = project_update_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray updateArray = (JSONArray) user.get("ProjectMessage");

		for (int i = 0; i < updateArray.size(); i++) {
			JSONObject details = (JSONObject) updateArray.get(i);
			String expected = (String) details.get("UpdateMessage");
			Assert.assertEquals(actual, expected);
		}
	}

	public void ClickOnProjectDeleteButton() throws InterruptedException {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Project_Delete_Button);
		util.waitForElementJavaScript(Project_Delete_Button);
		Thread.sleep(1000);

	}

	public void DeleteButtonFromModal() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Delete_button);
		util.waitForElementJavaScript(Delete_button);

	}

	public void ProjectDeletedMessageDisplay() throws Exception {
		Thread.sleep(1000);

		String actual = project_Deleted_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray messageArray = (JSONArray) user.get("ProjectMessage");

		for (int i = 0; i < messageArray.size(); i++) {
			JSONObject details = (JSONObject) messageArray.get(i);
			String expected = (String) details.get("DeleteMessage");
			Assert.assertEquals(actual, expected);
		}
	}
}
