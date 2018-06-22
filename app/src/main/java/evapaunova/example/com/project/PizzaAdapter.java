package evapaunova.example.com.project;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import evapaunova.example.com.project.model.Pizza;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private DecimalFormat precision = new DecimalFormat("0.00");

    private ArrayList<Pizza> pizzas;
    private Activity activity;

    PizzaAdapter(ArrayList<Pizza> pizzas, Activity activity){
        this.pizzas = pizzas;
        this.activity = activity;
    }

    @Override
    public PizzaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(activity);
        View row = li.inflate(R.layout.pizza_row, parent, false);
        return new PizzaViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PizzaViewHolder holder, int position) {
        final Pizza pizza = pizzas.get(position);
        final Bundle bundle = new Bundle();
        bundle.putSerializable("pizza",pizza);
        holder.name.setText(pizza.getName());
        holder.price.setText(precision.format(pizza.getPrice())+ " " + "BGN");
        StringBuilder ingred = new StringBuilder();
        for(int i = 0; i < pizza.getIngredients().size(); i++){
            if(i != pizza.getIngredients().size() - 1){
                ingred.append(pizza.getIngredients().get(i) + ", ");
            }
            else{
                ingred.append(pizza.getIngredients().get(i));
            }
        }
        holder.ingredients.setText(ingred.toString());
        holder.image.setImageResource(pizza.getImg());

        holder.orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Добави в количката " + pizza.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment details = new ProductFragment();
                details.setArguments(bundle);
                FragmentManager fm = ((AppCompatActivity) activity).getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                fm.popBackStack("pizza",FragmentManager.POP_BACK_STACK_INCLUSIVE);
                if (activity.findViewById(R.id.parent_view_p) != null){
                    transaction
                            .replace(R.id.parent_view_p, details, "fr");
                            //.addToBackStack("pizza")
                            //.commit();
                }
                else if(activity.findViewById(R.id.parent_view_l) != null){
                    Fragment datailsFragment = fm.findFragmentByTag("det");
                    if(datailsFragment == null) {
                        transaction
                                .add(R.id.parent_view_l, details, "det");
                    }
                    else{
                        transaction
                                .remove(datailsFragment)
                                .add(R.id.parent_view_l, details, "det");
                    }

                }
                transaction
                    .addToBackStack("pizza")
                    .commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return pizzas.size();
    }

    class PizzaViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        TextView price;
        TextView ingredients;
        ImageButton orderButton;
        Button infoButton;

        PizzaViewHolder(View v){
            super(v);
            this.image = v.findViewById(R.id.pizza_image);
            this.name = v.findViewById(R.id.pizza_name);
            this.price = v.findViewById(R.id.pizza_price);
            this.ingredients = v.findViewById(R.id.pizza_ingredients);
            this.orderButton = v.findViewById(R.id.button_order);
            this.infoButton = v.findViewById(R.id.pizza_dough);

        }


    }
}
