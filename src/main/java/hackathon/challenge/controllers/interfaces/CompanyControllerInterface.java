package hackathon.challenge.controllers.interfaces;

import hackathon.challenge.models.Company;

import java.util.List;

public interface CompanyControllerInterface {
    List<Company> showCompaniesBySize();
    List<Company> showCompaniesByFounded();
    List<Object[]> showCompaniesByNumbers(String param);
}
