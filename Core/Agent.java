package Core;

public abstract class Agent implements Observer {
    
    private Position position;
    private Environement environement;

    public Agent(int positionX, int positionY) {
        this.position = new Position(positionX, positionY);
    }

    public Agent() {
        this.position = new Position(0,0);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position sourcePosition) {
        this.position = sourcePosition;
    }

    public abstract void agir();

    public abstract void seDeplacer(Environement environement);

    public abstract void action(Environement environement);

    @Override
    public abstract void reagir(Stimulus stimulus);
}
