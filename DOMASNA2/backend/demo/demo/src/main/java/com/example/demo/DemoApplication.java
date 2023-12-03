package com.example.demo;

import com.example.demo.model.Winery;
import com.example.demo.service.WineryService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.AssertTrue;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}



	@Bean
	CommandLineRunner runner(WineryService wineryService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Winery>> typeReference = new TypeReference<List<Winery>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/winery_data.json");
			try {
				List<Winery> users = mapper.readValue(inputStream,typeReference);
				wineryService.save(users);
				System.out.println("Winery Saved!");
			} catch (IOException e){
				System.out.println("Unable to save wineries: " + e.getMessage());
			}
		};
	}

}
