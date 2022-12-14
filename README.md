# Javaagent-for-JavaAssist-Framework
This repository is a small proof of concept for creating java agent with java assist framework.

To build this project :-
1. Run as Maven Install
2. Run as Maven Build
3. Specify Goals :- clean verify
4. Go to the main project location via terminal
5. Run the below command -
    
java -javaagent:./javagent/target/javagent-0.0.1-SNAPSHOT-jar-with-dependencies.jar -jar ./testing-application/target/testing-application-0.0.1-SNAPSHOT-jar-with-dependencies.jar
