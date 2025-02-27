const { defineConfig } = require('@playwright/test');

module.exports = defineConfig({
  testDir: './tests', // Test files location
  timeout: 30000, // Global timeout for tests
  use: {
    headless: true, // Run tests in headless mode
    screenshot: 'only-on-failure', // Capture screenshot on failure
    video: 'retain-on-failure', // Record video on failure
    trace: 'on-first-retry', // Enable tracing for debugging
  },
  reporter: [['html', { open: 'never' }]],
});
