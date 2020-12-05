package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private static int existWater = 400;
    private static int existMilk = 540;
    private static int existCoffee = 120;
    private static int existCups = 9;
    private static int existMoney = 550;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showIngredients();

        System.out.println("Write action (buy, fill, take): ");

        switch (scanner.nextLine()) {
            case "buy":
                buyCoffee(scanner.nextInt());
                showIngredients();
                break;
            case "fill":
                fillMachine(scanner);
                showIngredients();
                break;
            case "take":
                takeMoney();
                showIngredients();
                break;
            default:
                break;
        }
    }

    public static void showIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(existWater + " of water");
        System.out.println(existMilk + " of milk");
        System.out.println(existCoffee +" of coffee beans");
        System.out.println(existCups + " of disposable cups");
        System.out.println(existMoney + " of money");
    }

    public static void buyCoffee(int type) {
        switch (type){
            case 1:
                existWater -= 250;
                existCoffee -= 16;
                existCups--;
                existMoney += 4;
                break;
            case 2:
                existWater -= 350;
                existMilk -= 75;
                existCoffee -= 20;
                existCups--;
                existMoney += 7;
                break;
            case 3:
                existWater -= 200;
                existMilk -= 100;
                existCoffee -= 12;
                existCups--;
                existMoney += 6;
                break;
            default:
                break;
        }
    }

    public static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water do you want to add: ");
        existWater += scanner.nextInt();

        System.out.println("Write how many ml of milk do you want to add:");
        existMilk += scanner.nextInt();

        System.out.println("Write how many grams of coffee beans do you want to add:");
        existCoffee += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        existCups += scanner.nextInt();
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + existMoney);
        existMoney = 0;
    }
}
