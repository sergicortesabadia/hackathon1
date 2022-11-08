package hackathon.challenge.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Company {
    @Id
    @Column(unique = true)
    private String id;
    private String website;
    private String name;
    private int founded;
    private String size;
    private String locality;
    private String region;
    private String country;
    private String industry;
    private String linkedin_url;

    public Company() {
    }

    public Company(String id, String website, String name, int founded, String size, String locality, String region, String country, String industry, String linkedin_url) {
        setId(id);
        setWebsite(website);
        setName(name);
        setFounded(founded);
        setSize(size);
        setLocality(locality);
        setRegion(region);
        setCountry(country);
        setIndustry(industry);
        setLinkedin_url(linkedin_url);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLinkedin_url() {
        return linkedin_url;
    }

    public void setLinkedin_url(String linkedin_url) {
        this.linkedin_url = linkedin_url;
    }
}
