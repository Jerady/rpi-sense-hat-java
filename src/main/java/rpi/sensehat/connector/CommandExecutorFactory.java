package rpi.sensehat.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rpi.sensehat.connector.mock.MockCommandExecutor;
import rpi.sensehat.utils.OS;

/**
 * Created by jcincera on 04/07/2017.
 */
public class CommandExecutorFactory {

    private static final Logger log = LoggerFactory.getLogger(CommandExecutorFactory.class);


    private CommandExecutorFactory() {
        throw new IllegalStateException("Utility class");
    }

    public static CommandExecutor get() {
        // Dev command executor for not ARM system (macOS etc.)
        if (!OS.isArmArchitecure()) {
            log.info("ARM platform not detected! Using mock command executor.");
            return new MockCommandExecutor();
        }
        // Command executor for Raspberry PI
        return new SimpleCommandExecutor();
    }
}
