package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductsToCart implements Task {

    public static Task twoProducts() {
        return instrumented(AddProductsToCart.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(InventoryPage.ADD_BACKPACK_BUTTON),
                Click.on(InventoryPage.ADD_BIKE_LIGHT_BUTTON)
        );
    }
}