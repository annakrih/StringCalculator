package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
    
    //Liður 1
    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
    }
    
    @Test
    public void testOneNumber() {
        assertEquals(1, Calculator.add("1"));
    }
    
    @Test
    public void testTwoNumbers() {
        assertEquals(3, Calculator.add("1,2"));
    }
    
    //Liður 2
    @Test
    public void testMultipleNumbers() {
        assertEquals(6, Calculator.add("1,2,3"));
    }
    
    //Liður 3
    @Test
    public void testNewLineAsSeperator() {
        assertEquals(4, Calculator.add("1\n3"));
    }
    
    @Test
    public void testNewLineThenCommaSeperator() {
        assertEquals(6, Calculator.add("1,2\n3"));
    }
    
    @Test
    public void testCommaThenNewLineSeperator() {
        assertEquals(6, Calculator.add("1\n2,3"));
    }
    
    //Liður 4
    @Test (expected = IllegalArgumentException.class)
    public void testNegNumWithComma() {
        assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testNegNumWithNewLine() {
        assertEquals("Negatives not allowed: -1", Calculator.add("-1\n2"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMultipleNegNums() {
        assertEquals("Negatives not allowed: -4,-5", Calculator.add("2,-4,3,-5"));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testMultipleNegNumsWithCommaAndNewLine() {
        assertEquals("Negatives not allowed: -4,-5", Calculator.add("2,-4\n3,-5"));
    }

    //Liður 5
    @Test
    public void testIgnoreBigNumbers() {
        assertEquals(2, Calculator.add("1001,2"));
    }
    
    @Test
    public void testIgnoreBigNumbers2() {
        assertEquals(1002, Calculator.add("1000,2"));
    }
    
    //Liður 6
    @Test
    public void testOneCharacterCustomDeliminator() {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
    
    @Test
    public void testTwoCharacterCustomDeliminator() {
        assertEquals(6, Calculator.add("//ab\n1ab2ab3"));
    }
}



