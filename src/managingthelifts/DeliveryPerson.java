package managingthelifts;

/**
 *
 * @author kaichong
 */
public class DeliveryPerson extends Person {
    
    private String foodType;
    
    public DeliveryPerson(String name, String nric, String foodType) {
        super(name, nric, "DELIVERYPERSON");
        this.foodType=foodType;
    }
    
    public String getFoodType() {
        return foodType;
    }
    
    public String toString() {
        return "The name of this person is "+super.getName()+", his nric is "+super.getNric()+" and he brought food of type "+foodType;
    }
    
}
