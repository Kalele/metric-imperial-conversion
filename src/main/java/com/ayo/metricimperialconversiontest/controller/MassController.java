package com.ayo.metricimperialconversiontest.controller;

import com.ayo.metricimperialconversiontest.service.MassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MassController {
    @Autowired
    MassService massService;

    @GetMapping(value = "/api/mass/{unit}/{amount}")
    public ResponseEntity<?> customWeight(@PathVariable String unit,
                                          @PathVariable Double amount) {
        return massService.convertMass(unit, amount);
    }
}