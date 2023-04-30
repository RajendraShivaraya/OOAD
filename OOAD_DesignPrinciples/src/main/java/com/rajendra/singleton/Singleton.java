package com.rajendra.singleton;

public class Singleton {
    private static Singleton single_instance = new Singleton();

    public String s;


    private Singleton()
    {
        s = "Hello OOAD Class";
    }

    public void printMessage(){
        System.out.println(s+" from object "+this.hashCode());
    }

    public static Singleton getInstance()
    {
        return single_instance;
    }


    public static void main(String args[]) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();


        if (a==b){
            System.out.println("The same object");
            a.printMessage();
            b.printMessage();


        }


    }



}
