package com.aluracursos.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Moneda {
    private String base_code;
    private HashMap<String,Double> conversion_rates;
    private double valorMonedaDestino;
    private String conversion_result;

    public Moneda(String base_code) {
        this.base_code = base_code;
        this.conversion_rates = new HashMap<>();
    }

    public Moneda(MonedaAPI monedaAPI) {
        this.base_code = monedaAPI.base_code();
        this.conversion_rates =  monedaAPI.conversion_rates();
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public HashMap<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(HashMap<String, Double> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    public String getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(String conversion_result) {
        this.conversion_result = conversion_result;
    }

    public double getValorMonedaDestino() {
        return valorMonedaDestino;
    }

    public void setValorMonedaDestino(double valorMonedaDestino) {
        this.valorMonedaDestino = valorMonedaDestino;
    }
}
