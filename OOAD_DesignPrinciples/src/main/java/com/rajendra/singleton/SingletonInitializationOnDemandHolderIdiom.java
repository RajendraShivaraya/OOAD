package com.rajendra.singleton;

public class SingletonInitializationOnDemandHolderIdiom {

    public String s;

    private SingletonInitializationOnDemandHolderIdiom() {
        s = "Hello OOAD Class";
    }


    private static class LazyHolder {
        static final SingletonInitializationOnDemandHolderIdiom INSTANCE =
                new SingletonInitializationOnDemandHolderIdiom();
    }

    public static SingletonInitializationOnDemandHolderIdiom getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printMessage(){
        System.out.println(s+" from object "+this.hashCode());
    }








    public static void main(String args[]) {
        SingletonInitializationOnDemandHolderIdiom a = SingletonInitializationOnDemandHolderIdiom.getInstance();
        SingletonInitializationOnDemandHolderIdiom b = SingletonInitializationOnDemandHolderIdiom.getInstance();


        if (a==b){
            System.out.println("The same object");
            a.printMessage();
            b.printMessage();


        }


    }



}
