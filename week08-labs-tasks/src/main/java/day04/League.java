package day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class League {
    List<String> allRecord;
    List<Team> teamsList = new ArrayList<>();

    public void createTeamsListFromFile(Path path) {
        allRecord = readFile(path);
        String record;
        for (int i = 1; i < allRecord.size(); i++) {
            if(i!=18){
                record = allRecord.get(i);
                teamsList.add(createTeamFromRecord(record));
            }
        }
    }

    private Team createTeamFromRecord(String record) {
        String name=record.substring(7,20).trim();
        int wins=createIntFromString(record.substring(29,31));
        int drawns=createIntFromString(record.substring(33,35));
        int loses=createIntFromString(record.substring(37,39));
        int scores=createIntFromString(record.substring(43,45));
        int goals=createIntFromString(record.substring(50,52));

        return new Team(name,wins,drawns,loses,scores,goals);
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

    public List<Team> getTeamsList() {
        return teamsList;
    }

    public static void main(String[] args) {
        League league=new League();
        league.createTeamsListFromFile(Paths.get("src/main/resources/football.dat"));
        Team teamWithMinDifference=league.teamWithMinDifference();
        System.out.println("Day wit minimal difference: "+teamWithMinDifference.getName()+" Min difference: "+teamWithMinDifference.getAbsDifference());

    }

    private Team teamWithMinDifference() {
        Team teamWithMinDifference=teamsList.get(0);
        int minDifference=teamWithMinDifference.getAbsDifference();
        for(Team team:teamsList){
            System.out.println(team.getAbsDifference());
            if(team.getAbsDifference()<minDifference){
                teamWithMinDifference=team;
                minDifference=teamWithMinDifference.getAbsDifference();
            }
        }
        return teamWithMinDifference;
    }

}
