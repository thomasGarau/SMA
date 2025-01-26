package SimulationConcrete.Fourmille;

import javax.swing.text.Position;

import Core.Environement;
import Core.Fragment;
import Core.Stimulus;

public class FourmiOuvriere extends Fourmi {
    private int nouritureTransportable;
    private int nouritureTransportee = 0;

    public FourmiOuvriere() {
        super();
        this.nouritureTransportable = 20 + (int) (Math.random() * 11);
        this.setVitesse(1 + (int) Math.random() * 3);
    }

    public void addNourtirure(int quantite){
        this.nouritureTransportee += quantite;
    }

    @Override
    public void action(Environement environement) {
        if (nouritureTransportee + 2 > nouritureTransportable || this.getJaugeFaim() <= 5) {
            if (this.getFragment() instanceof TerrierFragment) {
                this.inTerrier();
            } else {
                EnvironnementFourmi environnementFourmi = (EnvironnementFourmi) environement;
                this.rentrerTerrier(environnementFourmi);
            }
        } else {
            Fragment fragment = this.getFragment();

            // Vérifie que le fragment est valide et de type FragmentInfourmilleEnvironement
            if (fragment instanceof FragmentInfourmilleEnvironement) {
                FragmentInfourmilleEnvironement f = (FragmentInfourmilleEnvironement) fragment;

                // Vérifie que la liste de nourriture est non nulle et non vide
                if (f.getNourriture() != null && !f.getNourriture().isEmpty()) {
                    this.agir(); // La fourmi agit pour collecter de la nourriture
                }
            }
        }
    }


    @Override
    public void inTerrier() {
        super.inTerrier();
        ((TerrierFragment) this.getFragment()).ajouterNourriture(nouritureTransportee);
        nouritureTransportee = 0;
    }

    @Override
    public void agir() {
        ((FragmentInfourmilleEnvironement) this.getFragment()).retirerNouriture(this);
    }


    @Override
    public void reagir(Stimulus stimulus) {
        if (stimulus instanceof StimulusNourriture) {
            StimulusNourriture nourritureStimulus = (StimulusNourriture) stimulus;
            Position sourcePosition = (Position) nourritureStimulus.getSourcePosition();
            System.out.println("Fourmi ouvrière détecte de la nourriture à proximité en " +
                               ((Core.Position) sourcePosition).getPositionX() + ", " + ((Core.Position) sourcePosition).getPositionY());
    
            // Vérifie si la nourriture est à une case adjacente
            int currentX = this.getPosition().getPositionX();
            int currentY = this.getPosition().getPositionY();
            int deltaX = Math.abs(currentX - ((Core.Position) sourcePosition).getPositionX());
            int deltaY = Math.abs(currentY - ((Core.Position) sourcePosition).getPositionY());
    
            if (deltaX <= 1 && deltaY <= 1) {
                // La nourriture est adjacente : se déplacer vers la case de nourriture
                this.setFragment(null); // Libère la case actuelle
                this.setTargetPosition((Core.Position) sourcePosition); // Définit la cible comme la position de la nourriture
            }
        }
    }
    

    @Override
    public void seDeplacer(Environement environement) {
        EnvironnementFourmi environnementFourmi = (EnvironnementFourmi) environement;
        Position currentPosition = (Position) this.getPosition();
        int currentX = ((Core.Position) currentPosition).getPositionX();
        int currentY = ((Core.Position) currentPosition).getPositionY();

        // Si une cible existe, calcule le prochain déplacement
        if (this.getTargetPosition() != null) {
            Position targetPosition = (Position) this.getTargetPosition();
            int targetX = ((Core.Position) targetPosition).getPositionX();
            int targetY = ((Core.Position) targetPosition).getPositionY();

            // Calcule le prochain mouvement en direction de la cible
            int nextX = currentX;
            int nextY = currentY;

            if (currentX < targetX) {
                nextX++;
            } else if (currentX > targetX) {
                nextX--;
            }

            if (currentY < targetY) {
                nextY++;
            } else if (currentY > targetY) {
                nextY--;
            }

            // Effectue le déplacement
            environnementFourmi.MoveAgent(this, nextX, nextY);
            System.out.println("Fourmi ouvrière se déplace vers " + nextX + ", " + nextY);

            // Vérifie si la fourmi a atteint sa cible
            if (nextX == targetX && nextY == targetY) {
                System.out.println("Fourmi ouvrière a atteint la nourriture.");
                this.setTargetPosition(null); // Réinitialise la cible après l'avoir atteinte
            }
        }
    }

    
    
    
}
