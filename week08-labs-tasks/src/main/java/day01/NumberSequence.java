package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbersList=new ArrayList<>();
    private Random random = new Random();
    private double average;

    public NumberSequence(List<Integer> numbersList) {
        this.numbersList = numbersList;
    }
    public NumberSequence(int length, int min, int max) {
        for (int i = 0; i < length; i++) {
            numbersList.add(min+random.nextInt(max-min+1));
        }
    }
    private void setAverage(){
        Integer total=0;
        for(Integer number:numbersList){
            total+=number;
        }
        average=(double) (total/numbersList.size());
    }
    public List<Integer> closeToAverage(int value){
        setAverage();
        List<Integer> closeToAverageList=new ArrayList<>();
        for(Integer number:numbersList){
           if(Math.abs(number-average)<value){
               closeToAverageList.add(number);
           }
        }
        return closeToAverageList;
    }

    public List<Integer> getNumbersList() {
        return numbersList;
    }

    public double getAverage() {
        return average;
    }
}
