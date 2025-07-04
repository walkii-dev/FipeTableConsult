package com.exerciting.FipeTableConsult.main;

import com.exerciting.FipeTableConsult.models.IdentifyData;
import com.exerciting.FipeTableConsult.models.ModelsData;
import com.exerciting.FipeTableConsult.models.Veichle;
import com.exerciting.FipeTableConsult.service.BringApiData;
import com.exerciting.FipeTableConsult.service.ConvertData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private Scanner input = new Scanner(System.in);
    private BringApiData bring = new BringApiData();
    private ConvertData conversor = new ConvertData();
    private final String API_ADRESS = "https://parallelum.com.br/fipe/api/v1/";

    public void mainMenu(){

        System.out.println("Você está procurando por preços de CARROS, MOTOS ou CAMINHOES?");
        var option = input.nextLine().toUpperCase();
            if(option.contains("MOT")){
                option = "motos";
            }
            if(option.contains("CARR")){
                option = "carros";
            }
            if(option.contains("CAMINH")){
                option = "caminhoes";
            }

        String json = bring.getData(API_ADRESS+ option +"/marcas/"); //59/modelos/5940/anos/2014-3
        //System.out.println(json);

        List<IdentifyData> labelsData = conversor.convertToList(json, IdentifyData.class);
        //System.out.println(labelsData);

        labelsData.stream().forEach(e-> System.out.println("Cód.: "+e.id()+" | Marca: "+e.marca()));

        System.out.println("\nDigite o Código da Marca que você deseja: ");
        var option2 = input.nextLine();

        json = bring.getData(API_ADRESS+option+"/marcas/"+option2+"/modelos");
//        System.out.println(json);

        var modelsData = conversor.converter(json, ModelsData.class);
        modelsData.modelos().stream().sorted(Comparator.comparing(IdentifyData::id))
                .forEach(e-> System.out.println("Cód.: "+e.id()+" | Marca: "+e.marca()));


        System.out.println("\nDigite o Nome do Modelo que você deseja: ");
        var option3 = input.nextLine();

        List<IdentifyData> filtredModels = modelsData.modelos().stream()
                .filter(m -> m.marca().toLowerCase().contains(option3))
                .collect(Collectors.toList());

        filtredModels.forEach(e-> System.out.println("Cód.: "+e.id()+" | Marca: "+e.marca()));

        System.out.println("\nDos modelos filtrados, digite o código do desejado");
        var option4 = input.nextLine();

        json = bring.getData(API_ADRESS+option+"/marcas/"+option2+"/modelos/"+option4+"/anos");

        List<IdentifyData> years = conversor.convertToList(json, IdentifyData.class);
        List<Veichle> veichlesList = new ArrayList<>();

        for (int i = 0; i < years.size(); i++) {
            var jsonAlt = bring.getData(API_ADRESS+option+"/marcas/"+option2+"/modelos/"+option4+"/anos/"+years.get(i).id());
            Veichle veichle = conversor.converter(jsonAlt, Veichle.class);
            veichlesList.add(veichle);
        }

        System.out.println("Veiculos Avaliados por ano:");
        veichlesList.forEach(System.out::println);



    }
}
