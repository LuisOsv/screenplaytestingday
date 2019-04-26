package org.testingday.bdd.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.testingday.bdd.pages.SauceStorePage;

public class Login implements Task {

    String username;
    String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(SauceStorePage.USERNAME),
                Enter.theValue(password).into(SauceStorePage.PASSWORD),
                Click.on(SauceStorePage.LOGIN_BUTTON)

        );
    }

//    public static Performable withCredentials(String username, String password) {
//        return Instrumented.instanceOf(Login.class).withProperties(username, password);
//    }
}
