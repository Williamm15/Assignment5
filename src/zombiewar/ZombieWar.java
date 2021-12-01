package zombiewar;

import java.lang.Math;
public class ZombieWar {
    
    // Contains all survivor and zombie objects
    public static Child[] childArray;
    public static Tank[] tankArray;
    public static CommonInfected[] commonInfectedArray;
    public static Teacher[] teacherArray;
    public static Soldier[] soldierArray; 
    
    // number of suvivors and zombies
    public static int survivorCount = 0;
    public static int zombieCount = 0; 
    
    
    public static void main(String[] args) {
        populateArray();
        System.out.println("We have "+ survivorCount + " survivors trying to make it to safety.\nBut there are " + zombieCount + " zombies waitiing for them.");
        
        characterAttack();
        
        //iterate through each survivor loop to find how many survivors made it to safety
        for(int i = 0; i < childArray.length; i++){
            if(childArray[i].getAlive() == false){
                survivorCount --;
            }
        }
        
        for(int i = 0; i < teacherArray.length; i++){
            if(teacherArray[i].getAlive() == false){
                survivorCount --;
            }
        }
        
        for(int i = 0; i < soldierArray.length; i++){
            if(soldierArray[i].getAlive() == false){
                survivorCount --;
            }
        }
        
        System.out.println("It seems that " + survivorCount + " survivors have made it to safety.");
        
    }//end of main
    
   public static boolean isAlive(int health){
       if(health <= 0){
           return false; 
       }
       else{
           return true;
       }
   }//end of isAlive()
   
   public static boolean survivorAttackZombie(){ //survivors attacking each zombie method()
    boolean anyCharacterAlive = false; 
    
    for(int i = 0; i < teacherArray.length; i++){
        for(int j = 0; j < commonInfectedArray.length; j++){
           if(teacherArray[i].getAlive()){
                    commonInfectedArray[j].removeHealth(teacherArray[i].getAttack());// Removing attack amount from health using removeHealth() method 
                    boolean aliveCheck = isAlive(commonInfectedArray[j].getHealth()); // check if any zombies are alive 
                    commonInfectedArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
           }//end of if
        }
            for(int j = 0; j < tankArray.length; j++){
                if(teacherArray[i].getAlive()){
                    tankArray[j].removeHealth(teacherArray[i].getAttack());
                    boolean aliveCheck = isAlive(tankArray[j].getHealth());
                    tankArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                }//end of if 
            }
        }//end of teacher attacking 
    
        for(int i = 0; i < soldierArray.length; i++){
            for(int j = 0; j < commonInfectedArray.length; j++){
                if(soldierArray[i].getAlive()){
                    commonInfectedArray[j].removeHealth(soldierArray[i].getAttack());
                    boolean aliveCheck = isAlive(commonInfectedArray[j].getHealth());
                    commonInfectedArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                }//end of if
            }
            for(int j = 0; j < tankArray.length; j++){
                if(soldierArray[i].getAlive()){
                    tankArray[j].removeHealth(soldierArray[i].getAttack());
                    boolean aliveCheck = isAlive(tankArray[j].getHealth());
                    tankArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                }//end of if 
            }
        }//end of soldier attacking
        
        for(int i = 0; i < childArray.length; i++){
            for(int j = 0; j < commonInfectedArray.length; j++){
                if(childArray[i].getAlive()){
                    commonInfectedArray[j].removeHealth(childArray[i].getAttack());
                    boolean aliveCheck = isAlive(commonInfectedArray[j].getHealth());
                    commonInfectedArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                }//end of if
            }
            for(int j = 0; j < tankArray.length; j++){
                if(childArray[i].getAlive()){
                    tankArray[j].removeHealth(childArray[i].getAttack());
                    boolean aliveCheck = isAlive(tankArray[j].getHealth());
                    tankArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                }//end of if 
            }
        }//end of child attacking 

        //return boolean to see if all zombies are dead, if any are alive, continue loop 
        return anyCharacterAlive; 
   }//end of survivor Attacking zombies 
   
   public static boolean zombieAttackSurvivor(){ //zombies attacking every survivor method 
       boolean anyCharacterAlive = false; 
        for(int i = 0; i < tankArray.length; i++){
            for(int j = 0; j < teacherArray.length; j++){
                teacherArray[j].removeHealth(tankArray[i].getAttack());
                boolean aliveCheck = isAlive(teacherArray[j].getHealth());
                teacherArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
            }
            
            for(int j = 0; j < soldierArray.length; j++){
                soldierArray[j].removeHealth(tankArray[i].getAttack());
                boolean aliveCheck = isAlive(soldierArray[j].getHealth());
                soldierArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
            }
            
            for(int j = 0; j < childArray.length; j++){
                childArray[j].removeHealth(tankArray[i].getAttack());
                boolean aliveCheck = isAlive(childArray[j].getHealth());
                childArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
            }
            
        }//end of tank attacking survivors 
        
        for(int i = 0; i < commonInfectedArray.length; i++){
                for(int j = 0; j < teacherArray.length; j++){
                teacherArray[j].removeHealth(commonInfectedArray[i].getAttack());// Removing attack amount from health
                boolean aliveCheck = isAlive(teacherArray[j].getHealth());
                teacherArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
            }
            
            for(int j = 0; j < soldierArray.length; j++){
                soldierArray[j].removeHealth(commonInfectedArray[i].getAttack());
                boolean aliveCheck = isAlive(soldierArray[j].getHealth());
                soldierArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
            }
            
            for(int j = 0; j < childArray.length; j++){
                childArray[j].removeHealth(commonInfectedArray[i].getAttack());
                boolean aliveCheck = isAlive(childArray[j].getHealth());
                childArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
            }
        }
        
        return anyCharacterAlive;
   }//end of zombie attacking survivors
    
    public static void characterAttack(){
        int fightOrder =  (int)(Math.random() * 2); //picks either zombie or survivor to go first, random num of 0 or 1
        
        boolean anyAlive = true;//if any are alive from each group continue loop until one group dies first 
        
        while(anyAlive){ //while runs until all zombies or humans are dead
            if (fightOrder == 0){
                anyAlive = survivorAttackZombie();//anyAlive is the boolean return from method 
                fightOrder = 1; // changing fightOrder so zombies attack next
            }
            else{

                anyAlive = zombieAttackSurvivor();
                fightOrder = 0; // changing fightOrder so humans attack next
            }//end of else 
            
        }//end of while loop 
    }//end of characterAttack() method 
    
    public static void populateArray(){
        // generates the size of the array that will hold zombie and survivor objects 
        int[] randNums = new int[5];
        for(int i = 0; i < 5; i++){
            int randomSize = (int)(Math.random()*10);
            randNums[i] = randomSize;
        }//end of for loop
        
        // assigning sizes
        childArray = new Child[randNums[0]];
        tankArray = new Tank[randNums[1]];
        commonInfectedArray = new CommonInfected[randNums[2]];
        teacherArray = new Teacher[randNums[3]];
        soldierArray = new Soldier[randNums[4]];
        
        for(int i = 0; i < 10; i++){
            if(i < childArray.length){
                Child child = new Child();
                childArray[i] = child; //add in a child into array 
            }
            if(i < teacherArray.length){
                Teacher teacher = new Teacher();
                teacherArray[i] = teacher;//add in a teacher into array 
            }
            if(i < soldierArray.length){
                Soldier soldier = new Soldier();
                soldierArray[i] = soldier;//add in a soldier into array 
            }
            if(i < commonInfectedArray.length){
                CommonInfected infected = new CommonInfected();
                commonInfectedArray[i] = infected; //add in a CommonInfected object array 
            }
            if(i < tankArray.length){
                Tank tank = new Tank();
                tankArray[i] = tank; //add in a tank object into array 
            }
        }//end of for loop 
       
        //assign values to each count 
        survivorCount = childArray.length + teacherArray.length + soldierArray.length;
        zombieCount = commonInfectedArray.length + tankArray.length; 
        
    }//end of populateArray() method
    
    
}//end of ZombieWar class
