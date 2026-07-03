from playwright.sync_api import Page
from utils.config import BASE_URL


class LoginPage:

    def __init__(self, page: Page):
        self.page = page

    def open(self):
        self.page.goto(BASE_URL)

    def login(self, username: str, password: str):
        self.page.locator('[data-test="username"]').fill(username)
        self.page.locator('[data-test="password"]').fill(password)
        self.page.locator('[data-test="login-button"]').click()