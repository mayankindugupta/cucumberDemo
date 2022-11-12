package com.nxtgenai.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ParaBankLoginScenario {

	WebDriver driver = null;

	// user is navigating to bank url
	@Given("user is navigating to bank url")
	public void user_is_navigating_to_bank_url() {

		// Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		System.out.println("Parabank home page is launched succesfully");
	}

	// username and password are valid
	@When("username and password are entered")
	public void username_and_password_are_entered() {

		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("nxtgendemo");
		driver.findElement(By.name("password")).sendKeys("nxtgendemo");
		System.out.println("Valid user name and password entered");
	}

	@And("click on login button")
	public void click_on_login_button() {
		
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		System.out.println("Click on login button");
	}

	// display the user home page
	@Then("display the user home page")
	public void display_the_user_home_page() {
		
		// Write code here that turns the phrase above into concrete actions
		String text = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
		if (text.toLowerCase().contains("welcome"))
			System.out.println("User homepage is displayed");
	}

	// close the application
	@And("close the application")
	public void close_the_application() {
		
		// Write code here that turns the phrase above into concrete actions
		driver.close();
		System.out.println("Application is closed ");
	}

	@When("invalid username and password are entered")
	public void invalid_username_and_password_are_entered() {
		
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("nxtgendemo");
		driver.findElement(By.name("password")).sendKeys("");
		System.out.println("Invalid user name and password entered");
	}

	@Then("unable to login")
	public void unable_to_login() {
		
		// Write code here that turns the phrase above into concrete actions
		String text = driver.findElement(By.xpath("//p[@class='error']")).getText();
		if (text.toLowerCase().contains("please enter a username and password"))
			System.out.println("Login failed ");
	}

}
