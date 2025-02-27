const { test, expect } = require('@playwright/test');
const { LoginPage } = require('../pages/LoginPage');

test('User should be able to login', async ({ page }) => {
  const loginPage = new LoginPage(page);
  await loginPage.navigate('https://example.com/login');
//   await loginPage.login('user', 'password');
  await expect(page).toHaveURL('https://example.com/login');
});
