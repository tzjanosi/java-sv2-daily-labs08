package day04;

public class WeatherOfDay {
    private final int nameOfDay;
    private final int min;
    private final int max;
    private final int difference;

    public WeatherOfDay(int nameOfDay, int min, int max) {
        this.nameOfDay = nameOfDay;
        this.min = min;
        this.max = max;
        this.difference=max-min;
    }

    public int getNameOfDay() {
        return nameOfDay;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getDifference() {
        return difference;
    }

    @Override
    public String toString() {
        return "{" +
                "nameOfDay=" + nameOfDay +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
