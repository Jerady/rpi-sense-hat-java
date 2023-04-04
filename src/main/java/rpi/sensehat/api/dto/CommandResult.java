package rpi.sensehat.api.dto;

import rpi.sensehat.api.RpiSenseHatException;

/**
 * Created by jcincera on 22/06/2017.
 */
public class CommandResult {

    private final String value;

    public CommandResult(String value) {
        this.value = value;
    }

    public float getFloat() {
        return Float.parseFloat(value);
    }

    public IMUData getIMUData() {
        final String[] result = value.split("@");
        if (result.length != 3) {
            throw new RpiSenseHatException("Invalid orientation: " + value);
        }
        return new IMUData(
                Float.parseFloat(result[0]),
                Float.parseFloat(result[1]),
                Float.parseFloat(result[2])
        );
    }

    public IMUDataRaw getIMUDataRaw() {
        final String[] result = value.split("@");
        if (result.length != 3) {
            throw new RpiSenseHatException("Invalid orientation: " + value);
        }
        return new IMUDataRaw(
                Float.parseFloat(result[0]),
                Float.parseFloat(result[1]),
                Float.parseFloat(result[2])
        );
    }

    public JoystickEvent getJoystickEvent() {
        final String[] result = value.split("@");
        if (result.length != 3) {
            throw new RpiSenseHatException("Parsing joystick event failed: " + value);
        }
        return new JoystickEvent(
                result[0],
                result[1],
                result[2]
        );
    }
}
