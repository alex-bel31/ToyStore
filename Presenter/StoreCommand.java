package Presenter;

import java.util.List;
import Model.StoreManager;
import Model.Toy;

class AddToyCommand extends Command {
    private Toy toy;

    public AddToyCommand(Toy toy) {
        this.toy = toy;
    }

    @Override
    void execute() {
        StoreManager.addToy(toy);
        System.out.println("Игрушка " + toy.getName() + " добавлена.");
    }
}

class ChangeFrequencyCommand extends Command {
    private int toyId;
    private double newFrequency;

    public ChangeFrequencyCommand(int toyId, double newFrequency) {
        this.toyId = toyId;
        this.newFrequency = newFrequency;
    }

    @Override
    void execute() {
        StoreManager.changeFrequency(toyId, newFrequency);
        System.out.println("Вес игрушки с id " + toyId + " изменен на " + newFrequency + "%");
    }
}

class ChooseToyCommand extends Command {
    private List<Toy> chosenToys;
    private int numToys;

    public ChooseToyCommand(List<Toy> chosenToys, int numToys) {
        this.chosenToys = chosenToys;
        this.numToys = numToys;
    }

    @Override
    void execute() {
        for (int i = 0; i < numToys; i++) {
            Toy toy = StoreManager.chooseToy();
            if (toy != null) {
                chosenToys.add(toy);
                StoreManager.saveToFile(toy);
                System.out.println("Призовая игрушка: " + toy.getName());
            } else {
                System.out.println("Игрушки закончились.");
                break;
            }
        }
    }
}