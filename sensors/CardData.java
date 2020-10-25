package DANDYHACKS2020.sensors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CardData{
    private int IDNumber;
    private LocalDateTime lastCheck;

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
