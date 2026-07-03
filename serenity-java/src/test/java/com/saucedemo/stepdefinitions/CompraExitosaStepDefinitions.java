package com.saucedemo.stepdefinitions;
import com.saucedemo.questions.PurchaseMessage;

import com.saucedemo.tasks.AddProductsToCart;
import com.saucedemo.tasks.FillCheckoutInformation;
import com.saucedemo.tasks.FinishPurchase;
import com.saucedemo.tasks.GoToCart;
import com.saucedemo.tasks.Login;
import com.saucedemo.tasks.OpenTheApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class CompraExitosaStepDefinitions {

    private Actor usuario;

    @Given("que el usuario se encuentra en la página de SauceDemo")
    public void queElUsuarioSeEncuentraEnLaPaginaDeSauceDemo() {
        setTheStage(new OnlineCast());
        usuario = theActorCalled("Usuario");
        usuario.attemptsTo(OpenTheApplication.onTheLoginPage());
    }

    @When("inicia sesión con credenciales válidas")
    public void iniciaSesionConCredencialesValidas() {
        usuario.attemptsTo(
            Login.withCredentials("standard_user", "secret_sauce"));
    }

    @When("agrega dos productos al carrito")
    public void agregaDosProductosAlCarrito() {
        usuario.attemptsTo(AddProductsToCart.twoProducts());
    }

    @When("accede al carrito de compras")
    public void accedeAlCarritoDeCompras() {
        usuario.attemptsTo(GoToCart.open());
    }

    @When("completa el proceso de checkout")
    public void completaElProcesoDeCheckout() {
        usuario.attemptsTo(
            FillCheckoutInformation.withData("Juan", "Pérez", "110111"),
            FinishPurchase.now()
        );
    }

    @Then("debería visualizar el mensaje de compra exitosa")
    public void deberiaVisualizarElMensajeDeCompraExitosa() {
        usuario.should(
            seeThat(PurchaseMessage.value(), equalTo("Thank you for your order!"))
        );
    }

}