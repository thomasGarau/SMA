package SimulationConcrete.Fourmille;

import Core.Observer;
import Core.Position;
import Core.Stimulus;

public class StimulusNourriture implements Stimulus {
    private Position sourcePosition;

    public StimulusNourriture(Position sourcePosition) {
        this.sourcePosition = sourcePosition;
    }

    public Position getSourcePosition() {
        return sourcePosition;
    }

    @Override
    public boolean isRelevantFor(Observer observer) {
        return observer instanceof FourmiOuvriere; // Ce stimulus est pertinent pour les ouvrières
    }

    @Override
    public void applyEffect(Observer observer) {
        if (observer instanceof FourmiOuvriere) {
            FourmiOuvriere fourmi = (FourmiOuvriere) observer;
            fourmi.setFragment(null); // Ex. pour signaler qu’elle doit se déplacer vers la position de la nourriture
            System.out.println("StimulusNourriture appliqué à une fourmi ouvrière.");
        }
    }
}
