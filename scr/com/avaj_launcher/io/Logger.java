package scr.com.avaj_launcher.io;

import java.io.*;

public class Logger
{
	private static Writer writer = null;

	public static void setOutputFile(String filename) throws IOException
	{
		if (Logger.writer != null)
			Logger.writer.close();
		Logger.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
	}

	public static void log(String message)
	{
		try
		{
			Logger.writer.write(message + '\n');
			writer.flush();
		}
		catch (IOException e)
		{
			System.out.println("Error: File Not Written!");
			System.exit(1);
		}
	}
 }
