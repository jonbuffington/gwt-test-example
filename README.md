GWT Unit and Integration Testing
================================

This project is a simple example demonstrating how to combine both unit and integration tests for [Google Web Toolkit][gwt] (GWT) projects. The project uses [Apache Maven][mvn] as the build tool. You can import this project into your favorite development IDE or run `mvn verify` from the command-line.

The project uses _logic tests_ as a name for unit tests that execute solely in the Java Runtime Environment (JRE). _Application tests_ refer to integration tests that require GwtTestCase and a browser to execute. Application tests are configured to run HtmlUnit by default.

I will be publishing a tutorial soon on my [web site][jcb]. Stay tuned.

[gwt]: http://code.google.com/webtoolkit/  "Google Web Toolkit"
[mvn]: http://maven.apache.org/ "Apache Maven"
[jcb]: http://blog.jon.buffington.name/ "Jon Buffington"
