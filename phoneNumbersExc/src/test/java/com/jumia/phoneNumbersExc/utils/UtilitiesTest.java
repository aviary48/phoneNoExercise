package com.jumia.phoneNumbersExc.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UtilitiesTest {

    @Mock
    private  Utilities underTest;

    Utilities mock = org.mockito.Mockito.mock(Utilities.class);


    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        underTest = new Utilities();

    }

    @ParameterizedTest
    @CsvSource({"(251) 911203317,ETHIOPIA","(237) 6A0311634, CAMEROON","(212) 691933626,MOROCCO" })
    void itShouldReturnCountry(String phone, String expected ) {

        String country  = underTest.getCountryNameByCountryCode(phone);
        assertThat(country).matches(expected);
        //validprefix
         assertTrue(phone.startsWith("("));

    }

    @ParameterizedTest
    @CsvSource({"23333, Phone Number Is Empty" })
    void shouldThrowAnExceptionForPhoneNumbersWithWrongPrefix(String phone, String expected){
        assertThat(catchThrowable(() -> { throw new Exception("Phone Number Is Empty"); })).as(expected)
                .isInstanceOf(Exception.class)
                .hasMessageContaining(expected);
    }



    @Test
    void itShouldNotReturnCountryWhenPhoneNumberIsInvalid(){
        String phone = null;

        assertThatThrownBy(() -> underTest.getCountryNameByCountryCode(phone))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Phone Number Is Empty");
    }

    @ParameterizedTest
    @CsvSource({"23333, Invalid Country" })
    void itShouldNotReturnCountryCodeWhenPhoneNumberIsInvalid(String phone){

        assertThatThrownBy(() -> underTest.sanitizePhoneNumber(phone))
                .isInstanceOf(IllegalArgumentException.class);
    }


}