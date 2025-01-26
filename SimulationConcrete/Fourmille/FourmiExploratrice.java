package SimulationConcrete.Fourmille;

import javax.swing.text.Position;

import Core.Environement;
import Core.Fragment;
import Core.Stimulus;

public class FourmiExploratrice extends Fourmi{
    private boolean asFindFood = false;

    public FourmiExploratrice() {
        super();
        this.setVitesse(2 + (int) Math.random() * 3);
        
    }
    
    @Override
    public void action(Environement environement) {
        System.out.println("action exploratrice");
        EnvironnementFourmi environnementFourmi = (EnvironnementFourmi) environement;
        if(this.getJaugeFaim() <= 5){
            System.out.println("rentrer");
            this.rentrerTerrier(environnementFourmi);
        }else {
            if (this.getFragment() instanceof FragmentInfourmilleEnvironement) {
                System.out.println("instance of");
                FragmentInfourmilleEnvironement fragmentInfourmilleEnvironement = (FragmentInfourmilleEnvironement) this.getFragment();
                this.agir();
                if(fragmentInfourmilleEnvironement.getNourriture() != null){
                    System.out.println("as find found");
                    this.asFindFood = true;
                    this.rentrerTerrier(environnementFourmi);
                }else{
                    System.out.println("continue explorer");
                    this.seDeplacer(environement);
                }
            }else{
                System.out.println("deplacement pas instance of ");
                this.seDeplacer(environement);
            }
        }
    }

    @Override
    public void rentrerTerrier(EnvironnementFourmi environement){
        super.rentrerTerrier(environement);
        if(this.asFindFood){
            if(this.getFragment() instanceof FragmentInfourmilleEnvironement){
                FragmentInfourmilleEnvironement fragmentInfourmilleEnvironement = (FragmentInfourmilleEnvironement) this.getFragment();
                Pheromone pheromone = null;
                if(this.asFindFood){
                    pheromone = new PheromoneNourriture();
                    
                }else {
                    pheromone = new PheromoneCaseVide();
                }
                fragmentInfourmilleEnvironement.setPheromone(pheromone);
            }
        }
    }


    @Override
    public void agir() {
        if(this.getFragment() instanceof FragmentInfourmilleEnvironement){
            FragmentInfourmilleEnvironement fragmentInfourmilleEnvironement = (FragmentInfourmilleEnvironement) this.getFragment();
            Pheromone pheromone = null;
            if(this.asFindFood){
                pheromone = new PheromoneNourriture();
                
            }else {
                pheromone = new PheromoneCaseVide();
            }
            fragmentInfourmilleEnvironement.setPheromone(pheromone);
        }
    }

    @Override
    public void seDeplacer(Environement environement) {
        EnvironnementFourmi environnementFourmi = (EnvironnementFourmi) environement;
        int currentX = this.getPosition().getPositionX();
        int currentY = this.getPosition().getPositionY();
    
        // Déplacement en spirale : alternance de directions
        int[][] directions = {
            {0, 1},  // Droite
            {1, 0},  // Bas
            {0, -1}, // Gauche
            {-1, 0}  // Haut
        };
    
        // Sélection aléatoire d'une direction
        int directionIndex = (int) (Math.random() * directions.length);
        int[] direction = directions[directionIndex];
    
        // Calcul de la nouvelle position
        int nextX = Math.max(0, Math.min(currentX + direction[0] * this.getVitesse(), EnvironnementFourmi.WIDTH - 1));
        int nextY = Math.max(0, Math.min(currentY + direction[1] * this.getVitesse(), EnvironnementFourmi.HEIGHT - 1));
    
        // Empêcher un déplacement constant vers le terrier (0, 0)
        if (nextX == 0 && nextY == 0) {
            directionIndex = (directionIndex + 1) % directions.length; // Change de direction
            direction = directions[directionIndex];
            nextX = Math.max(0, Math.min(currentX + direction[0] * this.getVitesse(), EnvironnementFourmi.WIDTH - 1));
            nextY = Math.max(0, Math.min(currentY + direction[1] * this.getVitesse(), EnvironnementFourmi.HEIGHT - 1));
        }
    
        // Déplacement de la fourmi
        environnementFourmi.MoveAgent(this, nextX, nextY);
        this.agir();
        System.out.println("Fourmi exploratrice se déplace vers " + nextX + ", " + nextY);
    }
    

    @Override
    public void reagir(Stimulus stimulus) {
        if (stimulus instanceof StimulusPheromone) {
            StimulusPheromone pheromoneStimulus = (StimulusPheromone) stimulus;
            Position sourcePosition = (Position) pheromoneStimulus.getSourcePosition();
            System.out.println("Fourmi exploratrice détecte une phéromone en " +
                               ((Core.Position) sourcePosition).getPositionX() + ", " + ((Core.Position) sourcePosition).getPositionY());
    
        }
    }
    
    
    
    
    
}
