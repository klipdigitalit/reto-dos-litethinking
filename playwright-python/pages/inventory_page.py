from playwright.sync_api import Page

class InventoryPage:

    def __init__(self, page: Page):
        self.page = page

    def get_product_price(self, product_name: str) -> str:
        product = self.page.locator(".inventory_item").filter(has_text=product_name)
        return product.locator(".inventory_item_price").inner_text()
    
    def sort_products_high_to_low(self):
        self.page.locator('[data-test="product-sort-container"]').select_option("hilo")
    
    def get_first_product_name(self) -> str:
        return self.page.locator(".inventory_item_name").first.inner_text()