# Sumerge — Test Automation

Java-based test automation exercises from my internship at [Sumerge](https://www.sumerge.com/). This project demonstrates Selenium WebDriver automation for web application testing.

## Technologies

- **Java** — core language
- **Selenium WebDriver** — browser automation
- **ChromeDriver** — Chrome browser driver

## Repository Structure

```text
src/              Java source files
bin/              Compiled output (should be gitignored)
Task.java         Standalone task file
Test.txt          Test documentation
chromedriver.exe  Chrome WebDriver binary (should be gitignored)
```

## Getting Started

1. Install Java JDK 8 or newer
2. Download the appropriate [ChromeDriver](https://chromedriver.chromium.org/) for your Chrome version
3. Compile and run the Java files

## Notes

> **Cleanup needed:** `chromedriver.exe` and `bin/` are committed to the repository but should be gitignored. Use a dependency manager or download ChromeDriver at runtime instead.

## License

MIT License — see [LICENSE](LICENSE) for details.
