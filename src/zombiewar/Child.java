package zombiewar;

public class Child {
    private int health;
    private int attack;
    private String type;
    private boolean alive;
    
    public Child(){ //contructor
        health = 20;
        attack = 2;
        type = "survivor";
        alive = true;
    }
    
    //getter and setters
    public int getHealth(){
        return health;
    }
    public int getAttack(){
        return attack;
    }
    public String getType(){
        return type;
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
    public void setType(String type){
        this.type = type;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    
    public void removeHealth(int health){//remove health when being attacked method()
        this.health -= health;
    }
}
