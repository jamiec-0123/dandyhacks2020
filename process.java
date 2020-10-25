import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;
import java.io.File;

public class process{
    List<airQuality> _airQualityData;
    List<trainData> _trainData;
    List<populationLocation> _populationLocationData;
    List<cardData> _cardData;

    public process(){
    }

    public void generateData(){
        HashMap<String,String> tempData = new HashMap<String,String>();
        tempData=readData("./sensors/cardDataDump.txt");
        tempData.forEach((IDNum, dateTimeOfUse) -> {
                cardData tempCardData = new cardData(Integer.parseInt(IDNum), LocalDateTime.parse(dateTimeOfUse));
                _cardData.add(tempCardData);
        });

    }

    public HashMap<String, String> readData(String url){
        HashMap<String,String> output = new HashMap<String,String>();
        File fileOpener = new File(url);
        Scanner fileReader = new Scanner(fileOpener);
        while (fileReader.hasNextLine()){
            String tempData = fileReader.nextLine();
            String[] valuesInQuotes = StringUtils.substringsBetween(tempData , "\"", "\"");
            output.put(valuesInQuotes[0], valuesInQuotes[1]);
        }
    return output;
    }

    public HashMap<String, String> getMostPopulatedSection(String location, int currentFloor){
        HashMap<String, String> data = readData("people");
        //Set tempData and output to <>//same one as above

        switch(location){
            case("kitchen"):
                //Set tempData to data.keyset().removeIf(key -> !key.startsWith(“Kitchenet”))
                break;
            case("ceremony"):
                //Set tempData to data.keyset().removeIf(key -> !key.startsWith(“AgileCeremonySpace”))
                break;
            case("work"):
                //Set tempData to data.keyset().removeIf(key -> !key.startsWith(“AgileWorkSpace”))
            default:
                //set tempData to data
        }

        if (currentFloor >= 1){
            /*
            tempData.forEach((workLocation, population) -> {
            Set TestFloorNum to worklocation.replaceAll(“[^\\d.]”,””)
                what variable type is this?

            Cast TestFloorNum to int and set it to floorNum
            */


            if(floorNum >= (currentFloor + 1) || floorNum >= (currentFloor - 1)){
                output.append(workLocation, population);
            } else {
                output = tempData;
            }

            return output;
        }

    }

    public HashMap<String, String> getMostPopulatedSection(int currentFloor){
        HashMap<String, String> data = readData("people");
        //Set tempData and output to <>//same one as above

        if (currentFloor >= 1){
            /*
            tempData.forEach((workLocation, population) -> {
            Set TestFloorNum to worklocation.replaceAll(“[^\\d.]”,””)
                what variable type is this?

            Cast TestFloorNum to int and set it to floorNum
            */


            if(floorNum >= (currentFloor + 1) || floorNum >= (currentFloor - 1)){
                output.append(workLocation, population);
            } else {
                output = tempData;
            }

            return output;
        }
    }

    public String[] checkWorkTime(LocalDateTime currentTime, int alertReminderTime){

    }

    public boolean checkO2(int floorNum, int o2level){

    }

}