package org.testingday.bdd.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WikipediaPage {

    public static Target SEARCH_INPUT = Target.the("Search input")
            .located(By.id("searchInput"));

    public static Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.cssSelector("i.svg-search-icon"));

    public static Target ARTICLE_TITLE = Target.the("Article title")
            .located(By.id("firstHeading"));

    public static Target LANGUAGE_DROPDOWN = Target.the("Select language dropdown")
            .located(By.id("searchLanguage"));
}
