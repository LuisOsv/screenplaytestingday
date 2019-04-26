package org.testingday.bdd.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.testingday.bdd.pages.SauceStorePage;

import java.util.List;

public class TheProductOnCart {

    public static Question<List<String>> displayed() {
        return actor -> Text.of(SauceStorePage.CART_PRODUCTS).viewedBy(actor).asList();
    }

}
