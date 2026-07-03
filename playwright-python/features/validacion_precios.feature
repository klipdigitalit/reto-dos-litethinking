Feature: Validación de precios

  Scenario: Validar precio del producto Sauce Labs Backpack
    Given que el usuario inicia sesión en SauceDemo
    When consulta el precio del producto "Sauce Labs Backpack"
    Then el precio debería ser "$29.99"

