package com.example.sapani

import org.junit.Test

import org.junit.Assert.*

class MainActivityTest {

    @Test
    fun onCreate() {
        var wunde1:Double = 20.0;
        var wunde2:Double = 10.0;
        var output:Double;
        var expected:Double = 50.0;
        var delta:Double = 0.1;

        var rechner = Rechner(ersteWunde = wunde1, zweiteWunde = wunde2)
        output = rechner.prozent();

        assertEquals(expected, output, delta);


    }
}