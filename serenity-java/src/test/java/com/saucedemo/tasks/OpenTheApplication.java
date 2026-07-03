package com.saucedemo.tasks;

import com.saucedemo.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApplication {

    public static Task onTheLoginPage() {
        return instrumented(OpenApplication.class);
    }

    public static class OpenApplication implements Task {

        @Override
        public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Open.browserOn().the(LoginPage.class)
            );
        }
    }
}