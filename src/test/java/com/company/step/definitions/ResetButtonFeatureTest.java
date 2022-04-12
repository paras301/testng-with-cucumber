package com.company.step.definitions;

import com.company.runner.TestRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;

@Slf4j
public class ResetButtonFeatureTest extends TestRunner {

	private Scenario scenario;

	@Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

	@Given("^User navigates to \"(.*)\"$")
	public void user_navigates_to_website(String website) throws Exception {
		log.info("User navigates to website: "+ website);
		webdriver.get(website);
		webdriver.manage().window().maximize();
		Thread.sleep(2000);
	}

	@When("^User enter the Username \"(.*)\" and Password \"(.*)\"$")
	public void enter_the_Username_and_Password(String username,String password) throws Throwable
	{
		webdriver.findElement(By.xpath("//input[@name='uid']")).sendKeys(username);
		webdriver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	}

	@Then("^Reset the credential$")
	public void reset_the_credential() throws InterruptedException {
		webdriver.findElement(By.xpath("//input[@name='btnReset']")).click();
	}

	@After
	public void screenCapture(Scenario scenario) throws Exception {
		 String filename = System.getProperty("user.dir") + "/build/screenshots/"
				 + scenario.getName().replace(" ", "_") + "_" + scenario.getLine() + ".png";
		 log.info("Taking Screenshot --> " + filename );
		 byte screenshot[] = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);
		 File f = new File(filename);
		 f.getParentFile().mkdirs();
		 f.createNewFile();
		 FileOutputStream fos = new FileOutputStream(filename);
		 fos.write(screenshot);
	}
}
