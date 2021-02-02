find . -name "*.java" > sources.txt
javac -sourcepath -d @sources.txt
java avaj.SimulatorMain scenario.txt