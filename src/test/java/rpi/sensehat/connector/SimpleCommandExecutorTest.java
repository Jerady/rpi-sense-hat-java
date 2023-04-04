package rpi.sensehat.connector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Created by jcincera on 20/06/2017.
 */
class SimpleCommandExecutorTest {

    private final SimpleCommandExecutor commandExecutor = new SimpleCommandExecutor();

    @BeforeEach
    public void setup() {
        assertTrue(System.getProperty("os.arch").toLowerCase().contains("arm"));
    }

    @Test
    void getHumidityTest() {
        float humidity = commandExecutor.execute(Command.GET_HUMIDITY).getFloat();
        assertTrue(humidity > 10.0);
        assertTrue(humidity < 100.0);
    }

    @Test
    void getTemperatureTest() {
        float temperature = commandExecutor.execute(Command.GET_TEMPERATURE).getFloat();
        assertTrue(temperature > 10.0);
        assertTrue(temperature < 100.0);
    }

    @Test
    void getTemperatureFromHumidityTest() {
        float temperatureFromHumidity = commandExecutor.execute(Command.GET_TEMPERATURE_FROM_HUMIDITY).getFloat();
        assertTrue(temperatureFromHumidity > 10.0);
        assertTrue(temperatureFromHumidity < 100.0);
    }

    @Test
    void getTemperatureFromPressureTest() {
        float temperatureFromPressure = commandExecutor.execute(Command.GET_TEMPERATURE_FROM_PRESSURE).getFloat();
        assertTrue(temperatureFromPressure > 10.0);
        assertTrue(temperatureFromPressure < 100.0);
    }

    @Test
    void getPressureTest() {
        float pressure = commandExecutor.execute(Command.GET_PRESSURE).getFloat();
        assertTrue(pressure > 100.0);
        assertTrue(pressure < 1000.0);
    }
}
