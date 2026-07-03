  Feature: Ordenamiento de productos

  Scenario: Ordenar productos por precio de mayor a menor
    Given que el usuario inicia sesión en SauceDemo
    When ordena los productos por precio de mayor a menor
    Then el primer producto debería ser "Sauce Labs Fleece Jacket"