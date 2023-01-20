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
import Pages.Taskpage;
import io.cucumber.java.en.Then;

public class TaskTest {
	Taskpage task;
	WebDriver driver;
	Loginpage page;
	Projectpage project;
	JSONFileClass file;
	JSONObject user;
	Labelpage Label;

	@Then("^clicks on add task button$")
	public void clicks_on_add_task_button() {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClicksOnTaskButton();

	}

	@Then("^enter task name$")
	public void enter_task_name() throws IOException, ParseException {
		task = new Taskpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray Taskname = (JSONArray) user.get("Task");

		for (int i = 0; i < Taskname.size(); i++) {
			JSONObject details = (JSONObject) Taskname.get(i);
			long number = (long) new Date().getTime();
			task.EnterTaskName((String) details.get("TaskName") + number);

		}

	}

	@Then("^enter task details$")
	public void enter_task_details() throws IOException, ParseException {
		task = new Taskpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray Taskdetail = (JSONArray) user.get("Task");

		for (int i = 0; i < Taskdetail.size(); i++) {
			JSONObject details = (JSONObject) Taskdetail.get(i);
			long number = (long) new Date().getTime();
			task.EnterTaskDetail((String) details.get("TaskDetail") + number);

		}

	}

	@Then("^select bucket option$")
	public void select_bucket_option() {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClickOnBucketDropDown();
		task.SelectBacklogOption();

	}

	@Then("^Upload file for task$")
	public void upload_file_for_task() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.FileUpload();
	}

	@Then("^clicks on save button$")
	public void clicks_on_save_button() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClicksOnSaveButton();

	}

	@Then("^validate task create message$")
	public void validate_task_create_message() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.TaskCreateMessageDisplay();

	}

	@Then("^clicks on Backlog ticket$")
	public void clicks_on_backlog_ticket() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		Thread.sleep(2000);
		task.ClickOnBcklogTicket();
		Thread.sleep(2000);

	}

	@Then("^update task name$")
	public void update_task_name() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray UpdateTaskName = (JSONArray) user.get("Task");

		for (int i = 0; i < UpdateTaskName.size(); i++) {
			JSONObject details = (JSONObject) UpdateTaskName.get(i);
			long number = (long) new Date().getTime();
			task.UpdateTaskName((String) details.get("UpdateTaskName") + number);

		}

	}

	@Then("^update task details$")
	public void update_task_details() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray UpdateTaskDetail = (JSONArray) user.get("Task");

		for (int i = 0; i < UpdateTaskDetail.size(); i++) {
			JSONObject details = (JSONObject) UpdateTaskDetail.get(i);
			long number = (long) new Date().getTime();
			task.UpdateTaskDetail((String) details.get("UpdateTaskDetail") + number);

		}

	}

	@Then("^update bucket option$")
	public void update_bucket_option() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClickOnBucketDropDown();
		task.UpdateBucketOption();
	}

	@Then("^select Label option$")
	public void select_label_option() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClickOnLabelDropdown();
		task.SelectLabelOption();

	}

	@Then("^enter task comment$")
	public void enter_task_comment() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		file = new JSONFileClass();
		user = file.readJson();
		JSONArray TaskComment = (JSONArray) user.get("TaskComment");

		for (int i = 0; i < TaskComment.size(); i++) {
			JSONObject details = (JSONObject) TaskComment.get(i);

			task.TaskComment((String) details.get("Comment"));

		}

	}

	@Then("^clicks on post comment button$")
	public void clicks_on_post_comment_button() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClickOnPostCommentButton();
		Thread.sleep(1000);
		task.scrollviewcomment();

	}

	@Then("^clicks on save button for update task$")
	public void clicks_on_save_button_for_update_task() throws Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClickOnSaveButtonForUpdate();

	}

	@Then("^validate update task message$")
	public void validate_update_task_message() throws ParseException, Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.UpdateTaskMessageDisplay();

	}

	@Then("^clicks on Delete task Button$")
	public void clicks_on_delete_task_button() {
		task = new Taskpage(DriverFactory.getDriver());
		task.ClickOnBcklogTicket();
		task.ClickOnDeleteButton();

	}

	@Then("validate Delete task message")
	public void validate_delete_task_message() throws ParseException, Exception {
		task = new Taskpage(DriverFactory.getDriver());
		task.DeleteTaskMessageDisplay();

	}

}
