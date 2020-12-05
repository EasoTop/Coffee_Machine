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

        String action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.nextLine();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String type = scanner.nextLine();
                    if (type.equals("back")) {
                        continue;
                    }
                    buyCoffee(type);
                    break;
                case "fill":
                    fillMachine(scanner);
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showIngredients();
                    break;
                default:
                    break;
            }
        } while (!action.equals("exit"));

    }

    public static void showIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(existWater + " of water");
        System.out.println(existMilk + " of milk");
        System.out.println(existCoffee +" of coffee beans");
        System.out.println(existCups + " of disposable cups");
        System.out.println(existMoney + " of money");
    }

    public static boolean checkResources(String type) {

        int needWater = 0;
        int needMilk = 0;
        int needCoffee = 0;

        switch (type) {
            case "1":
                needWater = 250;
                needMilk = 0;
                needCoffee = 16;
                break;
            case "2":
                needWater = 350;
                needMilk = 75;
                needCoffee = 20;
                break;
            case "3":
                needWater = 200;
                needMilk = 100;
                needCoffee = 12;
                break;
            default:
                break;
        }

        if (existCups == 0) {
            System.out.println("Sorry, not enough cups!");
        } else if (existWater < needWater) {
            System.out.println("Sorry, not enough water!");
        } else if (existMilk < needMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (existCoffee < needCoffee) {
            System.out.println("Sorry, not enough coffee!");
        } else {
            return true;
        }

        return false;
    }

    public static void buyCoffee(String type) {

        if (checkResources(type)) {
            switch (type){
                case "1":
                    existWater -= 250;
                    existCoffee -= 16;
                    existCups--;
                    existMoney += 4;
                    break;
                case "2":
                    existWater -= 350;
                    existMilk -= 75;
                    existCoffee -= 20;
                    existCups--;
                    existMoney += 7;
                    break;
                case "3":
                    existWater -= 200;
                    existMilk -= 100;
                    existCoffee -= 12;
                    existCups--;
                    existMoney += 6;
                    break;
                default:
                    break;
            }
            System.out.println("I have enough resources, making you a coffee!");
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
