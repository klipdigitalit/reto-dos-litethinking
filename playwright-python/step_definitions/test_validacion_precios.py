from pytest_bdd import scenarios, given, when, then, parsers
from playwright.sync_api import Page

from pages.login_page import LoginPage
from pages.inventory_page import InventoryPage
from utils.config import STANDARD_USER, PASSWORD


scenarios("../features/validacion_precios.feature")


@given("que el usuario inicia sesión en SauceDemo")
def user_logs_in(page: Page):
    login_page = LoginPage(page)
    login_page.open()
    login_page.login(STANDARD_USER, PASSWORD)


@when(parsers.parse('consulta el precio del producto "{product_name}"'))
def check_product_price(page: Page, product_name: str):
    inventory_page = InventoryPage(page)
    page.context.product_price = inventory_page.get_product_price(product_name)


@then(parsers.parse('el precio debería ser "{expected_price}"'))
def validate_product_price(page: Page, expected_price: str):
    assert page.context.product_price == expected_price