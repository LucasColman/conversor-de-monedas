package com.aluracursos.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    //convertir
    public Moneda convertir(String base_code, String target_code, double monto) {

        String direccion = "https://v6.exchangerate-api.com/v6/7febace5530b7c9e4fddede8/latest/" + base_code;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        Gson gson = new GsonBuilder() // Crea un objeto Gson
                .setPrettyPrinting() // Hace que el json sea mas legible
                .create();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());


            String json = response.body();

            MonedaAPI monedaAPI = gson.fromJson(json, MonedaAPI.class); // Deserializa el json a un objeto de la clase MonedaAPI
            Moneda moneda = new Moneda(monedaAPI);


            if (moneda.getConversion_rates().containsKey(target_code)) {
                double conversion_rate = moneda.getConversion_rates().get(target_code);
                double conversion_result = monto * conversion_rate;
                moneda.setValorMonedaDestino(conversion_rate);
                moneda.setConversion_result(String.valueOf(conversion_result));

            } else {
                throw new RuntimeException("La clave " + target_code + " no existe en las tasas de conversión.");
            }

            return moneda;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public MonedaAPI consultaMonedaApi(String monedaBase, String monedaDestino, double monto) {
//
//        String direccion = "https://v6.exchangerate-api.com/v6/7febace5530b7c9e4fddede8/pair/"+monedaBase+"/"+monedaDestino + "/" + monto;
//
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(direccion))
//                .build();
//
//
//        Gson gson = new GsonBuilder()
//                .setPrettyPrinting()
//                .create();
//
//        try{
//            HttpResponse<String> response = client
//                    .send(request,HttpResponse.BodyHandlers.ofString());
//
//            return gson.fromJson(response.body(), MonedaAPI.class);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//
//    }


}
