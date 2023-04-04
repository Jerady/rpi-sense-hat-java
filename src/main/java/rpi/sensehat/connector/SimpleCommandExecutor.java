package rpi.sensehat.connector;

import rpi.sensehat.api.RpiSenseHatException;
import rpi.sensehat.api.dto.CommandResult;
import rpi.sensehat.utils.OS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by jcincera on 20/06/2017.
 */
public class SimpleCommandExecutor implements CommandExecutor {

    private static final String ANNOYING_COLOR_SENSOR_WARNING = "WARNING:root:Failed to initialise TCS34725 colour sensor. (sensor not present)";


    SimpleCommandExecutor() {
        if (!OS.isArmArchitecure()) {
            throw new RpiSenseHatException("System architecture is not supported for this command executor");
        }
    }

    @Override
    public CommandResult execute(Command command, String... args) {
        try {
            // Create command
            final String completeCommand = createCompleteCommand(command, args);

            // Call
            ProcessBuilder pb = new ProcessBuilder("python", "-c", completeCommand);
            pb.redirectErrorStream(true);
            Process p = pb.start();

            // Read output
            BufferedReader output = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = output.readLine()) != null) {
                result.append(line);
                result.append(LINE_SEPARATOR);
            }
            // Handle result
            waitForCommand(p);
            return new CommandResult(cleanupResult(result.toString()));
        } catch (Exception e) {
            throw new RpiSenseHatException("Communication with Sense Hat failed!", e);
        }
    }

    private String cleanupResult(String result) {
        return result.replace(ANNOYING_COLOR_SENSOR_WARNING, "").trim();
    }

    private String createCompleteCommand(Command command, String[] args) {
        String rawCommand = (args != null && args.length > 0) ?
                String.format(command.getCommand(), (Object[]) args) :
                command.getCommand();
        return Command.IMPORT_SENSE_HAT.getCommand() + ";" +
                Command.SENSE_OBJECT.getCommand() + ";" +
                rawCommand;
    }

    private void waitForCommand(Process p) {
        try {
            p.waitFor();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
