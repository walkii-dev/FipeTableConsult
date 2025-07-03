package com.exerciting.FipeTableConsult.main;

import com.exerciting.FipeTableConsult.models.MarcasData;
import com.exerciting.FipeTableConsult.service.BringApiData;
import com.exerciting.FipeTableConsult.service.ConvertData;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);
    private BringApiData bring = new BringApiData();
    private ConvertData conversor = new ConvertData();
    private final String API_ADRESS = "https://parallelum.com.br/fipe/api/v1/";

    public void mainMenu(){
        System.out.println("Você está procurando por preços de CARROS, MOTOS ou CAMINHOES?");
        var option = input.nextLine();  //poderia fazer um validador de opção

        String json = bring.getData(API_ADRESS+option+"/marcas/"); //59/modelos/5940/anos/2014-3
        System.out.println(json);

        var labelsData = conversor.convertToList(json, MarcasData.class);
        System.out.println(labelsData);





    }
}
