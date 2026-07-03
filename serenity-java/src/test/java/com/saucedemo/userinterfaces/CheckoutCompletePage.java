package com.saucedemo.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletePage {

    public static final Target COMPLETE_MESSAGE =
            Target.the("mensaje de compra exitosa")
                    .located(By.className("complete-header"));

    public static final Target BACK_HOME_BUTTON =
            Target.the("botón volver al inicio")
                    .located(By.id("back-to-products"));
}