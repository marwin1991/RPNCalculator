package pl.zmilczak.rpn_calculator;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RPNCalculatorTest {

    @Test
    public void ShouldReturnGoodResultForSimpleInput(){
        assertThat(evaluate("2 3 +"), is(5));
        assertThat(evaluate("2 3 -"), is(-1));
        assertThat(evaluate("2 3 *"), is(6));
    }

    @Test
    public void ShouldReturnGoodResultForInputWithMultipleOperations(){
        assertThat(evaluate("2 3 +"), is(5));
        assertThat(evaluate("-2 -3 *"), is(6));
        assertThat(evaluate("3 4 5 * -"), is( -17));

        assertThat(evaluate("5 3 + 2 1 * -"), is(6));
        assertThat(evaluate("5 3 + 2 1 * 2 6 + * - 5 -"), is(-13));
        assertThat(evaluate("5 3 + 2 1 * 2 6 + * - 5 - -1 - -5 -1 -2 - * +"), is(-17));
    }


    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgExWhenInputHaveNotEnoughOperators(){
        evaluate("5 3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgExWhenInputHaveNotEnoughOperators2(){
        evaluate("5 3 + 3 -3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgExWhenInputContainsNotDefinedOperation(){
        evaluate("5 3 ^");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowIllegalArgExWhenInputContainsNumberThatCannotBeParsedToInteger(){
        evaluate("5 3- +");
    }


    private Integer evaluate(String input){
        return evaluate(input.split(" "));
    }


    private Integer evaluate(String... strings){
        return new RPNCalculator(Arrays.asList(strings)).calculate();
    }
}
