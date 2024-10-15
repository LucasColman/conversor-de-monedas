package com.aluracursos.principal;

import com.aluracursos.modelos.ConsultaMoneda;
import com.aluracursos.modelos.Moneda;
import com.aluracursos.modelos.MonedaAPI;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        var monto = 0.0;
        String monedaBase;
        String monedaDestino;
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Moneda monedaConvertida;

        System.out.println("***************************************");
        System.out.println("Sea bienvenido al conversor de Monedas :) ");

        while (true){
            try{
                System.out.println("***************************************");
                System.out.println("Por favor, seleccione una opción: ");
                String menu = """
                1. Dólar --> Peso Argentino
                2. Peso Argentino --> Dólar
                3. Dólar --> Real brasileño
                4. Real brasileño --> Dólar
                5. Dólar --> Peso colombiano
                6. Peso colombiano --> Dólar
                7. Salir
                """;
                System.out.println(menu);
                var opcion = Integer.parseInt(lectura.nextLine());

                if (opcion == 7){
                    System.out.println("Gracias por utilizar el conversor de monedas");
                    break;
                }
                switch(opcion){
                    case 1:
                        System.out.println("Por favor, introduzca la cantidad de dinero que desea convertir: ");
                        monto = Double.parseDouble(lectura.nextLine());
                        monedaBase = "USD";
                        monedaDestino = "ARS";
                        monedaConvertida = consultaMoneda.convertir(monedaBase,monedaDestino,monto);

                        //monedaAPI = consultaMoneda.consultaMonedaApi(monedaBase,monedaDestino,monto);
                        //monedaConvertida = new Moneda(monedaAPI);

                        System.out.println("El monto " + monto + " " + monedaBase + " " + " corresponde al valor final de: " +monedaConvertida.getConversion_result() + " " + monedaDestino);
                        break;
                    case 2:
                        System.out.println("Por favor, introduzca la cantidad de dinero que desea convertir: ");
                        monto = Double.parseDouble(lectura.nextLine());
                        monedaBase = "ARS";
                        monedaDestino = "USD";
                        monedaConvertida = consultaMoneda.convertir(monedaBase,monedaDestino,monto);

                        System.out.println("El monto " + monto + " " + monedaBase + " " + " corresponde al valor final de: " +monedaConvertida.getConversion_result() + " " + monedaDestino);
                        break;
                    case 3:
                        System.out.println("Por favor, introduzca la cantidad de dinero que desea convertir: ");
                        monto = Double.parseDouble(lectura.nextLine());
                        monedaBase = "USD";
                        monedaDestino = "BRL";
                        monedaConvertida = consultaMoneda.convertir(monedaBase,monedaDestino,monto);

                        System.out.println("El monto " + monto + " " + monedaBase + " " + " corresponde al valor final de: " +monedaConvertida.getConversion_result() + " " + monedaDestino);
                        break;
                    case 4:
                        System.out.println("Por favor, introduzca la cantidad de dinero que desea convertir: ");
                        monto = Double.parseDouble(lectura.nextLine());
                        monedaBase = "BRL";
                        monedaDestino = "USD";
                        monedaConvertida = consultaMoneda.convertir(monedaBase,monedaDestino,monto);

                        System.out.println("El monto " + monto + " " + monedaBase + " " + " corresponde al valor final de: " + monedaConvertida.getConversion_result() + " " + monedaDestino);
                        break;

                    case 5:
                        System.out.println("Por favor, introduzca la cantidad de dinero que desea convertir: ");
                        monto = Double.parseDouble(lectura.nextLine());
                        monedaBase = "USD";
                        monedaDestino = "COP";
                        monedaConvertida = consultaMoneda.convertir(monedaBase,monedaDestino,monto);

                        System.out.println("El monto " + monto + " " + monedaBase + " " + " corresponde al valor final de: " + monedaConvertida.getConversion_result() + " " + monedaDestino);
                        break;

                    case 6:
                        System.out.println("Por favor, introduzca la cantidad de dinero que desea convertir: ");
                        monto = Double.parseDouble(lectura.nextLine());
                        monedaBase = "COP";
                        monedaDestino = "USD";
                        monedaConvertida = consultaMoneda.convertir(monedaBase,monedaDestino,monto);;

                        System.out.println("El monto " + monto + " " + monedaBase + " " + " corresponde al valor final de: " + monedaConvertida.getConversion_result() + " " + monedaDestino);
                        break;

                    case 7:
                        System.out.println("Gracias por utilizar el conversor de monedas");
                        break;
                    default:
                        System.out.println("Por favor, seleccione una opción válida");
                        break;

                }
            }catch (RuntimeException e){
                System.out.println("Error: " + e.getMessage());
            }

        }
    }
}
