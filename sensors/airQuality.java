<<<<<<< HEAD
package roomdatas;
public class airQuality{
=======
package sensors;

public class airQuality {
>>>>>>> cfad9ea8f9bd4bbe4da8c20dd8d103d019281726
    private double _airPercentage;
    private String _Location;

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

    public String getLocation(){
        return this._Location;
    }

    public void setLocation(String location){
        this._Location=location;
    }

    public double getAirPercentage(){
        return this._airPercentage;
    }

    public void setAirPercentage(double airPercentage){
        this._airPercentage=airPercentage;
    }

}