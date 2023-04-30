package com.rajendra.observer;

import java.util.Observable;
import java.util.Observer;

class NewsChannel2 implements Observer {

    private String news;

    @Override
    public void update(Observable o, Object news) {
        this.setNews((String) news);
    }
    private void setNews(String news) {
        this.news=news;
    }

    public String getNews() {
        return news;
    }
}

class NewsAgency2 extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}


public class NewsAgencyDemo2{

    public static void main(String args[]){

        NewsAgency2 observable = new NewsAgency2();
        NewsChannel2 observer = new NewsChannel2();

        observable.addObserver(observer);
        observable.setNews("Good news");
        System.out.println(observer.getNews());
    }
}
