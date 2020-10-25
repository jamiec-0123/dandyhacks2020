

public class airQuality{
    private double _airPercentage;
    private String _Location;

    //constructors?
    public airQuality(double airPercentage, String location){
        setAirPercentage(airPercentage);
        setLocation(location);
    }

    public airQuality(double airPercentage){
        setAirPercentage(airPercentage);
    }

    public airQuality(String location){
        setLocation(location);
    }

    public airQuality(){

    }

    //class methods
    public String getLocation(){
        return this._Location;
    }

    public void setLocation(String location){
        this._Location = location;
    }

    public double getAirPercentage(){
        return this._airPercentage;
    }

    public void setAirPercentage(double airPercentage){
        this._airPercentage = airPercentage;
    }

}