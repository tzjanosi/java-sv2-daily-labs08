package day04;

public class Team {
    private String name;
    private int wins;
    private int drawns;
    private int loses;

    private int matchNumber;
    private int scores;
    private int goals;
    private int points;

    public Team(String name, int wins, int drawns, int loses, int scores, int goals) {
        this.name = name;
        this.wins = wins;
        this.loses = loses;
        this.drawns = drawns;
        this.scores = scores;
        this.goals = goals;

        this.matchNumber=wins+loses+drawns;
        this.points=calculatePoints();
    }

    private int calculatePoints() {
        return 3*wins+1*drawns;
    }
    public int getAbsDifference() {
        return Math.abs(points-goals);
    }


    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLoses() {
        return loses;
    }

    public int getDrawns() {
        return drawns;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getScores() {
        return scores;
    }

    public int getGoals() {
        return goals;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", drawns=" + drawns +
                ", loses=" + loses +
                ", scores=" + scores +
                ", goals=" + goals +
                '}'+"\n";
    }
}
