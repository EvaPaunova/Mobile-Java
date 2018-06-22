package evapaunova.example.com.project.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza implements Serializable{

    private String name;
    private double price;
    private ArrayList<String> ingredients;
    private int img;

    public Pizza(String name, double price, ArrayList<String> ingredients, int img) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public List<String> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public int getImg() {
        return img;
    }
}
