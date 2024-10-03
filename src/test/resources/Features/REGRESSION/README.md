# Cucumber tests Execution Tags - Web

## Validations Tests


### Production environment
APAC - `@validationTests and @apac and @live`

EU - `@validationTests and @eu and @live`

US - `@validationTests and @nwk and @live`


### Non-Production environment
APAC - `@validationTests and @apac`

EU - `@validationTests and @eu`

US - `@validationTests and (@nwk or @us)`


## Agile Regression Tests


### Prod/Non-Prod environment
uk - `@agileRegression and @eu`

fr - `@agileRegression and @eu`

au - `@agileRegression and @apac`

cn - `@agileRegression and (@apac and not @nacn or @chinaOnly)`

us - `@agileRegression and @nwk`

mx - `@agileRegression and @nwk`

## Smoke Tests
sg/APAC - `@websmoketest and @apac`

uk/EU - `@websmoketest and @eu`

cpc - `@websmoketest and @cpc`

us/NWK - `@websmoketest and @nwk`

# Cucumber tests Execution Tags - Mobile

## Validations Tests

### Production environment
APAC - `@mobValidationTests and @apac and @live`

EU - `@mobValidationTests and @eu and @live`

US - `@mobValidationTests and @nwk and @live`

### Non-Production environment
APAC - `@mobValidationTests and @apac`

EU - `@mobValidationTests and @eu`

US - `@mobValidationTests and @nwk`

## Smoke Tests
sg - `@mobsmoketest and @apac`

uk - `@mobsmoketest and @eu`

us- `@mobsmoketest and @nwk`

## Agile Regression Tests


### Prod/Non-Prod environment
APAC - `@mobAgileRegression and @apac and @live`

EU - `@mobAgileRegression and @eu and @live`

US - `@mobAgileRegression and @nwk and @live`
