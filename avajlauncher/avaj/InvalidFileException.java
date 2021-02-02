package avaj;

import java.lang.*;
import avaj.WeatherTower;

public class InvalidFileException extends Exception {

    public InvalidFileException(String message) {
        super(message);
    }
}
