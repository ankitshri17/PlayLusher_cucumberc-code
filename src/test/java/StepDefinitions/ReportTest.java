package StepDefinitions;

import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;

import Pages.Loginpage;
import Pages.Projectpage;
import Pages.Reportpage;
import io.cucumber.java.en.Then;

public class ReportTest {

	
	WebDriver driver;
	Loginpage page;
	Projectpage project;
	JSONFileClass file;
	JSONObject user;
	Reportpage Report;

	@Then("^click on Report Tab$")
	public void click_on_report_tab() {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnReportTab();

	}

	@Then("^click on Add Report button$")
	public void click_on_Add_Report_button() {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnAddReportButton();

	}

	@Then("^click on submit button$")
	public void click_on_submit_button() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnSubmitButton();

	}

	@Then("^Enter the Description$")
	public void enter_the_description() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray ReportDescriptionArray = (JSONArray) user.get("ReportDescription");

		for (int i = 0; i < ReportDescriptionArray.size(); i++) {
			JSONObject details = (JSONObject) ReportDescriptionArray.get(i);
			long number = (long) new Date().getTime();

			Report.enterDescriptionOfReport((String) details.get("Description") + number);
		}

	}

	@Then("^Enter Billed hours$")
	public void Enter_Billed_hours() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray BilledHours = (JSONArray) user.get("ReportDescription");

		for (int i = 0; i < BilledHours.size(); i++) {
			JSONObject details = (JSONObject) BilledHours.get(i);
			Report.enterBilledHours((String) details.get("Hours"));
		}

	}

	@Then("^select the Plateform$")
	public void select_the_plateform() {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnPlateformDropdown();
		Report.SelectPlateform();

	}

	@Then("^select the Users$")
	public void select_the_users() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnUserDropdown();
		Report.SelectUsers();
		// Report.clickOnSubmitButton();

	}

	@Then("^click on Report edit button$")
	public void click_on_report_edit_button() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnEditButton();

	}

	@Then("^Update the Report Description$")
	public void update_the_report_description() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray ReportDescriptionUpdated = (JSONArray) user.get("ReportDescription");

		for (int i = 0; i < ReportDescriptionUpdated.size(); i++) {
			JSONObject details = (JSONObject) ReportDescriptionUpdated.get(i);
			long number = (long) new Date().getTime();

			Report.enterUpdatedDescription((String) details.get("UpdatedDescription") + number);
		}
	}

	@Then("^Update the plateform$")
	public void update_the_plateform() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray updatedBilledHours = (JSONArray) user.get("ReportDescription");

		for (int i = 0; i < updatedBilledHours.size(); i++) {
			JSONObject details = (JSONObject) updatedBilledHours.get(i);
			Report.enterUpdatedBilledHours((String) details.get("UpdateHours"));
		}

		Report.hitTabKey();
		Report.hitEnterKey();
		Report.SelectUpdatePlateform();

	}

	@Then("^Update the Users$")
	public void update_the_users() throws InterruptedException {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.hitTabKey();
		Report.hitEnterKey();
		Report.clickOnUpdatedUser();

		Thread.sleep(2000);

	}

	@Then("^clicks on Report Update button$")
	public void clicks_on_report_update_button() throws InterruptedException {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.clickOnUpdateButton();

	}

	@Then("^Validate create Report message$")
	public void validate_create_report_message() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.ReportCreateSuccessfully();
	}

	@Then("^Validate updated Report message$")
	public void validate_updated_report_message() throws Exception {
		Report = new Reportpage(DriverFactory.getDriver());
		Report.ReportUpdatedSuccessfully();
	}

}
