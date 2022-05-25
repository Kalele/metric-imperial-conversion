package com.ayo.metricimperialconversiontest.controller;

import com.ayo.metricimperialconversiontest.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AreaController {
    @Autowired
    AreaService areaService;

    @GetMapping(value = "/api/area/{unit}/{amount}")
    public ResponseEntity<?> customLength(@PathVariable String unit,
                                          @PathVariable Double amount) {
        return areaService.convertArea(unit, amount);
    }
}