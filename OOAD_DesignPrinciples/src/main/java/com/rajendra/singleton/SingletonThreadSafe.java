package com.rajendra.singleton;

//Lazy Initialization
public class SingletonThreadSafe {
    private static SingletonThreadSafe single_instance = null;

    public String s;


    private SingletonThreadSafe()
    {
        s = "Hello OOAD Class";
    }

    public void printMessage(){
        System.out.println(s+" from object "+this.hashCode());
    }

    synchronized public static SingletonThreadSafe getInstance()
    {
        if (single_instance == null)
            single_instance = new SingletonThreadSafe();

        return single_instance;
    }


    public static void main(String args[]) {
        SingletonThreadSafe a = SingletonThreadSafe.getInstance();
        SingletonThreadSafe b = SingletonThreadSafe.getInstance();


        if (a==b){
            System.out.println("The same object");
            a.printMessage();
            b.printMessage();


        }


    }



}
