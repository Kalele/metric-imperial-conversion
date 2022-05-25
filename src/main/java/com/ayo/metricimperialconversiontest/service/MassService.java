package com.ayo.metricimperialconversiontest.service;

import com.ayo.metricimperialconversiontest.model.Mass;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MassService {

    public ResponseEntity<?> convertMass(String unit, Double amount) {
        return unit.equalsIgnoreCase("stone") ?
                convertStone(amount) : unit.equalsIgnoreCase("pound") ?
                convertPound(amount) : unit.equalsIgnoreCase("kilogram") ?
                convertKilogram(amount) : unit.equalsIgnoreCase("gram") ?
                convertGram(amount) : unit.equalsIgnoreCase("milligram") ?
                convertMilligram(amount) : unit.equalsIgnoreCase("ounce") ?
                convertOunce(amount) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
    }

    public ResponseEntity<?> convertStone(Double amount) {
        Mass massModel = new Mass();
        massModel.setStone(amount);
        massModel.setPound(amount * 14);
        massModel.setKilogram(amount * 6.35029318);
        massModel.setGram(amount * 6350.29318);
        massModel.setMilligram(amount * 6350293.18);
        massModel.setOunce(amount * 224);
        return jsonResponse(massModel);
    }

    public ResponseEntity<?> convertPound(Double amount) {
        Mass massModel = new Mass();
        massModel.setStone(amount * 0.07142857143);
        massModel.setPound(amount);
        massModel.setKilogram(amount * 0.45359237);
        massModel.setGram(amount * 453.59237);
        massModel.setMilligram(amount * 453592.37);
        massModel.setOunce(amount * 16);
        return jsonResponse(massModel);
    }

    public ResponseEntity<?> convertKilogram(Double amount) {
        Mass massModel = new Mass();
        massModel.setStone(amount * 0.15747304442);
        massModel.setPound(amount * 2.20462262);
        massModel.setKilogram(amount);
        massModel.setGram(amount * 1000);
        massModel.setMilligram(amount * 1000000);
        massModel.setOunce(amount * 35.2739619);
        return jsonResponse(massModel);
    }

    public ResponseEntity<?> convertGram(Double amount) {
        Mass massModel = new Mass();
        massModel.setStone(amount * 0.00015747304);
        massModel.setPound(amount * 0.00220462262);
        massModel.setKilogram(amount * 0.001);
        massModel.setGram(amount);
        massModel.setMilligram(amount * 1000);
        massModel.setOunce(amount * 0.03527396195);
        return jsonResponse(massModel);
    }

    public ResponseEntity<?> convertMilligram(Double amount) {
        Mass massModel = new Mass();
        massModel.setStone(amount * 1.5747304e-7);
        massModel.setPound(amount * 2.2046226e-6);
        massModel.setKilogram(amount * 1e-6);
        massModel.setGram(amount * 0.001);
        massModel.setMilligram(amount);
        massModel.setOunce(amount * 3.5273962e-5);
        return jsonResponse(massModel);
    }

    public ResponseEntity<?> convertOunce(Double amount) {
        Mass massModel = new Mass();
        massModel.setStone(amount * 0.00446428571);
        massModel.setPound(amount * 0.0625);
        massModel.setKilogram(amount * 0.02834952313);
        massModel.setGram(amount * 28.3495231);
        massModel.setMilligram(amount * 28349.5231);
        massModel.setOunce(amount);
        return jsonResponse(massModel);
    }

    public ResponseEntity<?> jsonResponse(Mass massModel) {
        if (massModel.getStone() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
        } else {
            return new ResponseEntity<>(massModel, HttpStatus.OK);
        }
    }
}