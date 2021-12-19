package zombiewar;

public class Teacher {
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
    public Teacher(String weapon){
        health = 50;
        attack = 5;
        alive = true;
        this.weapon = weapon;
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
    
    public void removeHealth(int health){
        this.health -= health;
    }
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }
}
