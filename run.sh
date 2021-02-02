find . -name "*.java" > sources.txt
javac -sourcepath @sources.txt
java SimulatorMain.java scenario.txt