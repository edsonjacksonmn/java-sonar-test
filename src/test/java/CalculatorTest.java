import org.example.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(1, 0);
        });
        assertEquals("Divisor cannot be zero.", exception.getMessage());
    }

    // Problema: Testes com duplicação
    @Test
    public void testCalculateAdd() {
        assertEquals(5, calculator.calculate(2, 3, "add"));
    }

    @Test
    public void testCalculateSubtract() {
        assertEquals(1, calculator.calculate(3, 2, "subtract"));
    }

    // Problema: Duplicação de código nos testes
    @Test
    public void testCalculate() {
        String[] operations = {"add", "subtract", "multiply", "divide"};
        int[][] inputs = {{2, 3}, {3, 2}, {2, 3}, {6, 3}};
        int[] expected = {5, 1, 6, 2};

        for (int i = 0; i < operations.length; i++) {
            assertEquals(expected[i], calculator.calculate(inputs[i][0], inputs[i][1], operations[i]));
        }
    }
}
