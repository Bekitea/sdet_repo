package lesson_3;

public class GenericClass<T extends Number>
        implements IGenericInterface<T> {
    private final T firstNumber;
    private final T secondNumber;

    public GenericClass(T firstNumber, T secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public T getMax() {
        return firstNumber.doubleValue() > secondNumber.doubleValue()
                ? firstNumber
                : secondNumber;
    }
}
