package Pages;

import java.awt.AWTException;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.factory.DriverFactory;
import com.qa.factory.WebDriverUtil;
import com.qa.util.JSONFileClass;

public class Taskpage {
	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;
	Labelpage Label;

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

	@FindBy(xpath = "//div[@class='custom-editor ql-toolbar ql-snow']//span[@class='mat-button-wrapper'][normalize-space()='UPLOAD']")
	WebElement upload_file_button;

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

	@FindBy(xpath = "//mat-label[contains(text(),'Labels')]")
	WebElement click_label_dropdown;

	@FindBy(xpath = "//span[contains(text(),' Automation ')]")
	WebElement select_label_option;

	@FindBy(xpath = "//div[@data-placeholder='Add comment or attachment...']")
	WebElement task_comment;

	@FindBy(xpath = "//button[normalize-space()='Post Comment']")
	WebElement post_comment_button;

	@FindBy(xpath = "//span[contains(text(),'All')]")
	WebElement scrollview;

	@FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-update mat-raised-button mat-button-base']")
	WebElement Save_button_for_update;

	@FindBy(xpath = "//div[@aria-label='Task updated successfully.']")
	WebElement update_task_message;

	@FindBy(xpath = "//button[@class='mat-focus-indicator btn btn-delete show-hide-delete width-del mat-raised-button mat-button-base ng-star-inserted']")
	WebElement click_delete_button;

	@FindBy(xpath = "//span[contains(text(),'Delete')]")
	WebElement delete_button_from_modal;

	@FindBy(xpath = "//div[@aria-label='Task deleted successfully.']")
	WebElement Delete_task_message;

	@FindBy(xpath = "//div[contains(text(),' In Progress (0) ')]//following-sibling::div[@class='kanban-row-container']")
	WebElement target_ticket;

	// div[contains(text(),' In Progress (0)
	// ')]//following-sibling::div[@class='kanban-row-container']

	// @FindBy(xpath = "//div[@class='kanban_box_main content_Section kanban-view
	// ng-star-inserted']//div[3]")
	// WebElement target_ticket;

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
			System.out.println("Backlog option is displayed");
		} else {

			System.out.println("Backlog option is not displayed");
		}

	}

	public void ClickOnUploadButton() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(upload_file_button);
		util.waitForElementJavaScript(upload_file_button);
		Thread.sleep(1000);

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

	public void ClickOnBcklogTicket() throws InterruptedException {
		Actions action = new Actions(DriverFactory.getDriver());
		// action.build().perform();
		action.moveToElement(Backlog_ticket).build().perform();
		Thread.sleep(2000);
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
		Thread.sleep(1000);

	}

	public void ClickOnLabelDropdown() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_label_dropdown);
		util.waitForElementJavaScript(click_label_dropdown);

	}

	public void SelectLabelOption() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(select_label_option);
		util.waitForElementJavaScript(select_label_option);
		Thread.sleep(1000);

	}

	// public void hitEscapeKey() throws InterruptedException {
	// Actions action = new Actions(DriverFactory.getDriver());
	// action.sendKeys(Keys.ESCAPE).build().perform();
	//
	// }

	public void TaskComment(String Comment) throws Exception {

		util = new WebDriverUtil();
		util.waitForElementToBeClickable(task_comment);
		task_comment.sendKeys(Comment);

	}

	public void ClickOnPostCommentButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(post_comment_button);
		util.waitForElementJavaScript(post_comment_button);

	}

	public void scrollviewcomment() throws Exception {
		util = new WebDriverUtil();
		util.javaViewPoint(scrollview);
		JavascriptExecutor jse2 = (JavascriptExecutor) DriverFactory.getDriver();
		jse2.executeScript("arguments[0].scrollIntoView()", scrollview);
		Thread.sleep(1000);

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

	public void ClickOnDeleteButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_delete_button);
		util.waitForElementJavaScript(click_delete_button);
		util.waitForElementToBeClickable(delete_button_from_modal);
		util.waitForElementJavaScript(delete_button_from_modal);

	}

	public void DeleteTaskMessageDisplay() throws Exception, ParseException {

		Thread.sleep(2000);
		String actual = Delete_task_message.getText();
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray TaskDeleteMessageArray = (JSONArray) user.get("TaskMessage");

		for (int i = 0; i < TaskDeleteMessageArray.size(); i++) {

			JSONObject details = (JSONObject) TaskDeleteMessageArray.get(i);
			String expected = (String) details.get("TaskDeleteMessage");
			Assert.assertEquals(actual, expected);

		}

	}

	public void FileUpload() throws InterruptedException, AWTException, IOException {
		// Robot robot = new Robot();
		// task.ClickOnUploadButton();
		// String path = "src/test/resources/Files/developer.png";

		// Convert the URL into a URI.
		// URI uri = path.toUri();

		// Load the file from the URI.
		// File file = new File(path);

		// Get the absolute path to the file.
		// String absolutePath = file.getAbsolutePath();

		// Use the absolute path with Selenium.
		// upload_file_button.sendKeys(absolutePath);
		// Thread.sleep(5000);
		// upload_file_button.click();
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(upload_file_button);
		util.waitForElementJavaScript(upload_file_button);
		Thread.sleep(5000);
		// upload_file_button.click();
		// Thread.sleep(2000);
		Runtime.getRuntime().exec(
				"C:\\Users\\ui-qa-22-1\\Documents\\PlayLusher\\PlayLusher\\src\\test\\resources\\Files\\FileUploadscript.exe");
		Thread.sleep(2000);

		// store the path of the file to be uploaded using StringSelection class object
		// StringSelection filepath = new StringSelection(
		// "C:\\Users\\ui-qa-22-1\\Documents\\PlayLusher\\PlayLusher\\src\\test\\resources\\Files\\developer.png");
		//
		// // copy above path to clipboard
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// //
		// // // Now press CTRL
		// robot.keyPress(KeyEvent.VK_CONTROL);
		// //
		// // // Now press V
		// robot.keyPress(KeyEvent.VK_V);
		// //
		// // // Now release V
		// robot.keyRelease(KeyEvent.VK_CONTROL);
		// robot.keyRelease(KeyEvent.VK_V);
		// //
		// // // Now release CTRL
		// //
		// // // Now Press Enter
		// robot.keyPress(KeyEvent.VK_ENTER);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		// Thread.sleep(30000);
		//
		System.out.println("file is uploaded successfully");
		//
	}

	// public void dragAndDrop() throws InterruptedException {
	// Thread.sleep(5000);
	// util = new WebDriverUtil();
	// Actions action = new Actions(DriverFactory.getDriver());
	// Action dragAndDrop =
	// action.clickAndHold(Backlog_ticket).moveToElement(target_ticket).release(target_ticket)
	// .click().build();
	// dragAndDrop.perform();
	// }

}
