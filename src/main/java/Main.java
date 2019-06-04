import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Calculator arabicCalc = new ArabicCalculator();
        Calculator romanCalc = new RomanCalculator();
        List<Calculator> availableCalcs = Arrays.asList(arabicCalc, romanCalc);

        ConsoleHelper.writeToConsole("Welcome to calculator!");
        ConsoleHelper.writeToConsole("Available operators: +, -, /, *");
        ConsoleHelper.writeToConsole("Available numbers:");
        ConsoleHelper.writeToConsole("Arabic: 0 - 9");
        ConsoleHelper.writeToConsole("Roman: I, V, X, L, C, D, M");
        ConsoleHelper.writeToConsole("Type \"exit\" to exit.");

        while (true) {
            boolean correctOperation = false;
            String in = ConsoleHelper.readString();
            if ("exit".equalsIgnoreCase(in)) {
                break;
            }
            for (Calculator calc :availableCalcs) {
                if (calc.isValidExpression(in)) {
                    Object result = calc.operation(CalcHelper.determineOperation(in), calc.getFirstArg(in), calc.getSecondArg(in));
                    ConsoleHelper.writeToConsole(in + " = " + result.toString());
                    correctOperation = true;
                }
            }
            if (!correctOperation) {
                ConsoleHelper.writeToConsole("Incorrect expression!");
            }
        }
        ConsoleHelper.destroy();
    }

}
