package rpi.sensehat.connector.mock;

import rpi.sensehat.api.dto.CommandResult;
import rpi.sensehat.api.dto.IMUData;
import rpi.sensehat.api.dto.IMUDataRaw;

/**
 * Created by jcincera on 04/07/2017.
 */
public class MockCommandResult extends CommandResult {


    public MockCommandResult(String value) {
        super(value);
    }

    @Override
    public float getFloat() {
        return 30.0f;
    }

    @Override
    public IMUData getIMUData() {
        return new IMUData(5.0f, 6.0f, 6.5f);
    }

    @Override
    public IMUDataRaw getIMUDataRaw() {
        return new IMUDataRaw(1.5f, 5.5f, 3.8f);
    }

}
