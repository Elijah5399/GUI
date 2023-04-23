import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * PowerTracker class.
 * Provides the following functionality:
 * 1. A track method which takes in a password and returns a 3D array of tasks and their CPU usage.
 * 2. A password verifier method which takes in a password and returns a boolean indicating
 *    if the password is correct.
 * @author elijahchia
 */

public class PowerTracker {
    /**
     * A method which takes in a possibly invalid password, and returns a 3D array containing
     * tasks and their CPU usage. Uses the powermetrics command for this functionality.
     * @param password The entered password.
     * @return null if password is invalid, and the 3D array otherwise.
     */
    public static String[][] track(String password) {
        try {
            // Execute the powermetrics command and retrieve power usage data
            ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "echo " + password + " | sudo -S powermetrics -n 1 -i 1000");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line = reader.readLine();
            if (line == null) {
                //if there is no output we have entered the wrong password
                return null;
            }
            //Parse the output to see only running tasks and their details
            boolean takingOutput = false;
            while (line != null) {
                if (line.startsWith("*** Running tasks ***")) {
                    takingOutput = true;
                } else if (line.startsWith("ALL_TASKS")) {
                    takingOutput = false;
                }
                if (takingOutput) {
                    output.append(line).append("\n");
                }
                line = reader.readLine();
            }
            process.waitFor();
            String output1 = output.toString();
            String[] lines = output1.split("\n");
            String[] intArr = new String[lines.length - 3];
            for (int i = 3; i < lines.length; i++) {
                intArr[i - 3] = lines[i];
            }
            //finalArr is the final array, which is a n * 2 array.
            //Each row is a task, with the 0th column being the task name and
            //the 1th column being the CPU usage of the task.
            String[][] finalArr = new String[intArr.length][2];
            for (int i = 0; i < intArr.length; i++) {
                String[] taskDetails = intArr[i].split("\\s{2,}");
                finalArr[i][0] = taskDetails[0];
                finalArr[i][1] = taskDetails[2];
                System.out.println(intArr[i]);
            }
            return finalArr;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A method to check if the password provided is valid.
     * @param password The provided password.
     * @return true if password is valid and false otherwise.
     */
    public static boolean isCorrectPassword(String password) {
        if (PowerTracker.track(password) == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * The constructor method for PowerTracker. We do not use it.
     */
    PowerTracker(){}
}
