package com.company;

import java.util.ArrayList;
import java.util.List;

interface Observable {
    void notifyObservers();
    void regObserver(Observer observer);
}
interface Observer{
    void Notification(String news);
}
class Groups implements Observable{
    List<Observer> list = new ArrayList<>();
    String news;
    void setNews(String news){
        this.news = news;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: list){
            observer.Notification(news);
        }
    }

    @Override
    public void regObserver(Observer observer) {
        list.add(observer);
    }
}
class Subscribers implements Observer{
    String name;
    public Subscribers(String name){
        this.name = name;
    }

    @Override
    public void Notification(String news) {
        System.out.println(name + " получил оповещение: " + news);
    }
}
public class Main {
    public static void main(String[] args) {
        Groups MTGNew = new Groups();
        Groups RobotWd = new Groups();
        Groups Warframe = new Groups();
        Groups Skillet = new Groups();

        Subscribers sub1 = new Subscribers("Greenwood");
        Subscribers sub2 = new Subscribers("Arcady");

        MTGNew.regObserver(sub1);
        MTGNew.regObserver(sub2);
        RobotWd.regObserver(sub1);
        RobotWd.regObserver(sub2);
        Warframe.regObserver(sub1);
        Warframe.regObserver(sub2);
        Skillet.regObserver(sub2);

        MTGNew.setNews("В России новый сет выпущен не будет" + "\n");
        RobotWd.setNews("В группе Robot World появился новый пост с фактами о роботах" + "\n");
        Warframe.setNews("Наконется, это обновления игроки ждали годами. Стала известна дата выхода Парадокса Дувири" + "\n");
        Skillet.setNews("У известной группы Skillet вышла новая песня" + "\n");

    }
}
