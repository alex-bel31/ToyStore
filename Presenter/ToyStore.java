package Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.Toy;

public class ToyStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Toy> chosenToys = new ArrayList<>();
        
        while (true) {
            System.out.println("Выберите команду:");
            System.out.println("1 - добавить игрушку");
            System.out.println("2 - изменить вес игрушки");
            System.out.println("3 - выбрать призовую игрушку");
            System.out.println("4 - выход");

            int commandNumber = scanner.nextInt();
            scanner.nextLine();

            switch (commandNumber) {
                case 1:
                    System.out.println("Введите ID, название, количество и вес игрушки:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    int quantity = scanner.nextInt();
                    double frequency = scanner.nextDouble();
                    Toy toy = new Toy(id, name, quantity, frequency);
                    Command addCommand = new AddToyCommand(toy);
                    addCommand.execute();
                break;

                case 2:
                    System.out.println("Введите ID игрушки и новый вес:");
                    int toyId = scanner.nextInt();
                    double newFrequency = scanner.nextDouble();
                    Command changeCommand = new ChangeFrequencyCommand(toyId, newFrequency);
                    changeCommand.execute();
                break;

                case 3:
                    System.out.println("Введите количество призовых игрушек:");
                    int numToys = scanner.nextInt();
                    Command chooseCommand = new ChooseToyCommand(chosenToys, numToys);
                    chooseCommand.execute();
                break;

                case 4:
                    System.out.println("Выход из программы...");
                    System.exit(0);
                break;
            
            }
        }
    }
}