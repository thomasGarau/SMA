package Core;

public interface StimulusDelegate {

    // Generates a stimulus based on the source position
    Stimulus generateStimulus(Position sourcePosition);
}
