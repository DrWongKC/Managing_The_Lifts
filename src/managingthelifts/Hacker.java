package managingthelifts;

/**
 *
 * @author kaichong
 */
public class Hacker extends Person {
    
    private String country;
    
    public Hacker(String name, String nric,String country) {
        super(name, nric, "HACKER");
        this.country=country;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String toString() {
        return "The name of this person is "+super.getName()+", his nric is "+super.getNric()+" and he is from "+country;
    }
    
}
