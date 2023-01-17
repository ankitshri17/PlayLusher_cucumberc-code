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

public class Taskpage {
	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;

	@FindBy(xpath = "//span[contains(text(),'Add Task')]")
	WebElement Add_task_Button;

	@FindBy(xpath = "//input[@id='taskName']")
	WebElement task_name;

	@FindBy(xpath = "//div[@class='ql-editor ql-blank']//p")
	WebElement task_detail;

	@FindBy(xpath = "//mat-label[contains(text(),'Bucket')]")
	WebElement click_bucket_dropdown;

	@FindBy(xpath = "//span[@class='mat-option-text'][normalize-space()='Backlog']")
	WebElement select_backlog_option;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement save_button;

	@FindBy(xpath = "//div[@aria-label='Task created successfully.']")
	WebElement task_create_message;

	@FindBy(xpath = "//a[@class='new-task-heading ng-star-inserted']")
	WebElement Backlog_ticket;

	@FindBy(xpath = "//input[@id='taskName']")
	WebElement update_task_name;

	@FindBy(xpath = "//div[@data-placeholder='Insert text here ...']")
	WebElement update_task_detail;

	@FindBy(xpath = "//span[contains(text(),' Ready for development ')]")
	WebElement update_bucket_option;

	@FindBy(xpath = "//div[@data-placeholder='Add comment or attachment...']")
	WebElement task_comment;

	@FindBy(xpath = "//button[normalize-space()='Post Comment']")
	WebElement post_comment_button;

	@FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-update mat-raised-button mat-button-base']")
	WebElement Save_button_for_update;

	@FindBy(xpath = "//div[@aria-label='Task updated successfully.']")
	WebElement update_task_message;

	public Taskpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClicksOnTaskButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Add_task_Button);
		util.waitForElementJavaScript(Add_task_Button);

	}

	public void EnterTaskName(String TaskName) {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(task_name);
		task_name.sendKeys(TaskName);

	}

	public void EnterTaskDetail(String TaskDetail) {

		util = new WebDriverUtil();
		util.waitForElementVisiblity(task_detail);
		task_detail.sendKeys(TaskDetail);

	}

	public void ClickOnBucketDropDown() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_bucket_dropdown);
		util.waitForElementJavaScript(click_bucket_dropdown);

	}

	public void SelectBacklogOption() {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(select_backlog_option);
		select_backlog_option.isDisplayed();
		if (select_backlog_option.isDisplayed()) {
			System.out.println("Backlog option is dispalyed");
		} else {

			System.out.println("Backlog option is not displayed");
		}

	}

	public void ClicksOnSaveButton() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(save_button);
		util.waitForElementJavaScript(save_button);
		Thread.sleep(1000);

	}

	public void TaskCreateMessageDisplay() throws Exception {
		Thread.sleep(1000);
		String actual = task_create_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray TaskSuccessMessageArray = (JSONArray) user.get("TaskMessage");

		for (int i = 0; i < TaskSuccessMessageArray.size(); i++) {

			JSONObject details = (JSONObject) TaskSuccessMessageArray.get(i);
			String expected = (String) details.get("TaskSuccessMessage");
			Assert.assertEquals(actual, expected);

		}

	}

	public void ClickOnBcklogTicket() {

		Backlog_ticket.click();
	}

	public void UpdateTaskName(String UpdateTaskName) throws Exception {

		util = new WebDriverUtil();
		util.waitForElementVisiblity(update_task_name);
		update_task_name.clear();
		update_task_name.sendKeys(UpdateTaskName);
		Thread.sleep(1000);

	}

	public void UpdateTaskDetail(String UpdateTaskDetail) throws Exception {

		util = new WebDriverUtil();
		util.waitForElementVisiblity(update_task_name);
		update_task_detail.clear();
		update_task_detail.sendKeys(UpdateTaskDetail);

		Thread.sleep(2000);

	}

	public void UpdateBucketOption() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(update_bucket_option);
		util.waitForElementJavaScript(update_bucket_option);
		Thread.sleep(2000);

	}

	public void TaskComment(String Comment) {

		util = new WebDriverUtil();
		util.waitForElementVisiblity(task_comment);
		task_comment.sendKeys(Comment);

	}

	public void ClickOnPostCommentButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(post_comment_button);
		util.waitForElementJavaScript(post_comment_button);

	}

	public void ClickOnSaveButtonForUpdate() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Save_button_for_update);
		util.waitForElementJavaScript(Save_button_for_update);
		Thread.sleep(1000);

	}

	public void UpdateTaskMessageDisplay() throws Exception, ParseException {

		Thread.sleep(1000);
		String actual = update_task_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray TaskUpdateMessageArray = (JSONArray) user.get("TaskMessage");

		for (int i = 0; i < TaskUpdateMessageArray.size(); i++) {

			JSONObject details = (JSONObject) TaskUpdateMessageArray.get(i);
			String expected = (String) details.get("TaskUpdateMessage");
			Assert.assertEquals(actual, expected);

		}

	}

}
