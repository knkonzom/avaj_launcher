package avaj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger buff = null;
    private static BufferedWriter bufferedWriter = null;
    private static File file;
    private static FileWriter fileWriter;

    private Logger() {
    }

    public static Logger getLogger() {
        if (buff == null) {
            try {
                buff = new Logger();
                file = new File("simulation.txt");
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch (IOException e) {
            }
        }
        return buff;
    }

    public void logToFile(String str) {
        try {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        } catch (IOException e) {}
    }

    public void close() {
        try {
            if (bufferedWriter != null)
                bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to close BufferedWriter " + e);
        }
    }
}
