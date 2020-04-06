package machine;

import java.util.Scanner;
enum Coffee{
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int beans;
    private final int money;

    Coffee(int water, int milk, int beans, int money){
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = money;
    }

    public int getWater() {
        return water;
    }
    public int getMilk() {
        return milk;
    }
    public int getBeans() {
        return beans;
    }
    public int getMoney() {
        return money;
    }

}


public class CoffeeMachine {
    static Scanner in = new Scanner(System.in);
    private static int water;
    private static int milk;
    private static int beans;
    private static int money;
    private static int cups;
    private static boolean exit;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.money = 550;
        this.cups = 9;
        this.exit = false;
    }

    public void ControlFlow(){
        while (!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action(in.next());
        }
    }

    private void action(String action){
        switch (action){
            case "buy": buy();
                break;
            case "fill": fill();
                break;
            case "take": take();
                break;
            case "remaining": remaining();
                break;
            case "exit": this.exit = true;
                break;
        }
    }

    private void buy(){
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (in.next()){
            case "1": makeCoffe(Coffee.ESPRESSO);
                break;
            case "2": makeCoffe(Coffee.LATTE);
                break;
            case "3": makeCoffe(Coffee.CAPPUCCINO);
                break;
            case "back":
                break;
            default:
                System.out.println("You entered wron type of coffee!");
        }
    }
    private void fill(){
        System.out.println("\nWrite how many ml of water do you want to add:");
        this.water += in.nextInt();
        System.out.println("Write how many ml of milk do you want do add:");
        this.milk += in.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.beans += in.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += in.nextInt();
        System.out.println("\n");
    }
    private void take(){
        System.out.println("I gave you $" + this.money + "\n");
        this.money = 0;
    }
    private void remaining(){
        System.out.println("\nThe coffee machine has:"
                + "\n" + this.water + " of water"
                + "\n" + this.milk + " of milk"
                + "\n" + this.beans + " of coffee beans"
                + "\n" + this.cups + " of disposable cups"
                + "\n" + this.money + " of money"
                + "\n");
    }

    private void makeCoffe(Coffee coffeType){
        if(this.water < coffeType.getWater())
            System.out.println("Sorry, not enough water!\n");
        else if(this.milk < coffeType.getMilk())
            System.out.println("Sorry, not enough milk!\n");
        else if(this.beans < coffeType.getBeans())
            System.out.println("Sorry, not enough coffe beans!\n");
        else if(cups < 1)
            System.out.println("Sorry, not enough cups!\n");
        else{
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= coffeType.getWater();
            milk -= coffeType.getMilk();
            beans -= coffeType.getBeans();
            cups--;
            money += coffeType.getMoney();
        }
    }
}
