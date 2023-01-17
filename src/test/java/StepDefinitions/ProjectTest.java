package StepDefinitions;

import java.io.IOException;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;

import Pages.Loginpage;
import Pages.Projectpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectTest {

	WebDriver driver;
	Loginpage page;
	Projectpage project;
	JSONFileClass file;
	JSONObject user;

	@When("^user enter credentials$")
	public void user_enter_credentials() throws IOException, ParseException {
		page = new Loginpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray userLogin = (JSONArray) user.get("Login");

		for (int i = 0; i < userLogin.size(); i++) {
			JSONObject details = (JSONObject) userLogin.get(i);
			page.enterusername((String) details.get("email"));
			page.enterpassword((String) details.get("password"));
		}
	}

	// @When("^clicks on Hamburger icon$")
	// public void clicks_on_hamburger_icon() throws InterruptedException {
	// project = new Projectpage(DriverFactory.getDriver());
	// project.Hamburgericon();
	// Thread.sleep(1000);
	// }

	@Then("click on project tab$")
	public void click_on_project_tab() {
		project = new Projectpage(DriverFactory.getDriver());
		project.ProjectTab();
	}

	@Then("^click on Add project button$")
	public void click_on_add_project_button() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.AddProjectButton();
		Thread.sleep(1000);
	}

	@Then("^enter project title$")
	public void enter_project_title() throws IOException, ParseException {
		project = new Projectpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray Createproject = (JSONArray) user.get("Project");

		for (int i = 0; i < Createproject.size(); i++) {
			JSONObject details = (JSONObject) Createproject.get(i);
			long number = (long) new Date().getTime();

			project.EnterProjectTitle((String) details.get("ProjectTitle") + number);
		}
	}

	@And("^click save project button$")
	public void click_save_project_button() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.ClickSaveProjectButton();

	}

	@Then("^validate project create successfully$")
	public void validate_project_create_successfully() throws Exception {
		project = new Projectpage(DriverFactory.getDriver());
		project.ProjectCreateSuccessfully();
	}

	@Then("^click on Edit button$")
	public void click_on_edit_button() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.ClickonEditIcon();

	}

	@Then("^update project title$")
	public void update_project_title() throws IOException, ParseException, InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());

		file = new JSONFileClass();
		user = file.readJson();
		JSONArray UpdateProject = (JSONArray) user.get("UpdateProject");

		for (int i = 0; i < UpdateProject.size(); i++) {
			JSONObject details = (JSONObject) UpdateProject.get(i);
			long number = (long) new Date().getTime();
			project.UpdateProjectTitle((String) details.get("UpdateProjectTitle") + number);

		}

	}

	@Then("^update project visibility$")
	public void update_project_visibility() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.visibilityUpdated();

	}

	@Then("^update project handle$")
	public void update_project_handle() throws IOException, ParseException, InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray ProjectHandle = (JSONArray) user.get("ProjectHandle");

		for (int i = 0; i < ProjectHandle.size(); i++) {
			JSONObject details = (JSONObject) ProjectHandle.get(i);
			long number = (long) new Date().getTime();
			project.UpdateProjectHandle((String) details.get("UpdateProjectHandle") + number);

		}
	}

	@Then("^add project members$")
	public void add_project_members() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.ClickOnProjectMemberDropDown();

		project.AddProjectMember();

		project.hitEscapeKey();

	}

	@Then("^update visible bucket$")
	public void update_visible_bucket() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.ClickVisibleBucketDropDown();

		project.DeSelectVisibleBucket();
		project.hitEscapeKey();

	}

	@Then("^click on Update button$")
	public void click_on_update_button() throws InterruptedException {
		project = new Projectpage(DriverFactory.getDriver());
		project.ClickOnUpdateButton();

	}

	@Then("Update project successfully message")
	public void update_project_successfully_message() throws Exception {
		project = new Projectpage(DriverFactory.getDriver());
		project.ProjectUpdateMessageDisplay();

	}

	@Then("^clicks delete project button$")
	public void clicks_delete_project_button() throws Exception {
		project = new Projectpage(DriverFactory.getDriver());
		project.ClickOnProjectDeleteButton();
		project.DeleteButtonFromModal();

	}

	@Then("^display delete project message$")
	public void display_delete_project_message() throws Exception {
		project = new Projectpage(DriverFactory.getDriver());
		project.ProjectDeletedMessageDisplay();

	}

}
