export JACOCO_PATH=jacoco/lib/
export JUNIT_PATH=lib/junit-4.13.2.jar
export HAMCREST_PATH=lib/hamcrest-core-1.3.jar

java -javaagent:$JACOCO_PATH/jacocoagent.jar=destfile=coverege.exec -cp $JUNIT_PATH:$HAMCREST_PATH:src/:test/ org.junit.runner.JUnitCore TestBuyTicket
java -jar $JACOCO_PATH/jacococli.jar report coverege.exec --classfiles src/ --sourcefiles src/ --html coverage-report

