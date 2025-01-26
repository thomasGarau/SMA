package SimulationConcrete.Fourmille;

import Core.Observer;
import Core.Position;
import Core.Stimulus;

public class StimulusPheromone implements Stimulus {
    private Position sourcePosition;

    public StimulusPheromone(Position sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    public Position getSourcePosition() {
        return sourcePosition;
    }

    @Override
    public boolean isRelevantFor(Observer observer) {
        return observer instanceof FourmiExploratrice; // Ce stimulus est pertinent pour les exploratrices
    }

    @Override
    public void applyEffect(Observer observer) {
        if (observer instanceof FourmiExploratrice) {
            FourmiExploratrice fourmi = (FourmiExploratrice) observer;
            System.out.println("StimulusPheromone appliqué à une fourmi exploratrice.");
            // Implémenter l'effet souhaité sur l'exploratrice
        }
    }
}
