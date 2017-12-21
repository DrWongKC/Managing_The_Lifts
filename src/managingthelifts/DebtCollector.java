package managingthelifts;

/**
 *
 * @author kaichong
 */
public class DebtCollector extends Person {

    private String personWhoseInDebt;
    
    public DebtCollector(String name, String nric, String personWhoseInDebt) {
        super(name, nric, "DEBTCOLLECTOR");
        this.personWhoseInDebt=personWhoseInDebt;
    }
    
    public String getPersonWhoseInDebt() {
        return personWhoseInDebt;
    }
    
    public String toString() {
        return "The name of this person is "+super.getName()+", his nric is "+super.getNric()+" and he came to collect debt from "+personWhoseInDebt;
    }
    
}
