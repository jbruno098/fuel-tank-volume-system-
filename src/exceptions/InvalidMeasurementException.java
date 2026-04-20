package exceptions;

public class InvalidMeasurementException extends RuntimeException{

    public InvalidMeasurementException(String msg) {
        super(msg);
    }
}
