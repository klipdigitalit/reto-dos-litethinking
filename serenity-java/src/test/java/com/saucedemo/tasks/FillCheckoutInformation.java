package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.CartPage;
import com.saucedemo.userinterfaces.CheckoutPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FillCheckoutInformation implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutInformation(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static Task withData(String firstName, String lastName, String postalCode) {
        return instrumented(FillCheckoutInformation.class, firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CartPage.CHECKOUT_BUTTON),
                WaitUntil.the(CheckoutPage.FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME),
                Enter.theValue(postalCode).into(CheckoutPage.POSTAL_CODE),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}