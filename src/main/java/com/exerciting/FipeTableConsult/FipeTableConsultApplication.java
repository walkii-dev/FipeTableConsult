package com.exerciting.FipeTableConsult;

import com.exerciting.FipeTableConsult.service.BringApiData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeTableConsultApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeTableConsultApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		BringApiData bring = new BringApiData();
		System.out.println(bring.getData("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/2014-3"));
	}
}
