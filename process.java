import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.*;


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
                cardData tempCardData = new cardData(parseInt(IDNum), LocalDateTime.parse(dateTimeOfUse));
                _cardData.add(tempCardData);
        });

    }
    public HashMap<String,String> readData(String url){
        HashMap<String,String> output = new HashMap<String,String>();
        var fileOpener = File(url);
        var fileReader = new Scanner(fileOpener);
        while (fileReader.hasNextLine()){
            tempData = fileReader.nextLine();
            String[] valuesInQuotes = StringUtils.substringsBetween(tempData , "\"", "\"");
            output.add(valuesInQuotes[0], valuesInQuotes[1]);
        }
    return output;
    }

}