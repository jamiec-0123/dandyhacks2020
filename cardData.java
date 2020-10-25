

import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;

public class cardData{
    private int IDNumber;
    private LocalDateTime lastCheck;

    //constructors
    public cardData(int ID, LocalDateTime lastUse){
        setID(ID);
        setLastCheck(lastUse);
    }

    public cardData(int ID){
        setID(ID);
    }

    public cardData(LocalDateTime lastUse){
        setLastCheck(lastUse);
    }

    public cardData(){
        ;
    }

    //class methods
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
}
