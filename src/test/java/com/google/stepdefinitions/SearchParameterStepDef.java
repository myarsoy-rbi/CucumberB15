package com.google.stepdefinitions;

import com.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchParameterStepDef {
    WebDriver driver = DriverHelper.getDriver();
    GoogleMainPage googleMainPage = new GoogleMainPage(driver);
    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
        driver.get(url);
    }

    @When("User searches for {string}")
    public void user_searches_for(String text) {
        googleMainPage.searchFor(text);
    }

    @Then("User gets more than {int} links from first page")
    public void user_gets_more_links_from_first_page(int link) {
        Assert.assertTrue(googleMainPage.validateNumberOfLinks(link));
    }

    @Then("User gets more than {double} result from first page")
    public void user_gets_more_than_result_from_first_page(Double num) throws InterruptedException {
        googleMainPage.validateResultMessage(num);
        driver.quit();
    }

}
