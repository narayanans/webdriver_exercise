# webdriver_exercise

This exercise is implemented using junit and pageobject model. 

All the tests extend BaseTest.java. This allows for initializations to be deferred to the BaseTest like the browser startup and tear down. The page objects inherit a base page object which also takes care of the global header, footer and menu parts. 

A note about abstraction:
It is debated if page objects should or should not make assertions/decisions. I have not used assertions in the page objects. This way, the "what is the code doing" is all in one place - the test, and the "how" portion is in the page object. 

Reporting:
The reporting and logging are inadequate in this rather bare bones implementation. In production quality tests, I'd include more details of what is going on in the test, test data that was used, and screenshots wherever appropriate. Also missing is a helper library with commonly used functions with timeout handling.

Environment:
Maven has been used for dependency management (and build), and is a prerequisite to run the tests.
Tests have been configured to run on firefox, so that's another prerequisite. Chrome and IE may also be used but would need the server executables, and the initialization code would need to be changed in test.java.BaseTest's setUp method.

Instructions to run:
mvn test will execute the tests.
mvn surefire-report:report-only will create a surefire report.

  
