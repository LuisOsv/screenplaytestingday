package org.testingday.bdd.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.testingday.bdd.pages.WikipediaPage;

public class WikipediaHeader implements Question<String> {

    public static WikipediaHeader displayed() {
        return new WikipediaHeader();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(WikipediaPage.ARTICLE_TITLE).viewedBy(actor).asString();
    }
}
