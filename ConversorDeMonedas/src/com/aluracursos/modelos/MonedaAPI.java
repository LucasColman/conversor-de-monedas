package com.aluracursos.modelos;



import java.util.HashMap;
import java.util.List;


    public record MonedaAPI(String base_code, HashMap<String,Double> conversion_rates) {

}