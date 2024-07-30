package raf.dsw.gerumap.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscriber(Object notification, Object typeOfUpdate);
}
