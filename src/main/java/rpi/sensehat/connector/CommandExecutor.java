package rpi.sensehat.connector;

import rpi.sensehat.api.dto.CommandResult;

/**
 * Created by jcincera on 21/06/2017.
 */
public interface CommandExecutor {

    String LINE_SEPARATOR = System.getProperty("line.separator");

    CommandResult execute(Command command, String... args);
}
