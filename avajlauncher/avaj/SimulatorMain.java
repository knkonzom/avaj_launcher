package avaj;

// import avaj.AircraftFactory;
// import avaj.Flyable;
// import avaj.WeatherTower;
// import avaj.InvalidFileException;

import java.io.*;
// import java.lang.*;
// import java.util.*;

public class SimulatorMain {
    public static void main(String[] args) throws InvalidFileException {
        
        WeatherTower getTower = new WeatherTower();
        try {
            if (args.length != 1) {
                if (args.length == 0) {
                    System.out.println("Not enough arguments found.");
                    System.exit(1);
                } else if (args.length > 1) {
                    System.out.println("Invalid argument found.");
                    System.exit(1);
                }
            }
            BufferedReader readFile = new BufferedReader(new FileReader(args[0]));
            String line = readFile.readLine();
            if (line.length() <= 0) {
                System.out.println("No simulations found!");
                System.exit(1);
            }
            Flyable air;
            if (line != null) {
                int simulationCount = Integer.parseInt(line.split(" ")[0]);
                if (simulationCount <= 0) {
                    System.out.println(simulationCount + " is an invalid number of times the weather changes.");
                    System.exit(1);
                }

                File createFile = new File("simulation.txt");
                FileOutputStream returnOutput = new FileOutputStream(createFile);
                System.setOut(new PrintStream(returnOutput));
                while ((line = readFile.readLine()) != null) {
                    if (line.split(" ").length != 5) {
                        System.out.println("Incorrect format!");
                        System.exit(1);
                    }
                    String [] getLineColumn = line.split(" ");
                    int longitude = Integer.parseInt(line.split(" ")[2]);
                    int latitude = Integer.parseInt(line.split(" ")[3]);
                    int height = Integer.parseInt(line.split(" ")[4]);

                    air = AircraftFactory.newAircraft(getLineColumn[0], getLineColumn[1], longitude, latitude, height);

                    getTower.register(air);
                    air.registerTower(getTower);
                }
                for (int x = 1; x <= simulationCount; x++) {
                    getTower.changeWeather();
                }
            }
            readFile.close();
        } catch(Exception e) {
            if (!args[0].equalsIgnoreCase("scenario.txt")){
                throw new InvalidFileException("Incorrect file name - please enter correct name!");
            }
        }
    }
}