package by.teachmeskills.lesson26.service;

import org.junit.jupiter.api.Test;

public class ParameterValidatorTest {
    @Test
    public void testParameters() {
        ParameterValidator parameterValidator1 = new ParameterValidator();
        assert (ParameterValidator.parameters("Bob", "25","male","higher"));

        ParameterValidator parameterValidator2 = new ParameterValidator();
        assert (ParameterValidator.parameters("Ban", "24","male","higher"));

        ParameterValidator parameterValidator3 = new ParameterValidator();
        assert (ParameterValidator.parameters("Any", "25","female","higher"));
    }
}
