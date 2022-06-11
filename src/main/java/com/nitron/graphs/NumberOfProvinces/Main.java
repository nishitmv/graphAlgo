package com.nitron.graphs.NumberOfProvinces;

public class Main {

    public static void main(String[] args) {

       int[][] isConnected =  {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(new ProvinceCounter(isConnected.length).countProvinces(isConnected));


    }

}
