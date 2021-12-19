package zombiewar;

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
        System.out.println("We have "+ survivorCount + " survivors trying to make it to safety (" 
                + childArray.length + " children," 
                + teacherArray.length + " teachers,"
                + soldierArray.length + " soldiers)."
                + "\nBut there are " + zombieCount + " zombies waitiing for them ("
                + commonInfectedArray.length + " common infected, "
                + tankArray.length + " tanks).");
        
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
        if (survivorCount == 0){ // Checks if survivorCount is 0. Changes output if so
            System.out.println("None of the survivors made it.");
        }
        else{
            System.out.println("It seems that " + survivorCount + " survivors have made it to safety.");
        }
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
        String[] weaponStats = teacherArray[i].getWeapon().split("%"); // splitting to get indivitual weapon name, damage, and accuracy
        int damage = Integer.parseInt(weaponStats[1]); // assigning damage to int
        int accuracy = Integer.parseInt(weaponStats[2]); // assigning accuracy to int
        teacherArray[i].setAttack(teacherArray[i].getAttack() + damage); // adding weapon damange to survivor base class damage
        for(int j = 0; j < commonInfectedArray.length; j++){
           int hitCheck =  (int)(Math.random() * 100); // random number is used to check if weapon hits or misses
           if(teacherArray[i].getAlive()){
                    if (hitCheck < accuracy){ // checking if the random num is less than the weapon accuracy
                        commonInfectedArray[j].removeHealth(teacherArray[i].getAttack());
                    }
                    boolean aliveCheck = isAlive(commonInfectedArray[j].getHealth()); // check if any zombies are alive 
                    commonInfectedArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                    else if (commonInfectedArray[j].getHasPrinted() == false){ // getHasPrinted() method toggles if death has been output
                        System.out.println("Teacher " + i + " killed common infected " + j + " with a " + weaponStats[0] + ".");
                        commonInfectedArray[j].setHasPrinted(true);
                    }
           }//end of if
        }
            for(int j = 0; j < tankArray.length; j++){
                int hitCheck =  (int)(Math.random() * 100); // random number is used to check if weapon hits or misses
                if(teacherArray[i].getAlive()){
                    if (hitCheck < accuracy){ // checking if the random num is less than the weapon accuracy
                        tankArray[j].removeHealth(teacherArray[i].getAttack());
                    }
                    boolean aliveCheck = isAlive(tankArray[j].getHealth());
                    tankArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                    else if (tankArray[j].getHasPrinted() == false){
                        System.out.println("Teacher " + i + " killed tank " + j + " with a " + weaponStats[0] + ".");
                        tankArray[j].setHasPrinted(true);
                    }
                }//end of if 
            }
        }//end of teacher attacking 
        for(int i = 0; i < soldierArray.length; i++){
            String[] weaponStats = soldierArray[i].getWeapon().split("%"); // splitting to get indivitual weapon name, damage, and accuracy
            int damage = Integer.parseInt(weaponStats[1]); // assigning damage to int
            int accuracy = Integer.parseInt(weaponStats[2]); // assigning accuracy to int
            soldierArray[i].setAttack(soldierArray[i].getAttack() + damage); // adding weapon damange to survivor base class damage
            for(int j = 0; j < commonInfectedArray.length; j++){
                int hitCheck =  (int)(Math.random() * 100); // random number is used to check if weapon hits or misses
                if(soldierArray[i].getAlive()){
                    if (hitCheck < accuracy){ // checking if the random num is less than the weapon accuracy
                        commonInfectedArray[j].removeHealth(soldierArray[i].getAttack());
                    }
                    boolean aliveCheck = isAlive(commonInfectedArray[j].getHealth());
                    commonInfectedArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                    else if (commonInfectedArray[j].getHasPrinted() == false){
                        System.out.println("Soldier " + i + " killed common infected " + j + " with a " + weaponStats[0] + ".");
                        commonInfectedArray[j].setHasPrinted(true);
                    }
                }//end of if
            }
            for(int j = 0; j < tankArray.length; j++){
                int hitCheck =  (int)(Math.random() * 100); // random number is used to check if weapon hits or misses
                if(soldierArray[i].getAlive()){
                    if (hitCheck < accuracy){ // checking if the random num is less than the weapon accuracy
                        tankArray[j].removeHealth(soldierArray[i].getAttack());
                    }
                    boolean aliveCheck = isAlive(tankArray[j].getHealth());
                    tankArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                    else if (tankArray[j].getHasPrinted() == false){
                        System.out.println("Soldier " + i + " killed tank " + j + " with a " + weaponStats[0] + ".");
                        tankArray[j].setHasPrinted(true);
                    }
                }//end of if 
            }
        }//end of soldier attacking
        for(int i = 0; i < childArray.length; i++){
            String[] weaponStats = childArray[i].getWeapon().split("%"); // splitting to get indivitual weapon name, damage, and accuracy
            int damage = Integer.parseInt(weaponStats[1]); // assigning damage to int
            int accuracy = Integer.parseInt(weaponStats[2]); // assigning accuracy to int
            childArray[i].setAttack(childArray[i].getAttack() + damage); // adding weapon damange to survivor base class damage
            for(int j = 0; j < commonInfectedArray.length; j++){
                int hitCheck =  (int)(Math.random() * 100); // random number is used to check if weapon hits or misses
                if(childArray[i].getAlive()){
                    if (hitCheck < accuracy){ // checking if the random num is less than the weapon accuracy
                        commonInfectedArray[j].removeHealth(childArray[i].getAttack());
                    }
                    boolean aliveCheck = isAlive(commonInfectedArray[j].getHealth());
                    commonInfectedArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                    else if (commonInfectedArray[j].getHasPrinted() == false){
                        System.out.println("Child " + i + " killed common infected " + j + " with a " + weaponStats[0] + ".");
                        commonInfectedArray[j].setHasPrinted(true);
                    }
                }//end of if
            }
            for(int j = 0; j < tankArray.length; j++){
                int hitCheck =  (int)(Math.random() * 100); // random number is used to check if weapon hits or misses
                if(childArray[i].getAlive()){
                    if (hitCheck < accuracy){ // checking if the random num is less than the weapon accuracy
                        tankArray[j].removeHealth(childArray[i].getAttack());
                    }
                    boolean aliveCheck = isAlive(tankArray[j].getHealth());
                    tankArray[j].setAlive(aliveCheck);
                    if(aliveCheck == true){
                        anyCharacterAlive = true;
                    }
                    else if (tankArray[j].getHasPrinted() == false){
                        System.out.println("Child " + i + " killed tank " + j + " with a " + weaponStats[0] + ".");
                        tankArray[j].setHasPrinted(true);
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
                else if (teacherArray[j].getHasPrinted() == false){
                        System.out.println("Tank " + i + " killed teacher " + j);
                        teacherArray[j].setHasPrinted(true);
                }
            }
            for(int j = 0; j < soldierArray.length; j++){
                soldierArray[j].removeHealth(tankArray[i].getAttack());
                boolean aliveCheck = isAlive(soldierArray[j].getHealth());
                soldierArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
                else if (soldierArray[j].getHasPrinted() == false){
                        System.out.println("Tank " + i + " killed soldier " + j);
                        soldierArray[j].setHasPrinted(true);
                }
            }
            for(int j = 0; j < childArray.length; j++){
                childArray[j].removeHealth(tankArray[i].getAttack());
                boolean aliveCheck = isAlive(childArray[j].getHealth());
                childArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
                else if (childArray[j].getHasPrinted() == false){
                        System.out.println("Tank " + i + " killed child " + j);
                        childArray[j].setHasPrinted(true);
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
                else if (teacherArray[j].getHasPrinted() == false){
                        System.out.println("Common infected " + i + " killed teacher " + j);
                        teacherArray[j].setHasPrinted(true);
                }
            }
            for(int j = 0; j < soldierArray.length; j++){
                soldierArray[j].removeHealth(commonInfectedArray[i].getAttack());
                boolean aliveCheck = isAlive(soldierArray[j].getHealth());
                soldierArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
                else if (soldierArray[j].getHasPrinted() == false){
                        System.out.println("Common infected " + i + " killed soldier " + j);
                        soldierArray[j].setHasPrinted(true);
                }
            }
            for(int j = 0; j < childArray.length; j++){
                childArray[j].removeHealth(commonInfectedArray[i].getAttack());
                boolean aliveCheck = isAlive(childArray[j].getHealth());
                childArray[j].setAlive(aliveCheck);
                if(aliveCheck == true){
                    anyCharacterAlive = true;
                }
                else if (childArray[j].getHasPrinted() == false){
                    System.out.println("Common infected " + i + " killed child " + j);
                    childArray[j].setHasPrinted(true);
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
                String weapon = weaponRNG(); // method is used for pickign a random weapon
                Child child = new Child(weapon); // the returned weapon is passed into object
                childArray[i] = child; //add in a child into array 
            }
            if(i < teacherArray.length){
                String weapon = weaponRNG(); // method is used for pickign a random weapon
                Teacher teacher = new Teacher(weapon);
                teacherArray[i] = teacher;//add in a teacher into array 
            }
            if(i < soldierArray.length){
                String weapon = weaponRNG(); // method is used for pickign a random weapon
                Soldier soldier = new Soldier(weapon);
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
    
    public static String weaponRNG(){
        int randomWeapon = (int)(Math.random()*7);
            switch(randomWeapon){
                case 0:
                    return "Shotgun%25%50"; // Format is WeaponName, Damage, Accuracy
                case 1:
                    return "SMG%15%75";
                case 2:
                    return "AR%20%85";
                case 3:
                    return "Pistol%10%80";
                case 4:
                    return "Axe%10%95";
                case 5:
                    return "Crowbar%5%95";
                case 6:
                    return "Frying Pan%15%100";
            }
        return "Null";
    }
    
}//end of ZombieWar class