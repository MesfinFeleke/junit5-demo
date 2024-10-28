package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

   Calculator calculator;
    // BeforeAll is new in JUnit 5 (equivalent to @BeforeClass in JUnit 4)
    @BeforeAll
    static void setupAll() {
        System.out.println("@BeforeAll - Run once before all tests");
    }
    // BeforeEach replaces JUnit 4's @Before (runs before each test)
    @BeforeEach
    void setup() {

        calculator = new Calculator();
        System.out.println("@BeforeEach - Set up Calculator instance before each test");
    }

    // @Test annotation is the same in both JUnit 4 and JUnit 5
    @Test
    void testAddition() {
        MathsOperation add = Integer::sum;

       int result = calculator.doMath(3,7, add);
      //  int result = calculator.add(2, 3);
        assertEquals(5, result);
        System.out.println("@Test - Testing add() method");
    }

    // This is an example of multiple assertions and assertThrows
    @Test
    void testDivision() {
        MathsOperation divide = (a, b) -> a / b;
        assertAll("Testing divide() method",
                () -> assertEquals(2, calculator.doMath(4,2, divide)),
                () -> assertThrows(ArithmeticException.class, () -> calculator.doMath(4,2, divide))
        );
        System.out.println("@Test - Testing divide() method");
    }

    // Disable test in JUnit 5 (equivalent to @Ignore in JUnit 4)
    @Disabled("Disabled until bug #123 is fixed")
    @Test
    void testSubtraction() {
        MathsOperation subtract = (a, b) -> a - b;
        int result = calculator.doMath(4,2, subtract);
        assertEquals(2, result);
        System.out.println("@Test - Testing subtract() method");
    }

    // AfterEach replaces JUnit 4's @After (runs after each test)
    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach - Clean up after each test");
    }

    // AfterAll is new in JUnit 5 (equivalent to @AfterClass in JUnit 4)
    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll - Run once after all tests");
    }

    // Example of @RepeatedTest, new in JUnit 5
    @RepeatedTest(3)
    void repeatedTest(RepetitionInfo repetitionInfo) {
        MathsOperation add = Integer::sum;
        System.out.println("@RepeatedTest - repetition " + repetitionInfo.getCurrentRepetition());
        assertTrue(calculator.doMath(3,7, add) == 10);
    }

    // Example of a test with a timeout (JUnit 5 style)
    @Test
    @Timeout(2)  // Timeout in seconds (similar to JUnit 4's @Test(timeout = 2000))
    void testWithTimeout() throws InterruptedException {
        MathsOperation add = Integer::sum;
        Thread.sleep(1000);  // Simulate some work
        assertTrue(calculator.doMath(3,7, add) == 9);
    }


  // Parameterized test, new in JUnit 5
  //@ParameterizedTest
 // @ValueSource(ints = {1, 2, 3, 4, 5})  // Pass different values to the test
    void parameterizedTest(int number) {
        MathsOperation add = Integer::sum;
        assertTrue(calculator.doMath(number,0, add) == number);
        System.out.println("@ParameterizedTest - Testing with value: " + number);
    }


}
