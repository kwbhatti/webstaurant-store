# Webstaurant Store Automation

Automation project for Webstaurant Store


## Execution

- Eclipse/IntelliJ Run button (takes default values)
- Command Line:

    - command `mvn clean install`

    - options
        - groups = Will work if test is tagged with group
        - env = <DEV|QA|PROD> (by default uses PROD)
        - browser = <CHROME|IE|FIREFOX> (be default uses CHROME)
        - example `mvn -Denv=QA -Dbrowser=FIREFOX`

## Artifacts

- Report is generated in ./target/Report.html
- Log is generated in ./target/Logs.html

## Authors

- Khurram Waleed Bhatti