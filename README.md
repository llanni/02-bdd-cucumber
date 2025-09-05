# 02 - Add Cucumber (updated suite runner)
A Java Maven Project showing an example of BDD usage with Gherkin and Cucumber, against the https://www.saucedemo.com/ demo eCommerce.

## Run (headless)
```bash
mvn clean -Dheadless=true test
```

## Run (browser)
```bash
mvn clean -Dheadless=false test
```

- Features are under `src/test/resources/features`
- Glue (steps) are under `com.qaroots.training.bdd`
