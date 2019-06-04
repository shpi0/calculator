import java.util.function.BiFunction;

public interface Calculator<T> {

    String VALID_OPERATIONS = "[\\+\\*/-]";

    T operation(BiFunction<Integer, Integer, Integer> function, T a, T b);

    boolean isValidExpression(String ex);

    T getFirstArg(String ex);

    T getSecondArg(String ex);

}
