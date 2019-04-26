package org.testingday.bdd.domain;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;
import org.testingday.bdd.tasks.Login;

public class CredentialsBuilder {

    String username;
    String password;

    public CredentialsBuilder withUserName(String username){
        this.username = username;
        return this;
    }

    public CredentialsBuilder andPassword(String password){
        this.password = password;
        return this;
    }

    public Performable withCredentials() {
        return Instrumented.instanceOf(Login.class).withProperties(username, password);
    }
}
