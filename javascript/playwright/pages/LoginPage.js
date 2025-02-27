class LoginPage {
    constructor(page) {
      this.page = page;
      this.usernameField = '#username';
      this.passwordField = '#password';
      this.loginButton = '#login';
    }
  
    async navigate(url) {
      await this.page.goto(url);
    }
  
    async login(username, password) {
      await this.page.fill(this.usernameField, username);
      await this.page.fill(this.passwordField, password);
      await this.page.click(this.loginButton);
    }
  }
  
  module.exports = { LoginPage };
  