package org.testingday.bdd.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo  {

    public static Performable url(String url) {
        return Task.where("{0} opens the browser",
                Open.url(url)
        );
    }
}