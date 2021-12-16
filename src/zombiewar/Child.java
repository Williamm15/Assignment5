package zombiewar;

public class Child {
    private int health;
    private int attack;
    private boolean alive;
    private boolean hasPrinted = false;
    private String weapon;

    public boolean getHasPrinted() {
        return hasPrinted;
    }

    public void setHasPrinted(boolean hasPrinted) {
        this.hasPrinted = hasPrinted;
    }
    public Child(String weapon){ //contructor
        health = 20;
        attack = 2;
        alive = true;
        this.weapon = weapon;
    }
    
    //getter and setters
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public boolean getAlive(){
        return alive;
    }
    public String getWeapon(){
        return weapon;
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
    
    public void removeHealth(int health){//remove health when being attacked method()
        this.health -= health;
    }
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }
}
