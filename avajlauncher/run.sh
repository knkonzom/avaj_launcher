rm -rf simulation.txt
find . -name "*.java" > sources.txt
javac -sourcepath @sources.txt
java avaj.Simulator Scenario.txt
rm -rf avaj/*.class