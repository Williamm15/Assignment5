package zombiewar;

import java.lang.Math;
public class ZombieWar {
    
    // Contains all survivor and zombie objects
    public static Object[] character;
    
    public static void main(String[] args) {
        // generates the size of the array that will hold zombie and survivor objects 
        int randomSize = 1 + (int) Math.random()*20;
        // assigning size
        character = new Object[randomSize];
        for (int i = 0; i < character.length; i++){
            // number results in either a survivor or zombie being generated
            int characterPick = (int) Math.random()*1;
            if(characterPick == 0){
                // if a zombie is generated, this number picks what kind of zombie
                int zombiePick = (int) Math.random()*1;
                if(zombiePick == 0){
                    CommonInfected infected = new CommonInfected();
                }
                else{
                    Tank tank = new Tank();
                }
            }
            else{
                // if a survivor is genderated, this number picks what type of survivor
                int survivorPick = (int) Math.random()*2;
                if(survivorPick == 0){
                    Child child = new Child();
                }
                else if(survivorPick == 2){
                    Soldier soldier = new Soldier();
                }
                else{
                    Teacher teacher = new Teacher();
                }
            }
        }
    }
}
