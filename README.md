# JUnit5 Course

JUnit 5 (2017) requires Java 8 at runtime

Code that has been compiled with Java versions before 8 can be run with JUnit 5

Mock frameworks

- Mockito
- Wiremock

course link https://github.com/bonigarcia/mastering-junit5

very good intro https://www.youtube.com/watch?v=AGcdT1W3eXA

## JUnit 4 limitations

Runner API
Runners: used to execute a test case (JUnit 4 @RunWith)
@RunWith is not composable: a parametrized test cannot be combined with Spring support 

Rules
annoted fields of the test class, allow addition or redefinition of tests behaviour
before and after the execution of the test.
Junit 4 doesn't allow to use a single rule for method-level and class-level

`@Rule
public ErrorCollector errorCollector = new ErrorCollector();
`

`@ClassRule
public TemporaryFolder temporaryFolder = new TemporaryFolder();
`

## Architecture

JUnit 5 is
- Modular: Platform + Jupiter + Vintage
- Extensible: provides the Extension API to register extension declaratively `@ExtendWith(MockitoExtension.class)`
- Forward and backward compatible: Junit 4 can be executed on JUnit 5 and JUnit 4 Runner allows to run JUnit 5 tests `@RunWith(JUnitPlatform.class)`

JUnit 5 framework consists of 
- Platform: the foundation for launching different testing frameworks on the JVM (Legacy JUnit 4, Spock, Cucumber, etc.)
- Jupiter: provides a brand new programming and extension models for writing tests `@Test`
- Vintage: for running legacy code JUnit 3 and 4

Platform
- junit-platform-launcher: public API for configuring and launching test plans, used by IDEs and build tools
- junit-platform-engine: public API for test engines. Third parties may also contribute their own TestEngine by implementing
the interfaces declared in this module and registering their engine
- junit-platform-runner: runner and annotations for configuring and executing tests
- junit-platform-console: support for discovering and executing tests on the JUnit platform from the console
- junit-platform-surefire-provider: support for discovering and executing tests on the JUnit platform using Maven Surefire
- junit-platform-gradle-plugin: support for discovering and executing tests on the JUnit platform using Gradle

Jupiter
- junit-jupiter-api
- junit-jupiter-engine: implementation of the engine API for JUnit Jupiter

Vintage
- junit 4.12
- junit-vintage-engine: allow to run vintage tests with the launcher infrastructure

### Platform APIs

TestEngine API
it allows developing any testing framework that runs on the JVM.
In JUnit 5 there are two TestEngine implementations out of the box
- junit-vintage-engine: allows running legacy tests (JUnit 3 and 4) in the JUnit platform
- junit-jupiter-engine: new JUnit 5 programming model (Jupiter) 

Third party libraries (E.g. Spock, Cucumber, FitNesse) can plug into the JUnit platform launching infrastructure by 
providing a custom TestEngine

### Launcher API

It makes the interface between JUnit and its programmatic clients (build tools and IDEs) more powerful and stable.
The API is used by IDEs and build tools for discovering, filtering and executing tests 

### Extension Model

The extension model is specific for the Jupiter programming model and provides interoperability between
Jupiter and existing frameworks (Spring and Mockito)

Each extension in Jupiter must implement the marker interface `Extension`

`@ExtendWith` can be used to register one or more extensions, it can be declared on interfaces, classes
methods or fields

The package org.junit.jupiter.api.extension since it contains all extension defined in Jupiter

### Assertion Libraries
- JUnit Jupiter (built-in)
- Hamcrest
- AssertJ
- Truth

## JUnit 5 Jupiter Functionalities

Here a list of new functionalities in JUnit 5 Jupiter programming model

- Visibility: everything does not have to be `public`
- Custom display names
- Tagging (Category)
- Meta-annotation support
- Conditional test execution
- Dependency injection for constructor and methods
- Interface default methods and testing traits
- `@Nested` test classes
- `@RepeatedTest`, `@ParameterizedTest`, `@TestFactory`

### Tagging - Filter Tests with Gradle
We can filter tests to be executed based on:

- Test engine: using the keyword engines we can include or exclude the test engine to be used
- Tags: using the keyword tags
- Packages: using the keyword packages
- Class name patterns: using the keyword includeClassNamePattern

### Meta Annotations and Composed Annotations
https://junit.org/junit5/docs/current/user-guide/#writing-tests-meta-annotations

### Disable Test Based on a Condition
https://github.com/bonigarcia/mastering-junit5/tree/master/junit5-conditional-tests

### Assumptions
Assumptions allow to only run tests if certain conditions are as expected

The methods `assumeTrue` and `assumeFalse` can be used to skip tests whose preconditions are not met

The method `assumingThat` is used to condition the execution of a part in a test

### Nested
Nested tests give the test writer more capabilities to express the relationship among several group of tests

### Repeated
The ability to repeat a test a specified number of times with the annotation `@RepeatedTest(2)`

https://junit.org/junit5/docs/current/user-guide/#writing-tests-repeated-tests

### Parameterized
https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests

### Dynamic Test
Static tests are the tests defined at compile time `@Test`

JUnit 5 allows to generate test at runtime by a factory method that is annotated with `@TestFactory`

A Dynamic test is created using the DynamicTest class in Jupiter

https://junit.org/junit5/docs/current/user-guide/#writing-tests-dynamic-tests 

### Jupiter 5.3

Parallel Test Execution
Execution mode and Synchronization