package com.jumia.phoneNumbersExc.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


class PhoneNumberValidatorTest {

    private  PhoneNumberValidator underTest;


    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }

    @ParameterizedTest
    @CsvSource({"(251) 911203317,valid","(237) 6A0311634, invalid","(212) 691933626,valid"})
    void itShouldValidatePhoneNumber(String phone, String expected ) {

        //When
        String  isValid = underTest.validatePhoneNumber(phone);

        //Then
        assertThat(isValid).matches(expected);
    }
}
