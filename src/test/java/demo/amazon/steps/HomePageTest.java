package demo.amazon.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demo.amazon.pages.HomePage;

public class HomePageTest {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }

    @And("^I accept cookies$")
    public void iAcceptCookies() {
        new HomePage().clickOnacceptcookies();
    }
    @When("^I click on basket$")
    public void iClickOnBasket() {
        new HomePage().clickOnBasketLink();
    }


    @Then("^I should see Your Amazon Cart is empty$")
    public void iShouldSeeYourAmazonCartIsEmpty() {
        System.out.println("i am on the page");
    }
}


