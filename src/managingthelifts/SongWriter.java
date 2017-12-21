package managingthelifts;

/**
 *
 * @author kaichong
 */
public class SongWriter extends Person {
    
    private String songTitle;
    
    public SongWriter(String name, String nric, String songTitle) {
        super(name, nric, "SONGWRITER");
        this.songTitle=songTitle;
    }
    
    public String getSongTitle() {
        return songTitle;
    }
    
    public String toString() {
        return "The name of this person is "+super.getName()+", his nric is "+super.getNric()+" and the song title is "+songTitle;
    }
    
}
