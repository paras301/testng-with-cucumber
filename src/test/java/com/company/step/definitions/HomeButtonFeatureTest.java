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
import org.testng.Assert;

import java.io.File;
import java.io.FileOutputStream;

@Slf4j
public class HomeButtonFeatureTest extends TestRunner {

	private Scenario scenario;

	@Before
    public void before(Scenario scenarioVal) {
        this.scenario = scenarioVal;
        log.info("Scenario: " + scenario.getName());
    }

//	@Given("^User navigates to \"(.*)\"$")
//	public void user_navigates_to_website(String website) throws Exception {
//		log.info("User navigates to website: "+ website);
//		webdriver.get(website);
//		webdriver.manage().window().maximize();
//		Thread.sleep(5000);
//	}

	@When("^User clicks on Home Button$")
	public void user_clicks_on_home_button() throws Throwable
	{
		webdriver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
	}

	@Then("^Home website \"(.*)\" is reached$")
	public void home_website_is_reached(String expectedUrl) throws InterruptedException {
		String url = webdriver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, url);
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
