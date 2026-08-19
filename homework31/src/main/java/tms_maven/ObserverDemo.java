package tms_maven;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();
}

class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String news;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news);
        }
    }

    public void setNews(String news) {
        this.news = news;
        notifyObservers();
    }
}

class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил новость: " + message);
    }
}

class NewsWebsite implements Observer {
    private String url;

    public NewsWebsite(String name) {
        this.url = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Веб-сайт " + url + " обновлен: " + message);
    }
}

public class ObserverDemo {
    public static void main() {
        NewsAgency agency = new NewsAgency();
        Observer channel1 = new NewsChannel("XYZ");
        Observer channel2 = new NewsChannel("128 канал");
        Observer website = new NewsWebsite("news.com");

        agency.attach(channel1);
        agency.attach(channel2);
        agency.attach(website);

        agency.setNews("Кот упал!");

        agency.detach(channel2);

        agency.setNews("Half-Life 3 вышла!");
    }
}
