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
import Pages.Wikipage;
import io.cucumber.java.en.Then;

public class WikiTest {
	WebDriver driver;
	Loginpage page;
	Projectpage project;
	JSONFileClass file;
	JSONObject user;
	Credentialspage credentials;
	Wikipage wiki;

	@Then("click on wiki icon")
	public void click_on_wiki_icon() throws Exception {
		wiki = new Wikipage(DriverFactory.getDriver());
		wiki.wikiIcon();

	}

	@Then("click on wiki edit button")
	public void click_on_wiki_edit_button() {
		wiki = new Wikipage(DriverFactory.getDriver());
		wiki.ClickOnEditButton();
	}

	@Then("enter wiki description")
	public void enter_wiki_description() throws Exception {
		wiki = new Wikipage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray wikiArray = (JSONArray) user.get("Wiki");

		for (int i = 0; i < wikiArray.size(); i++) {
			JSONObject details = (JSONObject) wikiArray.get(i);
			long number = (long) new Date().getTime();

			wiki.enterDescriptionOfWiki((String) details.get("WikiDescription") + number);

		}

	}

	@Then("wiki upload file")
	public void wiki_upload_file() throws Exception {
		wiki = new Wikipage(DriverFactory.getDriver());
		wiki.WikiUploadFileButton();

	}

	@Then("enter the wiki comment")
	public void enter_the_wiki_comment() throws Exception {
		wiki = new Wikipage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray wikiArray = (JSONArray) user.get("Wiki");

		for (int i = 0; i < wikiArray.size(); i++) {
			JSONObject details = (JSONObject) wikiArray.get(i);

			wiki.enterCommentOfWiki((String) details.get("WikiComment"));

		}

	}

	@Then("upload file for wiki comment")
	public void upload_file_for_wiki_comment() {
		
		
		
			}

	@Then("click on wiki post comment button")
	public void click_on_wiki_post_comment_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("click on wiki save button")
	public void click_on_wiki_save_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("enter updated wiki description")
	public void enter_updated_wiki_description() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("enter updated wiki comment")
	public void enter_updated_wiki_comment() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
