package org.testingday.bdd.domain;

public class ManageCredentials {
    public static CredentialsBuilder using(){
        return new CredentialsBuilder();
    }
}
