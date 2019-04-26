package org.testingday.bdd.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class SauceStorePage {

    public static Target USERNAME = Target.the("").located(By.id("user-name"));
    public static Target PASSWORD = Target.the("").located(By.id("password"));
    public static Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector(".btn_action"));
    public static Target ADD_CART_BUTTON = Target.the("add cart button for {0}")
            .locatedBy("//div[contains(text(),'{0}')]/../../../div[3]//button");
    public static Target CART_LINK = Target.the("")
            .located(By.cssSelector(".shopping_cart_link"));
    public static Target CART_PRODUCTS = Target.the("")
            .located(By.cssSelector(".inventory_item_name"));
}
