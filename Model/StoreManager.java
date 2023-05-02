package Model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StoreManager {
    private static List<Toy> toys = new ArrayList<>();

    public static void addToy(Toy toy) {
        toys.add(toy);
    }

    public static void changeFrequency(int toyId, double newFrequency) {
        Toy toy = findToyById(toyId);
        if (toy != null) {
            toy.setFrequency(newFrequency);
        }
    }
    
    public static Toy chooseToy() {
        if (toys.size() == 0) {
            return null;
        }
            double totalFrequency = 0.0;
        for (Toy toy : toys) {
            totalFrequency += toy.getFrequency();
        }   
        double randomValue = Math.random() * totalFrequency;
        double weightSum = 0.0;
        for (Toy toy : toys) {
            weightSum += toy.getFrequency();
            if (randomValue <= weightSum) {
                toy.decreaseQuantity();
                return toy;
            }
        }
        return null;
    }
    
    private static Toy findToyById(int id) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public static void saveToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write(toy.getName() + System.lineSeparator());
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл.");
        }
    }
}