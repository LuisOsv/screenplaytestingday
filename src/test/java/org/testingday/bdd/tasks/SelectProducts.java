package org.testingday.bdd.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.testingday.bdd.domain.Product;
import org.testingday.bdd.pages.SauceStorePage;

import java.util.List;

public class SelectProducts implements Task {

    List<Product> products;

    public SelectProducts(List<Product> products) {
        this.products = products;
    }

    public static Performable named(List<Product> products) {
        return Instrumented.instanceOf(SelectProducts.class).withProperties(products);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        products.forEach(
                product ->
                        actor.attemptsTo(
                                Click.on(SauceStorePage.ADD_CART_BUTTON.of(product.getName()))
                        )
        );
        actor.attemptsTo(
            Click.on(SauceStorePage.CART_LINK)
        );
    }
}
