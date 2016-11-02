javac -cp "jars/*;." step_definitions/MoveClassTest.java MySQL/MySQLAccess.java implementation/MoveClass.java
                     
java -cp "jars/*;." cucumber.api.cli.Main -p progress --snippets camelcase features -g step_definitions features