CLASSPATH = src/:lib/hamcrest-core-1.3.jar:lib/junit-4.12.jar:classes/

CLASS_DIR = classes/

test: classes/TestSolvers.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore TestSolvers

classes/Maze.class: classes/Square.class src/Maze.java
	javac -d $(CLASS_DIR) -cp $(CLASSPATH) src/Maze.java

classes/MazeSolver.class: classes/Maze.class classes/SearchWorklist.class src/MazeSolver.java
	javac -d $(CLASS_DIR) -cp $(CLASSPATH) src/MazeSolver.java

classes/SearchWorklist.class: classes/Square.class src/SearchWorklist.java
	javac -d $(CLASS_DIR) -cp $(CLASSPATH) src/SearchWorklist.java

classes/Square.class: src/Square.java
	javac -d $(CLASS_DIR) -cp $(CLASSPATH) src/Square.java

classes/TestSolvers.class: classes/MazeSolver.class src/TestSolvers.java
	javac -d $(CLASS_DIR) -cp $(CLASSPATH) src/TestSolvers.java
