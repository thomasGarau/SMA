package Core;

import java.util.ArrayList;
import java.util.List;

public class Fragment implements ObservableFragment {

    private Position position;
    private List<Entite> entites =  new ArrayList<Entite>();
    private List<Agent> agents = new ArrayList<Agent>();

    public Fragment(int positionX, int positionY) {
        this.position = new Position(positionX, positionY);
    }

    public Position getPosition() {
        return this.position;
    }

    public List<Entite> getEntites() {
        return this.entites;
    }

    public void addEntite(Entite entite) {
        this.entites.add(entite);
    }   

    public void removeEntite(Entite entite) {
        this.entites.remove(entite);
    }

    public List<Agent> getAgents() {
        return this.agents;
    }

    public void trasmettreStimuli(Stimulus stimulus) {
        for (Agent agent : this.agents) {
            agent.reagir(stimulus);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        if (observer instanceof Agent) {
            this.agents.add((Agent) observer);
        } else {
            throw new IllegalArgumentException("Only Agent instances are supported as observers.");
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observer instanceof Agent) {
            this.agents.remove(observer);
        }
    }

    @Override
    public void notifyObservers(Stimulus stimulus) {
        for (Agent agent : this.agents) {
            agent.reagir(stimulus);
        }
    }







    

}
