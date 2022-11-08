package hackathon.challenge.services.interfaces;

import hackathon.challenge.models.Company;

import java.util.List;

public interface CompanyServiceInterface {

    Iterable<Company> saveCompanies(List<Company> companies);
    List<Company> showCompaniesBySize();
    List<Company> showCompaniesByFounded();
    List<Object[]> showCompaniesByNumbers(String param);
}
