import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readString() {
        writeToConsole("Enter expression: ");
        try {
            return reader.readLine().trim().toUpperCase();
        } catch (IOException e) {
            writeToConsole("Error during reading from console!");
        }
        return "";
    }

    public static void writeToConsole(String s) {
        System.out.println(s);
    }

    public static void destroy() {
        try {
            reader.close();
        } catch (IOException e) {
            writeToConsole("Cant close reader!");
        }
    }

}
