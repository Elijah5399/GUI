/**
 *
 * @author elijahchia
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class PowerTracker {
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
            //System.out.println(output.toString());
            String output1 = output.toString();
            String[] lines = output1.split("\n");
            String[] intArr = new String[lines.length - 3];
            for (int i = 3; i < lines.length; i++) {
                intArr[i - 3] = lines[i];
                //System.out.println(lines[i]);
            }

            String[][] finalArr = new String[intArr.length][2];
            for (int i = 0; i < intArr.length; i++) {
                String[] taskDetails = intArr[i].split("\\s{2,}");
                finalArr[i][0] = taskDetails[0];
                finalArr[i][1] = taskDetails[2];
            }
            return finalArr;

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean isCorrectPassword(String password) {
        if (PowerTracker.track(password) == null) {
            return false;
        } else {
            return true;
        }
    }
}
