import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class process{
    List<airQuality> _airQualityData;
    List<trainData> _trainData;
    List<populationLocation> _populationLocationData;
    List<cardData> _cardData;

    public process(){
        generateData();
    }

    public void generateData(){
        Map<String,String> tempData = new HashMap<String,String>();
        tempData=readData("./sensors/cardDataDump.txt");
        tempData.forEach((IDNum, dateTimeOfUse) -> {
                cardData tempCardData = new cardData(Integer.parseInt(IDNum), LocalDateTime.parse(dateTimeOfUse));
                _cardData.add(tempCardData);
        });

    }

    public Map<String, String> readData(String url){
        boolean flipFlop = true;
        String keyData ="";
        String dicValue = ""; 
        Map<String,String> output = new HashMap<String,String>();
        File fileOpener = new File(url);
        try {
        Scanner fileReader = new Scanner(fileOpener);
        while (fileReader.hasNextLine()){
            String tempData = fileReader.nextLine();
            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = p.matcher(tempData);
            while (m.find()) {
              if(flipFlop){
                  keyData =m.group(1);
                  flipFlop=false;
              }
              else{
                  dicValue=m.group(1);
                  flipFlop=true;
              }
            }
            output.put(keyData, dicValue);
            }
        }catch(Exception e){
                System.out.println(e.getClass());
     }
    return output;
    }

    public Map<String, String> getMostPopulatedSection(String location, int currentFloor){
        Map<String, String> data = readData("people");
        //Set tempData and output to <>//same one as above
        Map<String,String> tempData = new HashMap<String,String>();
        Map<String,String> output = new HashMap<String,String>();
        boolean foundFloor = false;
        switch(location){
            case("kitchen"):
                    Set<String> kitchenSet = data.keySet()
                                .stream()
                                .filter(s -> s.startsWith("Kitchenet"))
                                .collect(Collectors.toSet());
                //Set tempData to data.keyset().removeIf(key -> !key.startsWith(“Kitchenet”))
                break;
            case("ceremony"):
                Set<String> agileSer = data.keySet()
                            .stream()
                            .filter(s -> s.startsWith("AgileCeremonySpace"))
                            .collect(Collectors.toSet());
                //Set tempData to data.keyset().removeIf(key -> !key.startsWith(“AgileCeremonySpace”))
                break;
            case("work"):

                Set<String> workSet = data.keySet()
                            .stream()
                            .filter(s -> s.startsWith("AgileWorkSpace"))
                            .collect(Collectors.toSet());
           
           
                //Set tempData to data.keyset().removeIf(key -> !key.startsWith(“AgileWorkSpace”))
            default:
                tempData =data;
                //set tempData to data
            return tempData;
        }
        boolean flipFlop = true;
        String keyData ="";
        if (currentFloor >= 1){
            tempData.forEach((workLocation, population) -> {
                Pattern p = Pattern.compile("[^\\d.]\",\"");
                Matcher m = p.matcher(workLocation);
                while (m.find()) {
                    keyData =m.group(1);
                }
                /*
                tempData.forEach((workLocation, population) -> {
                    what variable type is this?
                Cast TestFloorNum to int and set it to floorNum
                */
                int floorNum = Integer.valueOf(keyData);
                if(floorNum >= (currentFloor + 1) || floorNum >= (currentFloor - 1)){
                    output.put(workLocation, population);
                    foundFloor=true;
                }
            });
        }
        else{

        }
    if(!foundFloor){
        output = data;
    }
    return output;
    }

    
    public Map<String, String> getMostPopulatedSection(int currentFloor){
        Map<String, String> data = readData("people");
        Map<String,String> output = new HashMap<String,String>();
        Map<String,String> tempData = new HashMap<String,String>();
        String keyData ="";
        //Set tempData and output to <>//same one as above
        data.forEach((workLocation, population) -> {
            if (currentFloor >= 1){
                /*
                tempData.forEach((workLocation, population) -> {
                Set TestFloorNum to worklocation.replaceAll(“[^\\d.]”,””)
                    what variable type is this?

                Cast TestFloorNum to int and set it to floorNum
                */
                Pattern p = Pattern.compile("[^\\d.]\",\"");
                Matcher m = p.matcher(workLocation);
                while (m.find()) {
                    keyData =m.group(1);
                }

                int floorNum = Integer.valueOf(keyData);
                if(floorNum >= (currentFloor + 1) || floorNum >= (currentFloor - 1)){
                    output.put(workLocation, population);
                } else {
                    output = tempData;
                }

            }
        });
        return output;
    }
    

    public void checkWorkTime(LocalDateTime currentTime, int alertReminderTime){

    }

    public  boolean checkO2(int floorNum, int o2level){
        return false;
    }

}