package evapaunova.example.com.project;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import evapaunova.example.com.project.model.Pizza;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {

    private DecimalFormat precision = new DecimalFormat("0.00");


    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_product, container, false);
        Pizza pizza = (Pizza)getArguments().getSerializable("pizza");

        TextView name = root.findViewById(R.id.pizza_name);
        name.setText(pizza.getName());

        ImageView image = root.findViewById(R.id.pizza_image);
        image.setImageResource(pizza.getImg());

        TextView ingredients = root.findViewById(R.id.pizza_ingredients);
        StringBuilder ingred = new StringBuilder();
        for(int i = 0; i < pizza.getIngredients().size(); i++){
            if(i != pizza.getIngredients().size() - 1){
                ingred.append(pizza.getIngredients().get(i) + ", ");
            }
            else{
                ingred.append(pizza.getIngredients().get(i));
            }
        }
        ingredients.setText(ingred.toString());

        TextView price = root.findViewById(R.id.pizza_price);
        price.setText(precision.format(pizza.getPrice()) + " " + "BGN");

        return root;
    }

}
