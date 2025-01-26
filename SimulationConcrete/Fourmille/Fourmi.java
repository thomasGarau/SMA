package SimulationConcrete.Fourmille;

import Core.Agent;
import Core.Environement;
import Core.Fragment;
import Core.Position;
import Core.Stimulus;

public abstract class Fourmi extends Agent {
    public static final int jaugeMax = 20;
    private int jaugeFaim = 20;
    private int vitesse;
    private Fragment fragment;
    private Position targetPosition;
    
    public Fourmi() {
        super();
    }

    public int getJaugeFaim() {
        return this.jaugeFaim;
    }

    public void setJaugeFaim(int jaugeFaim) {
        this.jaugeFaim = jaugeFaim;
    }

    public int getVitesse() {
        return this.vitesse;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public void inTerrier() {
        if (this.fragment instanceof TerrierFragment) {
            this.manger();
        } else {
            System.out.println("Le fragment n'est pas une instance de TerrierFragment.");
        }
    }

    public void manger(){
        TerrierFragment terrierFragment = (TerrierFragment) this.fragment;

        if (terrierFragment.getNourritureStockee() > 0) {
            int besoin = jaugeMax - this.jaugeFaim;

            if (besoin <= terrierFragment.getNourritureStockee()) {
                this.jaugeFaim += besoin;
                terrierFragment.retirerNourriture(besoin);
            } else {
                this.jaugeFaim += terrierFragment.getNourritureStockee();
                terrierFragment.setNourritureStockee(0);
            }
            System.out.println("La jauge de faim est maintenant à : " + this.jaugeFaim);
        } else {
            System.out.println("Aucune nourriture stockée dans le terrier.");
        }
    }

    public void rentrerTerrier(EnvironnementFourmi environnementFourmi) {
        int currentX = this.getPosition().getPositionX();
        int currentY = this.getPosition().getPositionY();
    
        // Calcule la distance maximale que la fourmi peut parcourir
        int nextX = Math.max(0, currentX - this.getVitesse());
        int nextY = Math.max(0, currentY - this.getVitesse());
        environnementFourmi.MoveAgent(this, nextX, nextY);
    }


    public Position getTargetPosition() {
        return this.targetPosition;
    }

    public void setTargetPosition(Position targetPosition) {
        this.targetPosition = targetPosition;
    }


}
