package com.saucedemo.stepdefinitions;

import com.saucedemo.questions.LoginErrorMessage;
import com.saucedemo.tasks.Login;
import com.saucedemo.tasks.OpenTheApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginFallidoStepDefinitions {

    private Actor usuario;

    @Given("que el usuario abre SauceDemo")
    public void queElUsuarioAbreSauceDemo() {
        OnStage.setTheStage(new OnlineCast());

        usuario = OnStage.theActorCalled("Usuario");

        usuario.attemptsTo(
                 OpenTheApplication.onTheLoginPage()
        );
    }

    @When("inicia sesión con el usuario {string} y la contraseña {string}")
    public void iniciaSesion(String usuarioLogin, String password) {

        usuario.attemptsTo(
                Login.withCredentials(usuarioLogin, password)
        );
    }

    @Then("debería visualizar el mensaje de usuario bloqueado")
    public void deberiaVisualizarMensaje() {

        assertThat(
                LoginErrorMessage.displayed().answeredBy(usuario),
                containsString("Sorry, this user has been locked out.")
        );
    }
}