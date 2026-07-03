from pytest_bdd import scenarios, given, when, then
from playwright.sync_api import Page

from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage
from utils.config import STANDARD_USER, PASSWORD

scenarios("../features/ordenamiento_productos.feature")


@given("que el usuario inicia sesión en SauceDemo")
def iniciar_sesion(page: Page):
    login = LoginPage(page)
    login.open()
    login.login(STANDARD_USER, PASSWORD)


@when("ordena los productos por precio de mayor a menor")
def ordenar_productos(page: Page):
    inventory = InventoryPage(page)
    inventory.sort_products_high_to_low()


@then('el primer producto debería ser "Sauce Labs Fleece Jacket"')
def validar_primer_producto(page: Page):
    inventory = InventoryPage(page)

    assert (
        inventory.get_first_product_name()
        == "Sauce Labs Fleece Jacket"
    )