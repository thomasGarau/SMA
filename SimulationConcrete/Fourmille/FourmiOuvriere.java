package SimulationConcrete.Fourmille;

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

    public void rentrerTerrier(EnvironnementFourmi environnementFourmi) {
        int currentX = this.getPosition().getPositionX();
        int currentY = this.getPosition().getPositionY();
    
        // Calcule la distance maximale que la fourmi peut parcourir
        int nextX = Math.max(0, currentX - this.getVitesse());
        int nextY = Math.max(0, currentY - this.getVitesse());
        environnementFourmi.MoveAgent(this, nextX, nextY);
    }

    @Override
    public void action(Environement environement) {
        if(nouritureTransportee +2 > nouritureTransportable){
            if (this.getFragment() instanceof TerrierFragment) {
                this.inTerrier();
            }else{
                EnvironnementFourmi environnementFourmi = (EnvironnementFourmi) environement;
                this.rentrerTerrier(environnementFourmi);
            }
        }
        else{ 
            if (((FragmentInfourmilleEnvironement) this.getFragment()).getNourriture() != null) {
                this.agir();
            }else{
                seDeplacer(environement);
            }
        }
    }

    @Override
    public void inTerrier() {
        super().inTerrier();
        ((TerrierFragment) this.getFragment()).ajouterNourriture(nouritureTransportee);
        nouritureTransportee = 0;
    }

    @Override
    public void agir() {
        
    }

    @Override
    public void seDeplacer(Environement environement) {

    }


    @Override
    public void reagir(Stimulus stimulus) {

    }

}
