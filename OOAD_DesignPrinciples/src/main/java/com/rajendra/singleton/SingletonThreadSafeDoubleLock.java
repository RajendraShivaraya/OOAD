package com.rajendra.singleton;

//Lazy Initialization
public class SingletonThreadSafeDoubleLock {
    private static SingletonThreadSafeDoubleLock single_instance = new SingletonThreadSafeDoubleLock();

    public String s;


    private SingletonThreadSafeDoubleLock()
    {
        s = "Hello OOAD Class";
    }

    public void printMessage(){
        System.out.println(s+" from object "+this.hashCode());
    }

    public  static SingletonThreadSafeDoubleLock getInstance()
    {
        if (single_instance == null)
            {
                //synchronized block to remove overhead
                synchronized (SingletonThreadSafeDoubleLock.class)
                {
                    if(single_instance==null)
                    {
                        single_instance = new SingletonThreadSafeDoubleLock();
                    }

                }
            }
            return single_instance;
    }


    public static void main(String args[]) {
        SingletonThreadSafeDoubleLock a = SingletonThreadSafeDoubleLock.getInstance();
        SingletonThreadSafeDoubleLock b = SingletonThreadSafeDoubleLock.getInstance();


        if (a==b){
            System.out.println("The same object");
            a.printMessage();
            b.printMessage();


        }


    }



}
