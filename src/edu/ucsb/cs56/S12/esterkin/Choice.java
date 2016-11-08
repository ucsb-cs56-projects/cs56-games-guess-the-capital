/**
 * Model that keeps track of the current session.
 *
 * @author Sean Shelton, Armin Mahini
 * @version UCSB CS56, F16
 */
import java.util.ArrayList;

public class Choice {
    
    private String choice;
    
    Choice(){
	choice = "";
    }
    
    public String getChoice(){
	return this.choice;
    }
 
    public void setChoice(String c){
	this.choice = c;
    }

    public String toString(){
	return this.choice;
    }
}
