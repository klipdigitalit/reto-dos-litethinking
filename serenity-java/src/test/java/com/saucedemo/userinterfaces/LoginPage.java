package com.saucedemo.userinterfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    public static final Target USERNAME_FIELD = Target.the("campo usuario")
            .located(By.id("user-name"));

    public static final Target PASSWORD_FIELD = Target.the("campo contraseña")
            .located(By.id("password"));

    public static final Target LOGIN_BUTTON = Target.the("botón login")
            .located(By.id("login-button"));

    public static final Target ERROR_MESSAGE = Target.the("mensaje de error")
                .located(By.cssSelector("h3[data-test='error']"));
}