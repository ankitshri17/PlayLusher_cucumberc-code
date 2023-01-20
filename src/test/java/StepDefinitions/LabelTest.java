package StepDefinitions;

import java.io.IOException;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.JSONFileClass;

import Pages.Labelpage;
import Pages.Loginpage;
import Pages.Projectpage;
import io.cucumber.java.en.Then;

public class LabelTest {

	WebDriver driver;
	Loginpage page;
	Projectpage project;
	Labelpage Label;
	JSONFileClass file;
	JSONObject user;

	@Then("^click on Label icon$")
	public void click_on_label_icon() throws Exception {
		Label = new Labelpage(DriverFactory.getDriver());
		Label.ClickOnLabelIcon();

	}

	@Then("^click on New label button$")
	public void click_on_new_label_button() {
		Label = new Labelpage(DriverFactory.getDriver());
		Label.ClickOnNewLabelButton();

	}

	@Then("^enter label name$")
	public void enter_label_name() throws IOException, ParseException {
		Label = new Labelpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray LabelName = (JSONArray) user.get("LabelName");

		for (int i = 0; i < LabelName.size(); i++) {
			JSONObject details = (JSONObject) LabelName.get(i);
			long number = (long) new Date().getTime();
			Label.EnterLabelName((String) details.get("Name") + number);
		}

	}

	@Then("^click on create label button$")
	public void click_on_create_label_button() throws Exception {
		Label = new Labelpage(DriverFactory.getDriver());
		Label.ClickOnCreateLabelButton();

	}

	@Then("^validate Label create message$")
	public void validate_label_create_message() throws Exception {
		Label = new Labelpage(DriverFactory.getDriver());
		Label.validateCreateLabelMessage();

	}

	@Then("^click on Hamburger icon of project$")
	public void click_on_hamburger_icon_of_project() {
		Label = new Labelpage(DriverFactory.getDriver());
		Label.ClickOnHamburgerIconOfProject();

	}

}
