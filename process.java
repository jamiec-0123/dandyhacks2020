package DANDYHACKS2020;
import DANDYHACKS2020.sensors.*;
import java.util.*;  

public class process{
    List<roomdatas.airQuality> _airQualityData;
    List<roomdatas.trainData> _trainData;
    List<roomdatas.populationLocation> _populationLocationData;
    List<roomdatas.cardData> _cardData;
    public process(){
        
    }
    public void generateData(){
        HashMap<String,String> tempData = new HashMap<String,String>();
        tempData=readData("./sensors/cardDataDump.txt");
        tempData.forEach((IDNum, dateTimeOfUse) -> {
                roomdatas.cardData tempCardData = new roomdatas.cardData(parseIn(IDNum), LocalDate.parse(dateTimeOfUse));
                cardData.add(tempCardData);
        }

    }
    public HashMap<String,String> readData(String url){
        HashMap<String,String> output = new HashMap<String,String>();
        fileOpener = File(url);
        fileReader = new Scanner(fileOpener);
        while (fileReader.hasNextLine()):
            tempData = fileReader.nextLine();
            String[] valuesInQuotes = StringUtils.substringsBetween(tempData , "\"", "\"");
            output.add(valuesInQuotes[0], valuesInQuotes[1]);
    return output;
    }

}