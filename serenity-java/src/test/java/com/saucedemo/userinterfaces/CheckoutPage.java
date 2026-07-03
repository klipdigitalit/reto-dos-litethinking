package com.saucedemo.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    public static final Target FIRST_NAME = Target.the("campo nombre")
            .located(By.id("first-name"));

    public static final Target LAST_NAME = Target.the("campo apellido")
            .located(By.id("last-name"));

    public static final Target POSTAL_CODE = Target.the("campo código postal")
            .located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON = Target.the("botón continuar")
            .located(By.id("continue"));

    public static final Target FINISH_BUTTON = Target.the("botón finalizar")
            .located(By.id("finish"));

    public static final Target COMPLETE_MESSAGE = Target.the("mensaje de compra exitosa")
            .located(By.className("complete-header"));
}