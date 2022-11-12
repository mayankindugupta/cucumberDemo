package com.nxtgenai.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class ParaBankLoginData {

	WebDriver driver = null;

	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
		System.out.println("Parabank home page is launched succesfully");
	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String username, String password) {
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Valid user name and password entered");
	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		System.out.println("Click on login button");
	}

	@Then("display user home page")
	public void display_user_home_page() {
		String text = driver.findElement(By.xpath("//p[@class='smallText']")).getText();
		if (text.toLowerCase().contains("welcome"))
			System.out.println("User homepage is displayed");
	}

	@And("user will close the application")
	public void user_will_close_the_application() {
		driver.close();
		System.out.println("Application is closed ");
	}
}
