package scr.com.avaj_launcher.input_output;

import java.io.*;

public class Logger
{
	private static Writer writer = null;

	public static void setOutputFile(String filename) throws IOException
	{
		if (Logger.writer != null)
			Logger.writer.close();
		Logger.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
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
			System.out.println("Error while trying to write to the file");
			System.exit(1);
		}
	}
 }
