package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        CF x = new CF(13, 11);
        CF y = new CF(1, 2);

        //System.out.println("x:");
        //x.print();
        //System.out.println("y:");
        //y.print();

        CF_Arithmetic cfa = new CF_Arithmetic(x, y);
        cfa.add(x, y);
    }
}
