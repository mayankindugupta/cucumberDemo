package com.nxtgenai.stepdefinition;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ParabankLoginDataTable {

	WebDriver driver = null;

	@Given("user on login page")
	public void user_on_login_page() {
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		System.out.println("Parabank home page is launched succesfully");
	}

	@When("user enters the credentials")
	public void user_enters_the_credentials(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> creds = dataTable.asMaps(String.class, String.class);
		String user_name = creds.get(0).get("UserName");
		String user_pwd = creds.get(0).get("Password");
		driver.findElement(By.name("username")).sendKeys(user_name);
		driver.findElement(By.name("password")).sendKeys(user_pwd);
		System.out.println("Valid user name and password entered");
	}

	@And("clicks at login button")
	public void clicks_at_login_button() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		System.out.println("Click on login button");
	}

	@Then("display views home page")
	public void display_views_home_page() {
		String text = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
		if (text.toLowerCase().contains("welcome"))
			System.out.println("User homepage is displayed");
	}

	@And("user the application")
	public void user_the_application() {
		driver.close();
		System.out.println("Application is closed ");
	}

}
