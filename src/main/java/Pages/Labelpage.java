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

public class Labelpage {

	WebDriver driver;
	WebDriverUtil util;
	JSONFileClass file;
	JSONObject user;

	@FindBy(xpath = "//a[@title='Labels']")
	WebElement label_icon;

	@FindBy(xpath = "//span[@class='btn_text']")
	WebElement click_new_label_button;

	@FindBy(name = "label_tags")
	WebElement label_name;

	@FindBy(xpath = "//span[normalize-space()='Create Label']")
	WebElement create_label_button;

	@FindBy(xpath = "//div[@aria-label='Label created successfully.']")
	WebElement label_create_message;

	@FindBy(xpath = "//a[@title='board']")
	WebElement Hamburger_icon_of_project;

	public Labelpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnLabelIcon() throws Exception {

		util = new WebDriverUtil();
		util.waitForElementToBeClickable(label_icon);
		util.waitForElementJavaScript(label_icon);

	}

	public void ClickOnNewLabelButton() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(click_new_label_button);
		util.waitForElementJavaScript(click_new_label_button);

	}

	public void EnterLabelName(String Name) {
		util = new WebDriverUtil();
		util.waitForElementVisiblity(label_name);
		label_name.clear();
		label_name.sendKeys(Name);

	}

	public void ClickOnCreateLabelButton() throws Exception {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(create_label_button);
		util.waitForElementJavaScript(create_label_button);
		
		

	}

	public void validateCreateLabelMessage() throws Exception {
		Thread.sleep(1000);
		String actual = label_create_message.getText();

		file = new JSONFileClass();
		user = file.readJson();
		JSONArray LabelCreatemessage = (JSONArray) user.get("LabelMessage");

		for (int i = 0; i < LabelCreatemessage.size(); i++) {

			JSONObject details = (JSONObject) LabelCreatemessage.get(i);
			String expected = (String) details.get("LabelCreateMessage");
			Assert.assertEquals(actual, expected);
		}
	}

	public void ClickOnHamburgerIconOfProject() {
		util = new WebDriverUtil();
		util.waitForElementToBeClickable(Hamburger_icon_of_project);
		util.waitForElementJavaScript(Hamburger_icon_of_project);

	}

}