package day01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {
    @Test
    void testConstructorWithList() {
        List<Integer> numbersList= Arrays.asList(0,2,4,6,8,10,12);
        NumberSequence numberSequence=new NumberSequence(numbersList);
        assertEquals(6, numberSequence.closeToAverage(1).get(0));
    }
    @Test
    void testConstructorWithThreeParameters() {
        NumberSequence numberSequence=new NumberSequence(20,100,200);
        System.out.println("Original: "+numberSequence.getNumbersList());
        System.out.println("Close to average:"+numberSequence.closeToAverage(10));
        System.out.println("Average: "+numberSequence.getAverage()+"+-10");

    }



}