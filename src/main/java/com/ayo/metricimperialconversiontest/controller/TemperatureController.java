package com.ayo.metricimperialconversiontest.controller;

import com.ayo.metricimperialconversiontest.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TemperatureController {
   // @Autowired
    TemperatureService temperatureService = new TemperatureService();

    @GetMapping(value = "/api/temperature/{unit}/{amount}")
    public ResponseEntity<?> customTemperature(@PathVariable String unit,
                                               @PathVariable Double amount) {
        return temperatureService.convertTemperature(unit, amount);
    }
}