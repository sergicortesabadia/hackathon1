package hackathon.challenge.repositories;

import hackathon.challenge.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query(value = "SELECT * FROM companies.company ORDER BY (CASE size WHEN '10001+' THEN 1 WHEN '5001-10000' THEN 2 WHEN '1001-5000' THEN 3 WHEN '501-1000' THEN 4 WHEN '201-500' THEN 5 WHEN '51-200' THEN 6 WHEN '11-50' THEN 7 WHEN '1-10' THEN 8 END) ASC, size DESC;", nativeQuery = true)
    List<Company> findCompanyOrderBySize();

    @Query("SELECT comp FROM Company comp ORDER BY comp.founded ASC")
    List<Company> findCompanyOrderByFounded();

    @Query("SELECT comp.industry, COUNT(comp) FROM Company comp GROUP BY comp.industry")
    List<Object[]> countCompaniesByIndustry();

    @Query("SELECT comp.size, COUNT(comp) FROM Company comp GROUP BY comp.size")
    List<Object[]> countCompaniesBySize();

    @Query("SELECT comp.founded, COUNT(comp) FROM Company comp GROUP BY comp.founded ORDER BY comp.founded")
    List<Object[]> countCompaniesByFounded();
}