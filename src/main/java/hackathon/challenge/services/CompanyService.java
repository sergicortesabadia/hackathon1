package hackathon.challenge.services;

import hackathon.challenge.models.Company;
import hackathon.challenge.repositories.CompanyRepository;
import hackathon.challenge.services.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompanyService implements CompanyServiceInterface {
    @Autowired
    CompanyRepository companyRepository;




    public Iterable<Company> saveCompanies(List<Company> companies) {
        return companyRepository.saveAll(companies);
    }

    public List<Company> showCompaniesBySize(){
        return companyRepository.findCompanyOrderBySize();
    }
    public List<Company> showCompaniesByFounded(){
        return companyRepository.findCompanyOrderByFounded();
    }
    public List<Object[]> showCompaniesByNumbers(String param) {
            switch (param) {
                case "industry":
                    return companyRepository.countCompaniesByIndustry();
                case "size":
                    return companyRepository.countCompaniesBySize();
                case "year":
                    return companyRepository.countCompaniesByFounded();
                default:
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only request a count of companies by 'industry', 'size' or 'year' of foundation.");
            }
    }
}
