package scr.com.avaj_launcher.simulator;

import scr.com.avaj_launcher.input_output.Logger;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String type;

	private static long idCounter = 0;

	protected Aircraft(String arg_name, Coordinates arg_coordinates)
	{
		this.name = arg_name;
		this.coordinates = arg_coordinates;
		this.id = this.nextId();
	}

	private long nextId()
	{
		Aircraft.idCounter++;
		return Aircraft.idCounter - 1;
	}

	protected void log(String message)
	{
		String toLog = getDescription() + ": " + message;
		Logger.log(toLog);
	}

	public String getDescription()
	{
		return this.type + '#' + this.name + '(' + this.id + ")";
	}

	protected void move(Coordinates coords)
	{
		int	newLatitude;
		int	newLongitude;
		int	newHeight;

		if (coords.getHeight() > 100)
			newHeight = 100;
		else if (coords.getHeight() <= 0)
		{
			this.coordinates = new Coordinates(coords.getLongitude(), coords.getLatitude(), 0);
			land();
			return ;
		}
		else
			newHeight = coords.getHeight();

		if (coords.getLatitude() < 0)
			newLatitude = 0;
		else
			newLatitude = coords.getLatitude();

		if (coords.getLongitude() < 0)
			newLongitude = 0;
		else
			newLongitude = coords.getLongitude();

		this.coordinates = new Coordinates(newLongitude, newLatitude, newHeight);
	}

	protected abstract void land();
}
