package com.ayo.metricimperialconversiontest;

import com.ayo.metricimperialconversiontest.controller.TemperatureController;
import com.ayo.metricimperialconversiontest.model.Temperature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TemperatureControllerTest {
    TemperatureController temperatureController = new TemperatureController();

    @Test
    public void testFahrenheit() {
        ResponseEntity<Temperature> tempObj = (ResponseEntity<Temperature>) temperatureController.customTemperature("fahrenheit", 100.0);
        assertEquals(tempObj.getBody().getFahrenheit(), 100.0);
        assertEquals(tempObj.getBody().getCelsius(), -279.67);
        assertEquals(tempObj.getBody().getKelvin(), 310.93);
    }

    @Test
    public void testCelsius() {
        ResponseEntity<Temperature> tempObj = (ResponseEntity<Temperature>) temperatureController.customTemperature("celsius", 100.0);
        assertEquals(tempObj.getBody().getFahrenheit(), 212);
        assertEquals(tempObj.getBody().getCelsius(), 100.0);
        assertEquals(tempObj.getBody().getKelvin(), 373.15);
    }

    @Test
    public void testKelvin() {
        ResponseEntity<Temperature> tempObj = (ResponseEntity<Temperature>) temperatureController.customTemperature("kelvin", 100.0);
        assertEquals(tempObj.getBody().getFahrenheit(), -279.67);
        assertEquals(tempObj.getBody().getCelsius(), -173.15);
        assertEquals(tempObj.getBody().getKelvin(), 100.0);
    }
}