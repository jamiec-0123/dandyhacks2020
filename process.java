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


}