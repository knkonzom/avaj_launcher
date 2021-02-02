package src.com.avaj_launcher.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import src.com.avaj_launcher.interfaces.Flyable;
import src.com.avaj_launcher.io.Logger;


public class Simulator {
	public static void main(String[] args) {

		if (args.length <= 0)
		{
			System.out.println("Please input an argument file: ");
			System.exit(2);
		}
		else
		{
			System.out.println("\nInput file: " + args[0]);
		}

		try
		{
			Logger.setOutputFile("simulation.txt");
		} catch (IOException e)
		{
			System.out.println("Error : Can't open file simulation .txt for writing.");
			return ;
		}

		WeatherTower tower = new WeatherTower();
		ArrayList<Flyable> flyables = new ArrayList<>();

		try
		{
			FileReader fileReader = new FileReader(args[0]);
			BufferedReader bufReader = new BufferedReader(fileReader);

			String fline = bufReader.readLine();
			int nbr_simulations;
			try
			{
				nbr_simulations = Integer.parseInt(fline);
			} catch (NumberFormatException e)
			{
				throw new SimulatorException("Error: Enter a valid number of simulations");
			}
			System.out.println(nbr_simulations + " simulations successfully ran.");

			String current_line;

			while ((current_line = bufReader.readLine()) != null)
			{
				String array[] = current_line.split(" ");
				if (array.length != 5)
					throw new SimulatorException("Error: Incorrect Input File - each Aircraft must have 5 fields");
				try
				{
					flyables.add(AircraftFactory.newAircraft(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4])));
				}
				catch (NumberFormatException e)
				{
					throw new SimulatorException ("Error: number expected [" + current_line + "]");
				}
			}

			for (Flyable flyable: flyables)
				flyable.registerTower(tower);

			for (int i = 0; i < nbr_simulations; i++)
				tower.changeWeather();
			// System.out.println(" COMPLETE! \n Check 'simulation.txt'");
		}
		catch (IOException e)
		{
			System.out.println("Error: Input / Output");
		}
		catch (SimulatorException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
