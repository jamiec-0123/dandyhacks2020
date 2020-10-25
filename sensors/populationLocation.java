package DANDYHACKS2020.sensors;

public class populationLocation{
    private String _Location;
    private int _population;

    public populationLocation(String location, int population){
        setLocation(location);
        setPopulation(population);
    }

    public populationLocation(String location){
        setLocation(location);
    }

    public populationLocation(int population){
        setPopulation(population);
    }

    public populationLocation(){

    }

    public String getLocation(){
        return this._Location;
    }
    public void setLocation(String location){
        this._Location=location;
    }

    public int getPopulation(){
        return this._population;
    }
    public void setPopulation(int population){
        this._population=population;
    }
}