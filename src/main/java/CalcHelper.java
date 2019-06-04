import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CalcHelper {

    private enum RomanNumeral {
        I (1),
        IV (4),
        V (5),
        IX (9),
        X (10),
        XL (40),
        L (50),
        XC (90),
        C (100),
        CD (400),
        D (500),
        CM (900),
        M (1000);

        int arabicValue;

        RomanNumeral(int arabicValue) {
            this.arabicValue = arabicValue;
        }

        public int getArabicValue() {
            return arabicValue;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.arabicValue).reversed())
                    .collect(Collectors.toList());
        }
    }

    public static int romanToArabic(String s){
        int total = 0;
        int pivot = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int current = valueOfRoman(s.charAt(i));
            if (current >= pivot){
                pivot = current;
                total += pivot;
            } else {
                total -= current;
            }
        }
        return total;
    }

    private static int valueOfRoman(Character numeric) {
        return RomanNumeral.valueOf(numeric.toString().toUpperCase()).getArabicValue();
    }

    public static String arabicToRoman(int number) {
        if (number > 0 && number <= 4000) {
            List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();
            int i = 0;
            StringBuilder sb = new StringBuilder();
            while ((number > 0) && (i < romanNumerals.size())) {
                RomanNumeral currentSymbol = romanNumerals.get(i);
                if (currentSymbol.getArabicValue() <= number) {
                    sb.append(currentSymbol.name());
                    number -= currentSymbol.getArabicValue();
                } else {
                    i++;
                }
            }
            return sb.toString();
        }
        return String.format("Value [%d] cant be converted into Roman numeric", number);
    }

    public static BiFunction<Integer, Integer, Integer> determineOperation(String expression) {
        if (expression.contains("+")) {
            return (a, b) -> a + b;
        }
        if (expression.contains("-")) {
            return (a, b) -> a - b;
        }
        if (expression.contains("/")) {
            return (a, b) -> a / b;
        }
        if (expression.contains("*")) {
            return (a, b) -> a * b;
        }
        throw new IllegalArgumentException("Calculator can only process the following operators: +, -, /, *.");
    }

}
