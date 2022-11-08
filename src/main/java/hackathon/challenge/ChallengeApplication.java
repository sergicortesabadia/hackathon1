package hackathon.challenge;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hackathon.challenge.models.Company;
import hackathon.challenge.repositories.CompanyRepository;
import hackathon.challenge.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class ChallengeApplication {
	@Autowired
	CompanyRepository companyRepository;
	@Autowired
	CompanyService companyService;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}



	@Bean
	CommandLineRunner runner(CompanyService companyService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Company>> typeReference = new TypeReference<List<Company>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/companies.json");
			try {
				List<Company> companies = mapper.readValue(inputStream,typeReference);
				companyService.saveCompanies(companies);
				System.out.println("Companies Saved!");
			} catch (IOException e){
				System.out.println("Unable to save companies: " + e.getMessage());
			}
		};
	}

}
