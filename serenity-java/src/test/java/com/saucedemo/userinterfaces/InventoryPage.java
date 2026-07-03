package com.saucedemo.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    public static final Target ADD_BACKPACK_BUTTON = Target.the("botón agregar mochila")
            .located(By.id("add-to-cart-sauce-labs-backpack"));

    public static final Target ADD_BIKE_LIGHT_BUTTON = Target.the("botón agregar luz de bicicleta")
            .located(By.id("add-to-cart-sauce-labs-bike-light"));

    public static final Target CART_BUTTON = Target.the("botón carrito")
            .located(By.cssSelector("#shopping_cart_container"));
}