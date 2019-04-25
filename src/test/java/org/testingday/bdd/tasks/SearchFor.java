package org.testingday.bdd.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.testingday.bdd.pages.WikipediaPage;

public class SearchFor implements Task {

    public String searchText;

    public SearchFor(String searchText) {
        this.searchText = searchText;
    }

    public static Performable term(String searchText) {
        return Instrumented.instanceOf(SearchFor.class).withProperties(searchText);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(WikipediaPage.SEARCH_INPUT),
                Enter.theValue(searchText).into(WikipediaPage.SEARCH_INPUT),
                SelectFromOptions.byValue("en").from(WikipediaPage.LANGUAGE_DROPDOWN),
                Click.on(WikipediaPage.SEARCH_BUTTON)
        );
    }


}
