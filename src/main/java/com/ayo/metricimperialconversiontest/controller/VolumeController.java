package com.ayo.metricimperialconversiontest.controller;

import com.ayo.metricimperialconversiontest.service.VolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VolumeController {
    @Autowired
    VolumeService volumeService;

    @GetMapping(value = "/api/volume/{unit}/{amount}")
    public ResponseEntity<?> customVolume(@PathVariable String unit,
                                          @PathVariable Double amount) {
        return volumeService.convertVolume(unit, amount);
    }
}