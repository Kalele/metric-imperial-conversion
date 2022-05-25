package com.ayo.metricimperialconversiontest.service;

import com.ayo.metricimperialconversiontest.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    public ResponseEntity<?> convertTemperature(String unit, Double amount) {
        return unit.equalsIgnoreCase("fahrenheit") ?
                convertFahrenheit(amount) : unit.equalsIgnoreCase("celsius") ?
                convertCelsius(amount) : unit.equalsIgnoreCase("kelvin") ?
                convertKelvin(amount) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
    }

    public ResponseEntity<?> convertFahrenheit(Double amount) {
        Temperature temperatureModel = new Temperature();
        temperatureModel.setFahrenheit(amount);
        temperatureModel.setCelsius((amount - 32) / 1.8000);
        temperatureModel.setKelvin((amount - 32) / 1.8000 + 273.15);
        return jsonResponse(temperatureModel);
    }

    public ResponseEntity<?> convertCelsius(Double amount) {
        Temperature temperatureModel = new Temperature();
        temperatureModel.setFahrenheit(amount * 1.8000 + 32);
        temperatureModel.setCelsius(amount);
        temperatureModel.setKelvin(amount + 273.15);
        return jsonResponse(temperatureModel);
    }

    public ResponseEntity<?> convertKelvin(Double amount) {
        Temperature temperatureModel = new Temperature();
        temperatureModel.setFahrenheit((amount - 273.15) * 1.8000 + 32);
        temperatureModel.setCelsius(amount - 273.15);
        temperatureModel.setKelvin(amount);
        return jsonResponse(temperatureModel);
    }

    public ResponseEntity<?> jsonResponse(Temperature temperatureModel) {
        if (temperatureModel.getFahrenheit() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
        } else {
            return new ResponseEntity<>(temperatureModel, HttpStatus.OK);
        }
    }
}