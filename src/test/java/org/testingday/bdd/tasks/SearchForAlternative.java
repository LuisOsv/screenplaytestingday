package org.testingday.bdd.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import org.testingday.bdd.pages.WikipediaPage;

public class SearchForAlternative {

    public static Performable term(String term) {
        return Task.where("{0} attempts to search for #term",
                Clear.field(WikipediaPage.SEARCH_INPUT),
                Enter.theValue(term).into(WikipediaPage.SEARCH_INPUT),
                SelectFromOptions.byValue("en").from(WikipediaPage.LANGUAGE_DROPDOWN),
                Click.on(WikipediaPage.SEARCH_BUTTON)
        ).with("term").of(term);
    }
}
