package rpi.sensehat.api;

import org.junit.jupiter.api.Test;
import rpi.sensehat.api.dto.IMUData;
import rpi.sensehat.api.dto.IMUDataRaw;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Created by jcincera on 28/06/2017.
 */
class IMUTest {

    private final IMU imu = new IMU();

    @Test
    void setImuConfigTest() {
        imu.setIMUConfig(true, true, true);
        assertTrue(true);
    }

    @Test
    void getOrientationRadiansTest() {
        IMUData result = imu.getOrientationRadians();
        assertTrue(result.getPitch() < 7);
        assertTrue(result.getRoll() < 7);
        assertTrue(result.getYaw() < 7);
    }

    @Test
    void getOrientationDegreesTest() {
        IMUData result = imu.getOrientationDegrees();
        assertTrue(result.getPitch() < 370);
        assertTrue(result.getRoll() < 370);
        assertTrue(result.getYaw() < 370);
    }

    @Test
    void getOrientationTest() {
        IMUData result = imu.getOrientation();
        assertTrue(result.getPitch() < 370);
        assertTrue(result.getRoll() < 370);
        assertTrue(result.getYaw() < 370);
    }

    @Test
    void getCompassTest() {
        float compass = imu.getCompass();
        assertTrue(compass > -1);
        assertTrue(compass < 370);
    }

    @Test
    void getCompassRawTest() {
        IMUDataRaw result = imu.getCompassRaw();
        assertTrue(result.getX() < 370);
        assertTrue(result.getY() < 370);
        assertTrue(result.getZ() < 370);
    }

    @Test
    void getGyroscopeTest() {
        IMUData result = imu.getGyroscope();
        assertTrue(result.getPitch() < 7);
        assertTrue(result.getRoll() < 7);
        assertTrue(result.getYaw() < 7);
    }

    @Test
    void getGyroscopeRawTest() {
        IMUDataRaw result = imu.getGyroscopeRaw();
        assertTrue(result.getX() < 7);
        assertTrue(result.getY() < 7);
        assertTrue(result.getZ() < 7);
    }

    @Test
    void getAccelerometerTest() {
        IMUData result = imu.getAccelerometer();
        assertTrue(result.getPitch() < 370);
        assertTrue(result.getRoll() < 370);
        assertTrue(result.getYaw() < 370);
    }

    @Test
    void getAccelerometerRawTest() {
        IMUDataRaw result = imu.getAccelerometerRaw();
        assertTrue(result.getX() < 7);
        assertTrue(result.getY() < 7);
        assertTrue(result.getZ() < 7);
    }
}
