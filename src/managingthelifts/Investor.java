package managingthelifts;

/**
 *
 * @author kaichong
 */
public class Investor extends Person {

    private String companyName;
    
    public Investor(String name, String nric, String companyName) {
        super(name, nric, "INVESTOR");
        this.companyName=companyName;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public String toString() {
        return "The name of this person is "+super.getName()+", his nric is "+super.getNric()+" and he is the investor of "+companyName;
    }
    
}
