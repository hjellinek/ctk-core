# Testing using your IDE

If you happen to work with an IDE that provides JUnit support IDE (such as IntelliJ or Eclipse) you can directly run the tests and Suites. But, in order for this to work you'll need to configure your IDE to put the `testpack`, `transport` and `schema` modules on the classpath for your tests module.

## Configuring IntelliJ
Check out the ctk-core project from github using the IntelliJ VCS support (VCS -> Checkout from Version Control -> Github) and let IntelliJ create the multi-module Maven project; you'll want to open a terminal window  and do the `git submodule init` and `git submodule update` to get the schemas installed locally.

Now open the File -> Project Structure dialog, and select the `Modules` setting. Choose the `cts-java` module and then the Dependencies tab. Make sure you have `ctk-testpack` and `ctk-transport` and `ctk-schemas` indicated as `compile` dependencies (if not add them, using the green '+' and as module dependencies)

## Configuring Eclipse
TBD 
