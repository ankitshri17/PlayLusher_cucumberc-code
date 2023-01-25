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

import com.qa.factory.DriverFactory;
import com.qa.factory.WebDriverUtil;
import com.qa.util.JSONFileClass;

public class Reportpage {

	WebDriver driver;
	Loginpage page;
	Projectpage project;
	JSONFileClass file;
	JSONObject user;

	WebDriverUtil util;

	@FindBy(xpath = "//span[normalize-space()='Reports']")
	WebElement Report_tab;

	@FindBy(xpath = "//span[@class='btn_text']")
	WebElement click_Add_report_button;

	@FindBy(xpath = "//div[@data-placeholder='Insert text here ...']")
	WebElement enter_Description;

	@FindBy(xpath = "//input[@id='billing']")
	WebElement enter_billed_hours;

	@FindBy(xpath = "//mat-select[@id='mat-select-2']")
	WebElement click_on_plateform_dropdown;

	@FindBy(xpath = "//span[contains(text(),' UI-Meter ')]")
	WebElement select_plateform;

	@FindBy(xpath = "//mat-select[@id='mat-select-4']")
	WebElement Click_on_users_dropdown;

	@FindBy(xpath = "//span[normalize-space()='aaaa bbbb']")
	WebElement select_user;

	@FindBy(xpath = "//span[normalize-space()='Submit']")
	WebElement submit_button;

	@FindBy(xpath = "//tbody[@role='rowgroup']//tr[1]//td[5]//span")
	WebElement report_edit_button;

	// mat-select[@id='mat-select-2']//child::span[contains(text(),'Upwork (Ram)')]
	@FindBy(xpath = "//mat-select[@id='mat-select-2']//child::span[contains(text(),'UI-Meter')]")
	WebElement update_plateform_dropdown;

	@FindBy(xpath = "//span[normalize-space()='Upwork (Desh)']")
	WebElement select_updated_plateform;

	@FindBy(xpath = "//mat-select[@id='mat-select-4']")
	WebElement update_users_dropdown;

	@FindBy(xpath = "//span[normalize-space()='aman sharma']")
	WebElement select_updated_user;

	@FindBy(xpath = "//span[normalize-space()='Update']")
	WebElement update_button;

	@FindBy(xpath = "//div[@aria-label='Report created successfully.']")
	WebElement report_create_message;
	
	@FindBy(xpath = "//div[@aria-label='Report updated successfully.']")
	WebElement report_updated_message;
	
	

	public Reportpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnReportTab() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Report_tab);
		util.waitForElementJavaScript(Report_tab);
	}

	public void clickOnAddReportButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_Add_report_button);
		util.waitForElementJavaScript(click_Add_report_button);
	}

	public void enterDescriptionOfReport(String Description) throws Exception {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_Description);
		enter_Description.sendKeys(Description);
		Thread.sleep(2000);

	}

	public void enterBilledHours(String Hours) throws Exception {
		util = new WebDriverUtil();
		// util.waitForElementToBeClickable(enter_billed_hours);
		// util.waitForElementJavaScript(enter_billed_hours);
		util.waitForElementVisiblity(enter_billed_hours);
		// Thread.sleep(5000);
		enter_billed_hours.sendKeys(Hours);
	}

	public void enterUpdatedBilledHours(String UpdateHours) throws Exception {
		util = new WebDriverUtil();
		// util.waitForElementToBeClickable(enter_billed_hours);
		// util.waitForElementJavaScript(enter_billed_hours);
		util.waitForElementVisiblity(enter_billed_hours);
		enter_billed_hours.clear();
		// Thread.sleep(5000);
		enter_billed_hours.sendKeys(UpdateHours);
	}

	public void clickOnPlateformDropdown() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_on_plateform_dropdown);
		util.waitForElementJavaScript(click_on_plateform_dropdown);
	}

	public void SelectPlateform() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(select_plateform);
		util.waitForElementJavaScript(select_plateform);
	}

	public void clickOnUserDropdown() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Click_on_users_dropdown);
		util.waitForElementJavaScript(Click_on_users_dropdown);
	}

	public void SelectUsers() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(select_user);
		util.waitForElementJavaScript(select_user);
	}

	public void clickOnSubmitButton() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(submit_button);
		util.waitForElementJavaScript(submit_button);

	}

	public void clickOnEditButton() throws Exception {
		util = new WebDriverUtil();
		Thread.sleep(2000);
		util.waitForElementToBeClickable(report_edit_button);
		util.waitForElementJavaScript(report_edit_button);
		Thread.sleep(2000);
	}

	public void enterUpdatedDescription(String UpdatedDescription) throws Exception {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(enter_Description);
		enter_Description.clear();
		enter_Description.sendKeys(UpdatedDescription);
		Thread.sleep(2000);

	}

	public void clickOnUpdatedPlateformDropdown() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(update_plateform_dropdown);
		util.waitForElementJavaScript(update_plateform_dropdown);

	}

	public void SelectUpdatePlateform() throws InterruptedException {
		util = new WebDriverUtil();
		Thread.sleep(1000);
		util.waitForElementToBeClickable(select_updated_plateform);
		util.waitForElementJavaScript(select_updated_plateform);

	}

	public void hitTabKey() {
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void hitEnterKey() {
		Actions action = new Actions(DriverFactory.getDriver());
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void clickOnUpdatedUserDropdown() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(update_users_dropdown);
		util.waitForElementJavaScript(update_users_dropdown);

	}

	public void clickOnUpdatedUser() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(select_updated_user);
		util.waitForElementJavaScript(select_updated_user);

	}

	public void clickOnUpdateButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(update_button);
		util.waitForElementJavaScript(update_button);

	}

	public void ReportCreateSuccessfully() throws Exception {
		Thread.sleep(2000);
		String actual = report_create_message.getText();

		file = new JSONFileClass();
		user = file.readJson();
		JSONArray ReportCreatemessageArray = (JSONArray) user.get("ReportMessage");

		for (int i = 0; i < ReportCreatemessageArray.size(); i++) {

			JSONObject details = (JSONObject) ReportCreatemessageArray.get(i);
			String expected = (String) details.get("ReportSuccessMessage");
			Assert.assertEquals(actual, expected);

		}
	}

	public void ReportUpdatedSuccessfully() throws Exception {
		Thread.sleep(2000);
		String actual = report_updated_message.getText();

		file = new JSONFileClass();
		user = file.readJson();
		JSONArray ReportupdatedmessageArray = (JSONArray) user.get("ReportMessage");

		for (int i = 0; i < ReportupdatedmessageArray.size(); i++) {

			JSONObject details = (JSONObject) ReportupdatedmessageArray.get(i);
			String expected = (String) details.get("ReportUpdateMessage");
			Assert.assertEquals(actual, expected);

		}
	}
}
