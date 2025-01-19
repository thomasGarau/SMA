package Core;

public interface ObservableEnvironment {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Stimulus stimulus);
}
