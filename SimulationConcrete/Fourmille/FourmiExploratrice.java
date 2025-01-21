package SimulationConcrete.Fourmille;

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
        EnvironnementFourmi environnementFourmi = (EnvironnementFourmi) environement;
        if(this.getJaugeFaim() <= 5){
            this.rentrerTerrier(environnementFourmi);
        }else {
            if (this.getFragment() instanceof FragmentInfourmilleEnvironement) {
                FragmentInfourmilleEnvironement fragmentInfourmilleEnvironement = (FragmentInfourmilleEnvironement) this.getFragment();
                this.agir();
                if(fragmentInfourmilleEnvironement.getNourriture() != null){
                    this.asFindFood = true;
                    this.rentrerTerrier(environnementFourmi);
                }else{
                    this.seDeplacer(environement);
                }
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
        int borneX = Math.min(currentX + this.getVitesse(), EnvironnementFourmi.WIDTH - 1);
        int borneY = Math.min(currentY + this.getVitesse(), EnvironnementFourmi.HEIGHT - 1);
        int nextX = Math.max(0, currentX + (int) (Math.random() * (borneX - currentX + 1)));
        int nextY = Math.max(0, currentY + (int) (Math.random() * (borneY - currentY + 1)));
        //empecher d'aller en 0, 0
        environnementFourmi.MoveAgent(this, nextX, nextY);
        this.agir();
    }

    @Override
    public void reagir(Stimulus stimulus) {

    }
    
    
}
