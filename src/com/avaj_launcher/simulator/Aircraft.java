package src.com.avaj_launcher.simulator;

import src.com.avaj_launcher.io.Logger;

public abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	protected String type;

	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
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

	protected void move(Coordinates coordinates)
	{
		int	newLatitude;
		int	newLongitude;
		int	newHeight;

		if (coordinates.getHeight() > 100)
			newHeight = 100;
		else if (coordinates.getHeight() <= 0)
		{
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), 0);
			land();
			return ;
		}
		else
			newHeight = coordinates.getHeight();

		if (coordinates.getLatitude() < 0)
			newLatitude = 0;
		else
			newLatitude = coordinates.getLatitude();

		if (coordinates.getLongitude() < 0)
			newLongitude = 0;
		else
			newLongitude = coordinates.getLongitude();
		this.coordinates = new Coordinates(newLongitude, newLatitude, newHeight);
	}
	protected abstract void land();
}
