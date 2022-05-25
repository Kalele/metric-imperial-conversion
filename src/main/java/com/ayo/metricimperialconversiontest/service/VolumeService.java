package com.ayo.metricimperialconversiontest.service;

import com.ayo.metricimperialconversiontest.model.Volume;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VolumeService {

    public ResponseEntity<?> convertVolume(String unit, Double amount) {
        return unit.equalsIgnoreCase("gallon") ?
                convertGallon(amount) : unit.equalsIgnoreCase("liter") ?
                convertLiter(amount) : unit.equalsIgnoreCase("quart") ?
                convertQuart(amount) : unit.equalsIgnoreCase("pint") ?
                convertPint(amount) : unit.equalsIgnoreCase("cup") ?
                convertCup(amount) : unit.equalsIgnoreCase("milliliter") ?
                convertMilliliter(amount) : unit.equalsIgnoreCase("fluidOunce") ?
                convertFluidOunce(amount) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
    }

    public ResponseEntity<?> convertGallon(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount);
        volumeModel.setLiter(amount * 3.78541178);
        volumeModel.setQuart(amount * 4);
        volumeModel.setPint(amount * 7.99999954);
        volumeModel.setCup(amount * 16.004715);
        volumeModel.setMilliliter(amount * 3785.41178);
        volumeModel.setFluidOunce(amount * 128.000128);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> convertLiter(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount * 0.26417205236);
        volumeModel.setLiter(amount);
        volumeModel.setQuart(amount * 1.05668821);
        volumeModel.setPint(amount * 2.1133763);
        volumeModel.setCup(amount * 4.2279984);
        volumeModel.setMilliliter(amount * 1000);
        volumeModel.setFluidOunce(amount * 33.8140565);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> convertQuart(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount * 0.25);
        volumeModel.setLiter(amount * 0.946352946);
        volumeModel.setQuart(amount);
        volumeModel.setPint(amount * 1.99999989);
        volumeModel.setCup(amount * 4.00117874);
        volumeModel.setMilliliter(amount * 946.352946);
        volumeModel.setFluidOunce(amount * 32.000032);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> convertPint(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount * 0.12500000713);
        volumeModel.setLiter(amount * 0.4731765);
        volumeModel.setQuart(amount * 0.50000002853);
        volumeModel.setPint(amount);
        volumeModel.setCup(amount * 2.00058948);
        volumeModel.setMilliliter(amount * 473.1765);
        volumeModel.setFluidOunce(amount * 16.0000169);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> convertCup(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount * 0.0624815876);
        volumeModel.setLiter(amount * 0.236518538);
        volumeModel.setQuart(amount * 0.24992635042);
        volumeModel.setPint(amount * 0.49985267231);
        volumeModel.setCup(amount);
        volumeModel.setMilliliter(amount * 236.518538);
        volumeModel.setFluidOunce(amount * 7.99765121);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> convertMilliliter(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount * 0.00026417205);
        volumeModel.setLiter(amount * 0.001);
        volumeModel.setQuart(amount * 0.00105668821);
        volumeModel.setPint(amount * 0.0021133763);
        volumeModel.setCup(amount * 0.0042279984);
        volumeModel.setMilliliter(amount);
        volumeModel.setFluidOunce(amount * 0.0338140565);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> convertFluidOunce(Double amount) {
        Volume volumeModel = new Volume();
        volumeModel.setGallon(amount * 0.00781249219);
        volumeModel.setLiter(amount * 0.0295735);
        volumeModel.setQuart(amount * 0.03124996876);
        volumeModel.setPint(amount * 0.06249993396);
        volumeModel.setCup(amount * 0.12503671065);
        volumeModel.setMilliliter(amount * 29.5735);
        volumeModel.setFluidOunce(amount);
        return jsonResponse(volumeModel);
    }

    public ResponseEntity<?> jsonResponse(Volume volumeModel) {
        if (volumeModel.getGallon() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There was a problem getting the resource.");
        } else {
            return new ResponseEntity<>(volumeModel, HttpStatus.OK);
        }
    }
}