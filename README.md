# 02 - Add Cucumber (updated suite runner)

This version uses the JUnit Platform Suite (`@Suite`) instead of the deprecated `@Cucumber`.

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
