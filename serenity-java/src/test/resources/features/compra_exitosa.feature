Feature: Compra de productos en SauceDemo

  Como cliente de la tienda virtual
  Quiero comprar uno o varios productos
  Para completar una compra exitosamente

   Scenario: Realizar login exitoso
    Given que el usuario se encuentra en la página de SauceDemo
    When inicia sesión con credenciales válidas

  Scenario: Realizar una compra exitosa
    Given que el usuario se encuentra en la página de SauceDemo
    When inicia sesión con credenciales válidas
    And agrega dos productos al carrito
    And accede al carrito de compras
    And completa el proceso de checkout
    Then debería visualizar el mensaje de compra exitosa
