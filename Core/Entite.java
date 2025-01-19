package Core;

public abstract class Entite {
    private Position position;

    public Entite(int positionX, int positionY) {
        this.position = new Position(positionX, positionY);
    }

    public Entite() {
        this.position = new Position(0,0);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract void agir();
    
}