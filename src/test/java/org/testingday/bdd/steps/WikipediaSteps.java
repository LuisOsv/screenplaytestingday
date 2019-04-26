package org.testingday.bdd.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.testingday.bdd.questions.WikipediaHeader;
import org.testingday.bdd.tasks.NavigateTo;
import org.testingday.bdd.tasks.SearchFor;
import org.testingday.bdd.tasks.SearchForAlternative;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class WikipediaSteps {

    String WikipediaUrl = "https://www.wikipedia.org";

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) navigates to Wikipedia home page$")
    public void navigateToWikipediaHomePage(String actorName) {
        theActorCalled(actorName).attemptsTo(
                NavigateTo.url(WikipediaUrl)
        );
    }

    @When("^s?he searches for \"([^\"]*)\" term$")
    public void searchForTerm(String searchText) {
        theActorInTheSpotlight().attemptsTo(
                SearchFor.term(searchText)
        );
    }


    @Then("^s?he should see \"([^\"]*)\" in header of result page$")
    public void verifyHeaderOfResultPage(String expectedHeader) {
        theActorInTheSpotlight().should(
                seeThat("verify header title",
                        WikipediaHeader.displayed(),
                        equalTo(expectedHeader))
        );
    }
}
