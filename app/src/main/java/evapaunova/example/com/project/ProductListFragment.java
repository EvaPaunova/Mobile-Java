package evapaunova.example.com.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import evapaunova.example.com.project.model.Pizza;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {


    RecyclerView recyclerView;
    RecyclerView iconView;
    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_product_list, container, false);

        recyclerView = root.findViewById(R.id.pizzaList);

        ArrayList<Pizza> pizzas = new ArrayList<>();

        ArrayList<String> ingDiablo = new ArrayList<>();
        ingDiablo.add("Зехтин, шунка, гъби печурки, люта чушка, кашкавал или моцарела, доматен сос, тесто, риган");
        pizzas.add(new Pizza("Диабло", 8.90, ingDiablo, R.drawable.diablo));

        ArrayList<String> ingKapreze = new ArrayList<>();
        ingKapreze.add("Чери домати, кашкавал или моцарела, босилек, шунка, чесън, доматен сос, тесто");
        pizzas.add(new Pizza("Капрезе", 9.80, ingKapreze, R.drawable.kapreze));

        ArrayList<String> ingKatana = new ArrayList<>();
        ingKatana.add("Шунка, бекон, кашкавал или моцарела, маслини без костилка и доматен сос, тесто, риган");
        pizzas.add(new Pizza("Катано", 11.80, ingKatana, R.drawable.katana));

        ArrayList<String> ingMargarita = new ArrayList<>();
        ingMargarita.add("Зехтин, кашкавал или моцарела, доматен сос, тесто, риган ");
        pizzas.add(new Pizza("Маргарита", 5.90, ingMargarita, R.drawable.margarita));

        ArrayList<String> ingPeperoni = new ArrayList<>();
        ingPeperoni.add("Салам пипероне, кашкавал или моцарела, доматен сос, тесто");
        pizzas.add(new Pizza("Пеперони", 9.90, ingPeperoni, R.drawable.peperoni));

        ArrayList<String> ingRatatui = new ArrayList<>();
        ingRatatui.add("Червен лук, червени чушки, маслини обезкостени, сирене, домат, кашкавал или моцарела, доматен сос, риган, тесто");
        pizzas.add(new Pizza("Рататуй", 9.90, ingRatatui, R.drawable.ratatui));

        ArrayList<String> ingRomana = new ArrayList<>();
        ingRomana.add("Крем филаделфия, шунка, кашкавал или моцарела, чери домати, прошуто, доматен сос, тесто, пресен босилек");
        pizzas.add(new Pizza("Романа", 14.50, ingRomana, R.drawable.romana));

        ArrayList<String> ingValtelina = new ArrayList<>();
        ingValtelina.add("Крем филаделфия, сметана, копа, кашкавал или моцарела, пармезан, чери домати и пресен босилек");
        pizzas.add(new Pizza("Валтелина", 19.90, ingValtelina, R.drawable.valtelina));


        recyclerView.setAdapter(new PizzaAdapter(pizzas, getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        iconView = root.findViewById(R.id.categoryList);
        ArrayList<Integer> ikonki = new ArrayList<>();
        ikonki.add(R.drawable.taco);
        ikonki.add(R.drawable.coctail);
        ikonki.add(R.drawable.pizza);
        ikonki.add(R.drawable.soup);
        ikonki.add(R.drawable.eggs);
        ikonki.add(R.drawable.dish);
        ikonki.add(R.drawable.cactus);
        ikonki.add(R.drawable.duner);

        iconView.setAdapter(new IconAdapter(ikonki,getContext()));
        iconView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));

        return root;
    }

}
