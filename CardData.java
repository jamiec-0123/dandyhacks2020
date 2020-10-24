import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardData{
    private int IDNumber;
    private LocalDateTime lastCheck;

    public int getID(){
        return IDNumber;
    }

    public void setID(int inputID){
        this.IDNumber = inputID;
    }

    public LocalDateTime getLastCheck(){
        return lastCheck;
    }

    public void setLastCheck(LocalDateTime lastCheck){
        this.lastCheck = lastCheck;
    }

    //constructors
    public CardData(int ID, LocalDateTime lastUse){
        setID(ID);
        setLastCheck(lastUse);
    }

    public CardData(int ID){
        setID(ID);
    }

    public CardData(LocalDateTime lastUse){
        setLastCheck(lastUse);
    }

    public CardData(){
        ;
    }

    //the only way I can see what my debugger doesn't like is if I have a main ignore this
    public static void main(String[] args){}
}
