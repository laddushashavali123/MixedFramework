package us.st.tasks;

import java.util.Locale;

interface Chewable { }
interface Eatable extends Chewable{ }
class Food implements Eatable { }
class Meat extends Food { }
class Gum implements Chewable{ }

public class JPTest {

	public static void main(String[] args) 
    {     
        Food food = new Food();
        Meat meat = new Meat();
        Gum gum   = new Gum();   
        System.out.print(food instanceof Chewable);
        System.out.print(meat instanceof Eatable);
        System.out.print(gum instanceof Eatable);
        System.out.print(gum instanceof Chewable);
    }
}


