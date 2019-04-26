package org.testingday.bdd.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.testingday.bdd.domain.ManageCredentials;
import org.testingday.bdd.domain.Product;
import org.testingday.bdd.questions.TheProductOnCart;
import org.testingday.bdd.tasks.NavigateTo;
import org.testingday.bdd.tasks.SelectProducts;

import java.util.List;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class SauceStoreSteps {

    String sauceUrl = "https://www.saucedemo.com";
    String username = "standard_user";
    String password = "secret_sauce";
    List<Product> productsList;

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
        theActorInTheSpotlight().attemptsTo(
                ManageCredentials.using()
                .withUserName(username)
                .andPassword(password)
                .withCredentials()
        );
    }

    @When("^s?he adds the following products to the Cart$")
    public void addProductsToTheCart(List<Product> products) {
        productsList = products;
        theActorInTheSpotlight().attemptsTo(
            SelectProducts.named(products)
        );
    }

    @Then("^s?he should see the products in the Cart$")
    public void verifyTheProductsInTheCart() {
        List<String> strings = productsList.stream()
                .map(item -> item.getName())
                .collect(Collectors.toList());
        theActorInTheSpotlight().should(
                            seeThat(
                                    "verify item in cart",
                                    TheProductOnCart.displayed(),
                                    equalTo(strings)
                                    )
        );
    }
}
