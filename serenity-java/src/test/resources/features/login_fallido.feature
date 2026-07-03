Feature: Inicio de sesión

  Scenario: Usuario bloqueado
    Given que el usuario abre SauceDemo
    When inicia sesión con el usuario "locked_out_user" y la contraseña "secret_sauce"
    Then debería visualizar el mensaje de usuario bloqueado