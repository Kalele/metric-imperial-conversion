package com.ayo.metricimperialconversiontest.service;

import com.ayo.metricimperialconversiontest.model.Distance;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    public ResponseEntity<?> convertDistance(String unit, Double amount) {
        return unit.equalsIgnoreCase("mile") ?
                convertMile(amount) : unit.equalsIgnoreCase("kilometer") ?
                convertKilometer(amount) : unit.equalsIgnoreCase("yard") ?
                convertYard(amount) : unit.equalsIgnoreCase("inch") ?
                convertInch(amount) : unit.equalsIgnoreCase("meter") ?
                convertMeter(amount) : unit.equalsIgnoreCase("centimeter") ?
                convertCentimeter(amount) : unit.equalsIgnoreCase("millimeter") ?
                convertMillimeter(amount) : unit.equalsIgnoreCase("foot") ?
                convertFoot(amount) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
    }

    public ResponseEntity<?> jsonResponse(Distance distanceModel) {
        if (distanceModel.getMile() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
        } else {
            return new ResponseEntity<>(distanceModel, HttpStatus.OK);
        }
    }

    public ResponseEntity<?> convertMile(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 160934.4);
        distanceModel.setFoot(amount * 5280);
        distanceModel.setInch(amount * 63360);
        distanceModel.setKilometer(amount * 1.609);
        distanceModel.setMeter(amount * 1609.344);
        distanceModel.setMile(amount);
        distanceModel.setMillimeter(amount * 1.609e+6);
        distanceModel.setYard(amount * 1760);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertKilometer(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 100000);
        distanceModel.setFoot(amount * 3280.84);
        distanceModel.setInch(amount * 39370.079);
        distanceModel.setKilometer(amount);
        distanceModel.setMeter(amount * 1000);
        distanceModel.setMile(amount * 0.62137119224);
        distanceModel.setMillimeter(amount * 1000000);
        distanceModel.setYard(amount * 1093.613);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertYard(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 91.44);
        distanceModel.setFoot(amount * 3);
        distanceModel.setInch(amount * 36);
        distanceModel.setKilometer(amount * 0.0009144);
        distanceModel.setMeter(amount * 0.9144);
        distanceModel.setMile(amount * 0.00056818182);
        distanceModel.setMillimeter(amount * 914.4);
        distanceModel.setYard(amount);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertMeter(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 100);
        distanceModel.setFoot(amount * 3.281);
        distanceModel.setInch(amount * 39.37);
        distanceModel.setKilometer(amount * 0.001);
        distanceModel.setMeter(amount);
        distanceModel.setMile(amount * 0.00062137119);
        distanceModel.setMillimeter(amount * 1000);
        distanceModel.setYard(amount * 1.094);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertFoot(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 30.48);
        distanceModel.setFoot(amount);
        distanceModel.setInch(amount * 12);
        distanceModel.setKilometer(amount * 0.0003048);
        distanceModel.setMeter(amount * 0.3048);
        distanceModel.setMile(amount * 0.00018939394);
        distanceModel.setMillimeter(amount * 304.8);
        distanceModel.setYard(amount * 0.333333);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertInch(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 2.54);
        distanceModel.setFoot(amount * 0.0833333);
        distanceModel.setInch(amount);
        distanceModel.setKilometer(amount * 2.54e-5);
        distanceModel.setMeter(amount * 0.0254);
        distanceModel.setMile(amount * 1.5782828e-5);
        distanceModel.setMillimeter(amount * 25.4);
        distanceModel.setYard(amount * 0.02777777778);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertCentimeter(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount);
        distanceModel.setFoot(amount * 0.03280839895);
        distanceModel.setInch(amount * 0.3937007874);
        distanceModel.setKilometer(amount * 1.0e-5);
        distanceModel.setMeter(amount * 0.01);
        distanceModel.setMile(amount * 6.2137119e-6);
        distanceModel.setMillimeter(amount * 10);
        distanceModel.setYard(amount * 0.01093613298);
        return jsonResponse(distanceModel);
    }

    public ResponseEntity<?> convertMillimeter(Double amount) {
        Distance distanceModel = new Distance();
        distanceModel.setCentimeter(amount * 0.1);
        distanceModel.setFoot(amount * 0.0032808399);
        distanceModel.setInch(amount * 0.03937007874);
        distanceModel.setKilometer(amount * 1e-6);
        distanceModel.setMeter(amount * 0.001);
        distanceModel.setMile(amount * 6.2137119e-7);
        distanceModel.setMillimeter(amount);
        distanceModel.setYard(amount * 0.0010936133);
        return jsonResponse(distanceModel);
    }
}