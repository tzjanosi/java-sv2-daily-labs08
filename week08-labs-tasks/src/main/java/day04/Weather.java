package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Weather {
    List<String> allRecord;
    List<WeatherOfDay> weatherOfDaysList = new ArrayList<>();

    public WeatherOfDay dayWithMinDifference(){
        WeatherOfDay dayWithMinDifference=weatherOfDaysList.get(0);
        int minDifference=dayWithMinDifference.getDifference();
        for(WeatherOfDay weatherOfDay:weatherOfDaysList){
            if(weatherOfDay.getDifference()<minDifference){
                dayWithMinDifference=weatherOfDay;
                minDifference=dayWithMinDifference.getDifference();
            }
        }
        return dayWithMinDifference;
    }
    public void createWeatherListFromFile(Path path) {
        List<String> allRecord = readFile(path);
        String record;
        for (int i = 2; i < allRecord.size() - 1; i++) {
            record = allRecord.get(i);
            //System.out.println(record);
            weatherOfDaysList.add(createWeatherFromRecord(record));
        }
    }

    private WeatherOfDay createWeatherFromRecord(String record) {
        int day=createIntFromString(record.substring(2,4));
        int max=createIntFromString(record.substring(6,8));
        int min=createIntFromString(record.substring(12,14));
        return new WeatherOfDay(day,min,max);
    }

    private int createIntFromString(String substring) {
        return Integer.parseInt(substring.trim());
    }


    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file: "+path, ioe);
        }
    }

    public List<String> getAllRecord() {
        return allRecord;
    }

    public List<WeatherOfDay> getWeatherOfDaysList() {
        return weatherOfDaysList;
    }

    public static void main(String[] args) {
        Weather weather=new Weather();
        weather.createWeatherListFromFile(Paths.get("src/main/resources/weather.dat"));
        WeatherOfDay dayWithMinDifference=weather.dayWithMinDifference();
        System.out.println("Day wit minimal temperature difference: "+dayWithMinDifference.getNameOfDay()+", Min: "+dayWithMinDifference.getMin()+", Max: "+dayWithMinDifference.getMax()+", Difference: "+dayWithMinDifference.getDifference());
    }

}
