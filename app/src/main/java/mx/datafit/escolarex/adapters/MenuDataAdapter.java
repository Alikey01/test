package mx.datafit.escolarex.adapters;

import android.support.v7.widget.RecyclerView;
import mx.datafit.escolarex.entities.MenuItem;
import java.util.ArrayList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import mx.datafit.escolarex.R;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Context;
/**
 * Created by Gerardo on 08/08/2017.
 */

public class MenuDataAdapter extends RecyclerView.Adapter<MenuDataAdapter.ViewHolder> {
    private ArrayList<MenuItem> arrayList;
    private Context mContext;

    public MenuDataAdapter(Context context, ArrayList<MenuItem> items) {
        this.arrayList = items;
        this.mContext = context;
    }

    @Override
    public void onBindViewHolder(MenuDataAdapter.ViewHolder holder, int i) {
        holder.textView.setText(arrayList.get(i).getRecyclerViewTitleText());
        holder.imageView.setImageResource(arrayList.get(i).getRecyclerViewImage());
    }

    @Override
    public MenuDataAdapter.ViewHolder onCreateViewHolder(ViewGroup vGroup, int i) {
        View view = LayoutInflater.from(vGroup.getContext()).inflate(R.layout.menu_item_layout, vGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.text);
            imageView = (ImageView) v.findViewById(R.id.image);
        }
    }
}
