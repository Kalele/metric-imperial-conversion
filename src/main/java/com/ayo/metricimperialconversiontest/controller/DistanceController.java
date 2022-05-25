package com.ayo.metricimperialconversiontest.controller;

import com.ayo.metricimperialconversiontest.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DistanceController {
    @Autowired
    DistanceService distanceService;

    @GetMapping(value = "/api/distance/{unit}/{amount}")
    public ResponseEntity<?> customLength(@PathVariable String unit,
                                          @PathVariable Double amount) {
        return distanceService.convertDistance(unit, amount);
    }
}
