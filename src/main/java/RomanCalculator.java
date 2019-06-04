import java.util.function.BiFunction;

public class RomanCalculator implements Calculator<String> {

    private static final String MATH_EXPRESSION = "^[IVXLCDM]+(\\s)*" + VALID_OPERATIONS + "(\\s)*[IVXLCDM]+$";

    @Override
    public String operation(BiFunction<Integer, Integer, Integer> function, String a, String b) {
        int arabicA = CalcHelper.romanToArabic(a);
        int arabicB = CalcHelper.romanToArabic(b);
        int result = function.apply(arabicA, arabicB);
        return CalcHelper.arabicToRoman(result);
    }

    @Override
    public boolean isValidExpression(String ex) {
        return ex.matches(MATH_EXPRESSION);
    }

    @Override
    public String getFirstArg(String ex) {
        return ex.split(VALID_OPERATIONS)[0].trim();
    }

    @Override
    public String getSecondArg(String ex) {
        return ex.split(VALID_OPERATIONS)[1].trim();
    }
}
