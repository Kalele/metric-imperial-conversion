package com.ayo.metricimperialconversiontest.service;

import com.ayo.metricimperialconversiontest.model.Area;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AreaService {
    public ResponseEntity<?> convertArea(String unit, Double amount) {
        return unit.equalsIgnoreCase("sqmile") ?
                convertSqMile(amount) : unit.equalsIgnoreCase("sqkilometer") ?
                convertSqKilometer(amount) : unit.equalsIgnoreCase("sqyard") ?
                convertSqYard(amount) : unit.equalsIgnoreCase("sqinch") ?
                convertSqInch(amount) : unit.equalsIgnoreCase("sqmeter") ?
                convertSqMeter(amount) : unit.equalsIgnoreCase("sqcentimeter") ?
                convertSqCentimeter(amount) : unit.equalsIgnoreCase("sqmillimeter") ?
                convertSqMillimeter(amount) : unit.equalsIgnoreCase("sqfoot") ?
                convertSqFoot(amount) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
    }

    public ResponseEntity<?> convertSqMile(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(160934.4, 2));
        areaModel.setSqFoot(amount * Math.pow(5280, 2));
        areaModel.setSqInch(amount * Math.pow(63360, 2));
        areaModel.setSqKilometer(amount * Math.pow(1.609, 2));
        areaModel.setSqMeter(amount * Math.pow(1609.344, 2));
        areaModel.setSqMile(amount);
        areaModel.setSqMillimeter(amount * Math.pow(1.609e+6, 2));
        areaModel.setSqYard(amount * Math.pow(1760, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqKilometer(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(100000, 2));
        areaModel.setSqFoot(amount * Math.pow(3280.84, 2));
        areaModel.setSqInch(amount * Math.pow(39370.079, 2));
        areaModel.setSqKilometer(amount);
        areaModel.setSqMeter(amount * Math.pow(1000, 2));
        areaModel.setSqMile(amount * Math.pow(0.62137119224, 2));
        areaModel.setSqMillimeter(amount * Math.pow(1000000, 2));
        areaModel.setSqYard(amount * Math.pow(1093.613, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqYard(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(91.44, 2));
        areaModel.setSqFoot(amount * Math.pow(3, 2));
        areaModel.setSqInch(amount * Math.pow(36, 2));
        areaModel.setSqKilometer(amount * Math.pow(0.0009144, 2));
        areaModel.setSqMeter(amount * Math.pow(0.9144, 2));
        areaModel.setSqMile(amount * Math.pow(0.00056818182, 2));
        areaModel.setSqMillimeter(amount * Math.pow(914.4, 2));
        areaModel.setSqYard(amount);
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqMeter(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(100, 2));
        areaModel.setSqFoot(amount * Math.pow(3.281, 2));
        areaModel.setSqInch(amount * Math.pow(39.37, 2));
        areaModel.setSqKilometer(amount * Math.pow(0.001, 2));
        areaModel.setSqMeter(amount);
        areaModel.setSqMile(amount * Math.pow(0.00062137119, 2));
        areaModel.setSqMillimeter(amount * Math.pow(1000, 2));
        areaModel.setSqYard(amount * Math.pow(1.094, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqFoot(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(30.48, 2));
        areaModel.setSqFoot(amount);
        areaModel.setSqInch(amount * Math.pow(12, 2));
        areaModel.setSqKilometer(amount * Math.pow(0.0003048, 2));
        areaModel.setSqMeter(amount * Math.pow(0.3048, 2));
        areaModel.setSqMile(amount * Math.pow(0.00018939394, 2));
        areaModel.setSqMillimeter(amount * Math.pow(304.8, 2));
        areaModel.setSqYard(amount * Math.pow(0.333333, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqInch(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(2.54, 2));
        areaModel.setSqFoot(amount * Math.pow(0.0833333, 2));
        areaModel.setSqInch(amount);
        areaModel.setSqKilometer(amount * Math.pow(2.54e-5, 2));
        areaModel.setSqMeter(amount * Math.pow(0.0254, 2));
        areaModel.setSqMile(amount * Math.pow(1.5782828e-5, 2));
        areaModel.setSqMillimeter(amount * Math.pow(25.4, 2));
        areaModel.setSqYard(amount * Math.pow(0.02777777778, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqCentimeter(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount);
        areaModel.setSqFoot(amount * Math.pow(0.03280839895, 2));
        areaModel.setSqInch(amount * Math.pow(0.3937007874, 2));
        areaModel.setSqKilometer(amount * Math.pow(1.0e-5, 2));
        areaModel.setSqMeter(amount * Math.pow(0.01, 2));
        areaModel.setSqMile(amount * Math.pow(6.2137119e-6, 2));
        areaModel.setSqMillimeter(amount * Math.pow(10, 2));
        areaModel.setSqYard(amount * Math.pow(0.01093613298, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> convertSqMillimeter(Double amount) {
        Area areaModel = new Area();
        areaModel.setSqCentimeter(amount * Math.pow(0.1, 2));
        areaModel.setSqFoot(amount * Math.pow(0.0032808399, 2));
        areaModel.setSqInch(amount * Math.pow(0.03937007874, 2));
        areaModel.setSqKilometer(amount * Math.pow(1e-6, 2));
        areaModel.setSqMeter(amount * Math.pow(0.001, 2));
        areaModel.setSqMile(amount * Math.pow(6.2137119e-7, 2));
        areaModel.setSqMillimeter(amount);
        areaModel.setSqYard(amount * Math.pow(0.0010936133, 2));
        return jsonResponse(areaModel);
    }

    public ResponseEntity<?> jsonResponse(Area areaModel) {
        if (areaModel.getSqMile() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
        } else {
            return new ResponseEntity<>(areaModel, HttpStatus.OK);
        }
    }
}