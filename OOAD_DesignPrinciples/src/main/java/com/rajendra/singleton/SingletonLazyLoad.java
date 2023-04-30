package com.rajendra.singleton;

//Lazy Initialization
public class SingletonLazyLoad {
    private static SingletonLazyLoad single_instance = null;

    public String s;


    private SingletonLazyLoad()
    {
        s = "Hello OOAD Class";
    }

    public void printMessage(){
        System.out.println(s+" from object "+this.hashCode());
    }

    public static SingletonLazyLoad getInstance()
    {
        if (single_instance == null) {
            single_instance = new SingletonLazyLoad();
            System.out.println("lazy loding the singleton object for the first time");
        }
        return single_instance;
    }


    public static void main(String args[]) {
        SingletonLazyLoad a = SingletonLazyLoad.getInstance();
        SingletonLazyLoad b = SingletonLazyLoad.getInstance();
        SingletonLazyLoad c = SingletonLazyLoad.getInstance();
        SingletonLazyLoad d = SingletonLazyLoad.getInstance();


        if (a==d){
            System.out.println("The same object");
            a.printMessage();
            d.printMessage();


        }


    }



}
