package SimulationConcrete.Fourmille;

import Core.Agent;
import Core.Fragment;
import Core.Stimulus;

public abstract class Fourmi extends Agent {
    private int jaugeFaim = 10;
    private int vitesse;
    private Fragment fragment;
    
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

    public abstract void inTerrier();

}
