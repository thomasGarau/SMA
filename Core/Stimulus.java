package Core;

public interface Stimulus {

    // Checks if this stimulus is relevant for a given observer
    boolean isRelevantFor(Observer observer);

    // Applies the effect of the stimulus to the observer
    void applyEffect(Observer observer);
}
