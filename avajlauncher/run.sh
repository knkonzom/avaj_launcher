find . -name "*.java" > sources.txt
javac -sourcepath @sources.txt
java avajlauncher.avaj.simulator scenario.txt