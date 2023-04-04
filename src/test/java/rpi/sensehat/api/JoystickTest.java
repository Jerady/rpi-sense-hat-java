package rpi.sensehat.api;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import rpi.sensehat.api.dto.JoystickEvent;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Disabled
class JoystickTest {

    private final Joystick joystick = new Joystick();

    @Test
    void waitForEventTest() {
        JoystickEvent e = joystick.waitForEvent();

        System.out.println("Action: " + e.getAction());
        System.out.println("Direction: " + e.getDirection());
        System.out.println("Timestamp: " + e.getTimestamp());

        assertNotNull(e.getAction());
        assertNotNull(e.getDirection());
        assertNotNull(e.getTimestamp());
    }

    @Test
    void waitForEventWithEmptyBufferTest() {
        JoystickEvent e = joystick.waitForEvent(true);

        System.out.println("Action: " + e.getAction());
        System.out.println("Direction: " + e.getDirection());
        System.out.println("Timestamp: " + e.getTimestamp());

        assertNotNull(e.getAction());
        assertNotNull(e.getDirection());
        assertNotNull(e.getTimestamp());
    }
}
