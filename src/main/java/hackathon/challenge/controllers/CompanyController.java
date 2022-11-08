package hackathon.challenge.controllers;

import hackathon.challenge.controllers.interfaces.CompanyControllerInterface;
import hackathon.challenge.models.Company;
import hackathon.challenge.services.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController implements CompanyControllerInterface {
    @Autowired
    CompanyServiceInterface companyServiceInterface;

    @GetMapping("/show_by_size")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> showCompaniesBySize(){
        return companyServiceInterface.showCompaniesBySize();
    }

    @GetMapping("/show_by_year")
    @ResponseStatus(HttpStatus.OK)
    public List<Company> showCompaniesByFounded(){
        return companyServiceInterface.showCompaniesByFounded();
    }

    @GetMapping("/show_numbers")
    @ResponseStatus(HttpStatus.OK)
    public List<Object[]> showCompaniesByNumbers(@RequestParam String param){
        return companyServiceInterface.showCompaniesByNumbers(param);
    }
}
