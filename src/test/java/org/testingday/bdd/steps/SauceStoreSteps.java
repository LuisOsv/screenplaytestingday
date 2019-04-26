package org.testingday.bdd.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.testingday.bdd.domain.Product;
import org.testingday.bdd.tasks.NavigateTo;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SauceStoreSteps {

    String sauceUrl = "https://www.saucedemo.com";

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) navigates to Sauce Store page$")
    public void navigatesToSauceStorePage(String userName) {
        theActorCalled(userName).attemptsTo(
                NavigateTo.url(sauceUrl)
        );
    }

    @And("^s?he login to the Sauce Store page$")
    public void loginToTheSauceStorePage() {

    }

    @When("^s?he adds the following products to the Cart$")
    public void addProductsToTheCart(List<Product> products) {

    }

    @Then("^s?he should see the products in the Cart$")
    public void verifyTheProductsInTheCart() {
    }
}
