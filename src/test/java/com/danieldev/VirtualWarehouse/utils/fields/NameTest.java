package com.danieldev.VirtualWarehouse.utils.fields;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void nameConstructorShouldReturnIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class,
                () -> new Name(null)
                );
    }

}