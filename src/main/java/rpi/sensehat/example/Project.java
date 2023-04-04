package rpi.sensehat.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpi.sensehat.api.SenseHat;

/**
 * Created by jcincera on 03/07/2017.
 */
public class Project {
    private static final Logger log = LoggerFactory.getLogger(Project.class);

    public static void main(String[] args) {
        SenseHat senseHat = new SenseHat();
        float humidity = senseHat.environmentalSensor.getHumidity();
        log.info("Current humidity: {}", humidity);
        senseHat.ledMatrix.showMessage("my project");
        senseHat.ledMatrix.waitFor(5);
        senseHat.ledMatrix.clear();
    }
}
