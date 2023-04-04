package rpi.sensehat.api;

public class RpiSenseHatException extends RuntimeException {

    public RpiSenseHatException(String message) {
        super(message);
    }

    public RpiSenseHatException(String message, Exception e) {
        super(message, e);
    }
}
