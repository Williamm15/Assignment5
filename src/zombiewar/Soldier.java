package zombiewar;

public class Soldier {
    private int health;
    private int attack;
    private boolean alive;
    private boolean hasPrinted = false;

    public boolean getHasPrinted() {
        return hasPrinted;
    }

    public void setHasPrinted(boolean hasPrinted) {
        this.hasPrinted = hasPrinted;
    }
    public Soldier(){
        health = 100;
        attack = 10;
        alive = true;
    }
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public boolean getAlive(){
        return alive;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    
    public void removeHealth(int health){
        this.health -= health;
    }
}
