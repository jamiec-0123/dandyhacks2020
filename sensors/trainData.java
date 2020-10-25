package DANDYHACKS2020.trainData;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class trainData{
    private String _route;
    private LocalDateTime _arrivalTime;

    public String getRoute(){
        return this._route;
    }

    public void setRoute(String route){
        this._route = route;
    }

    public LocalDateTime getArrivalTime(){
        return this._arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime){
        this._arrivalTime = arrivalTime;
    }

    public trainData(String route, LocalDateTime arrivalTime){
        setArrivalTime(arrivalTime);
        setRoute(route);
    }

    public trainData(String route){
        setRoute(route);
    }

    public trainData(LocalDateTime arrivalTime){
        setArrivalTime(arrivalTime);
    }
    public trainData(){
        
    }
}