package Core;

public interface ObservableFragment {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Stimulus stimulus);
}
