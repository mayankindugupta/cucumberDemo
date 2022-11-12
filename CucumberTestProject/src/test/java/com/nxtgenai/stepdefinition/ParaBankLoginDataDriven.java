package com.nxtgenai.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ParaBankLoginDataDriven {

	WebDriver driver = null;

	@Given("user launch parabank page")
	public void user_launch_parabank_page() {
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		System.out.println("Parabank home page is launched succesfully");
	}

	@When("user enter credentials {string} and {string}")
	public void user_enter_credentials_and(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Valid user name and password entered");
	}

	@And("click login button")
	public void click_login_button() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		System.out.println("Click on login button");
	}

	@Then("user should view home page")
	public void user_should_view_home_page() {
		String text = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
		if (text.toLowerCase().contains("welcome"))
			System.out.println("User homepage is displayed");
	}

	@And("user should close application")
	public void user_should_close_application() {
		driver.close();
		System.out.println("Application is closed ");
	}

}
