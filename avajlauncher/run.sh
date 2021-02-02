find . -name "*.java" > sources.txt
javac -sourcepath -d @sources.txt
java Simulator scenario.txt