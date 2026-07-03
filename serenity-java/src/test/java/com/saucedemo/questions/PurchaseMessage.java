package com.saucedemo.questions;

import com.saucedemo.userinterfaces.CheckoutCompletePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class PurchaseMessage implements Question<String> {

    public static Question<String> value() {
        return new PurchaseMessage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CheckoutCompletePage.COMPLETE_MESSAGE)
        .answeredBy(actor);
    }
}