# Karate Framwork with Junit4

### This project is running on java zulu 17.0.7.
### This project use maven 3.9.2.

Run all runner files:

```mvn test```

Run runner file (TestRunner.java):

```mvn test -Dtest=TestRunnerGET```

Run features with labels:

```mvn test -Dkarate.options='-t=@Test2'```

```mvn test -Dkarate.options='-t=@dev -t=@src' -Dtest=ExamplesTest```

Run a test with the same label:

```mvn clean test -Dkarate.options='-t=@TestParam'```

## Extra.

See ssh public keys:

```cat ~/.ssh/id_rsa.pub```

Delete the control of git into the project:

```rm -rf .git```
