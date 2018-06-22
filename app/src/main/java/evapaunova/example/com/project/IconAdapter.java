package evapaunova.example.com.project;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.IconViewHolder> {

    private ArrayList<Integer> icons;
    private Context context;

    IconAdapter(ArrayList<Integer> icons, Context context){
        this.icons = icons;
        this.context = context;
    }

    @Override
    public IconViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View item = li.inflate(R.layout.icon_image, parent, false);
        return new IconViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final IconViewHolder holder, int position) {
        final int iconNumber = icons.get(position);
        holder.icon.setImageResource(iconNumber);
    }

    @Override
    public int getItemCount() {
        return icons.size();
    }

    class IconViewHolder extends RecyclerView.ViewHolder{

        ImageButton icon;

        IconViewHolder(View v){
            super(v);
            this.icon = v.findViewById(R.id.icon);
        }


    }
}
