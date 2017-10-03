package mx.datafit.escolarex.adapters;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mx.datafit.escolarex.R;
import mx.datafit.escolarex.entities.Homework;


public class HomeworkAdapter extends RecyclerView.Adapter<HomeworkAdapter.ViewHolder> {

    private List<Homework> mItems;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Homework clickedHomework);
    }

    public HomeworkAdapter(Context context, List<Homework> items) {
        mItems = items;
        mContext = context;
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void swapItems(List<Homework> homeworkList) {
        if (homeworkList == null) {
            mItems = new ArrayList<>(0);
        } else {
            mItems = homeworkList;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.homework_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Homework homework = mItems.get(position);

        holder.title.setText(homework.getTitle());
        holder.subtitle.setText(homework.getSubtitle());
        holder.date.setText(homework.getDate());
        holder.btnAttachHomework.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d("click","probando ");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView subtitle;
        TextView date;
        FloatingActionButton btnAttachHomework;

        ViewHolder(View itemView) {
            super(itemView);
            title    = (TextView)  itemView.findViewById(R.id.txtHomeworkTitle);
            subtitle = (TextView)  itemView.findViewById(R.id.txtHomeworkSubtitle);
            date     = (TextView)  itemView.findViewById(R.id.txtHomeworkPublicationDate);
            btnAttachHomework = (FloatingActionButton) itemView.findViewById(R.id.btnAttachHomework);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                mOnItemClickListener.onItemClick(mItems.get(position));
            }
        }
    }
}
