import java.util.function.BiFunction;

public class ArabicCalculator implements Calculator<Integer> {

    private static final String MATH_EXPRESSION = "^\\d+(\\s)*" + VALID_OPERATIONS + "(\\s)*\\d+$";

    @Override
    public Integer operation(BiFunction<Integer, Integer, Integer> function, Integer a, Integer b) {
        return function.apply(a,  b);
    }

    @Override
    public boolean isValidExpression(String ex) {
        return ex.matches(MATH_EXPRESSION);
    }

    @Override
    public Integer getFirstArg(String ex) {
        return Integer.valueOf(ex.split(VALID_OPERATIONS)[0].trim());
    }

    @Override
    public Integer getSecondArg(String ex) {
        return Integer.valueOf(ex.split(VALID_OPERATIONS)[1].trim());
    }
}
