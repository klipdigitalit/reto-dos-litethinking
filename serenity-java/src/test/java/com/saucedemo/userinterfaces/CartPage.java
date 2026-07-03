package com.saucedemo.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

   public static final Target CHECKOUT_BUTTON =
    Target.the("botón checkout")
          .located(By.id("checkout"));
}