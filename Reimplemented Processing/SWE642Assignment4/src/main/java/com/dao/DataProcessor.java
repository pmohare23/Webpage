//Tomas Doherty

package com.dao;
import com.bean.DataBean;
import java.lang.Math;
//import java.util.Scanner;

public class DataProcessor {

    // For testing purposes
    /*public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        String input;

        input = myObj.nextLine();
        while(!input.equals("q")){
            dataBean outputs = processNums(input);
            System.out.println("Mean: "+outputs.getMean()+"\nSTD: "+outputs.getStd());
            input = myObj.nextLine();
        }
    }*/

    // Method to run to processed Data field input as DataBean
    public DataBean processNums(String dataInput) throws IllegalArgumentException{
        String[] inputs = dataInput.split(",");

        if(inputs.length < 10){
            throw new IllegalArgumentException("Data input must have 10 numbers! Got "+inputs.length);
        }

        double[] nums = new double[inputs.length];

        for(int i = 0; i < nums.length; i++){
            double num = Integer.parseInt(inputs[i]);
            nums[i] = num;
        }

        double mean = mean(nums), std = std(nums, mean);
        DataBean b1 = new DataBean();
        b1.setMean(mean);
        b1.setStd(std);
        return b1 ;
    }

    private static double mean(double[] nums){
        double total = 0f;

        for(double num: nums){
            total+= num;
        }

        return total/(double)nums.length;
    }

    private static double std(double[] nums, double mean){
        double std = 0f;

        for(double num: nums){
            std += Math.pow(num - mean, 2);
        }

        return Math.sqrt(std/nums.length);
    }
}
