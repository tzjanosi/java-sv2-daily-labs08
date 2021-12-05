package day05;


import java.util.Arrays;
import java.util.List;

public class TemperatureFileReader extends AbstractFileReader {
    public TemperatureFileReader(String fileName) {
        super(fileName);
    }

    @Override
    public List<Integer> getFilteredIndexes() {
        return Arrays.asList(0, 1, 32);
    }

    @Override
    public Position getNamePosition() {
        return new Position(2, 4);
    }

    @Override
    public Position getValue1Position() {
        return new Position(6, 8);
    }

    @Override
    public Position getValue2Position() {
        return new Position(12, 14);
    }
}
