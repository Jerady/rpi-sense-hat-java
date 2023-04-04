package rpi.sensehat.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by jcincera on 22/06/2017.
 */
class EnvironmentalSensorTest {

    private final EnvironmentalSensor sensor = new EnvironmentalSensor();

    @Test
    void getHumidityTest() {
        float humidity = sensor.getHumidity();
        assertTrue(humidity > 10.0);
        assertTrue(humidity < 100.0);
    }

    @Test
    void getTemperatureTest() {
        float temperature = sensor.getTemperature();
        assertTrue(temperature > 10.0);
        assertTrue(temperature < 100.0);
    }

    @Test
    void getTemperatureFromHumidityTest() {
        float temperatureFromHumidity = sensor.getTemperatureFromHumidity();
        assertTrue(temperatureFromHumidity > 10.0);
        assertTrue(temperatureFromHumidity < 100.0);
    }

    @Test
    void getTemperatureFromPressureTest() {
        float temperatureFromPressure = sensor.getTemperatureFromPressure();
        assertTrue(temperatureFromPressure > 10.0);
        assertTrue(temperatureFromPressure < 100.0);
    }

    @Test
    void getPressureTest() {
        float pressure = sensor.getPressure();
        assertTrue(pressure > 20.0);
        assertTrue(pressure < 1000.0);
    }
}
