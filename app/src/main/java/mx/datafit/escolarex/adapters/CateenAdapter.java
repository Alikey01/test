package mx.datafit.escolarex.adapters;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import mx.datafit.escolarex.R;
import mx.datafit.escolarex.entities.Cateen;



public class CateenAdapter extends RecyclerView.Adapter<CateenAdapter.ViewHolder> {
    private List<Cateen> mItems;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Cateen clickedSchoolCateen);
    }

    public CateenAdapter(Context context, List<Cateen> items) {
        mItems = items;
        mContext = context;
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public void swapItems(List<Cateen> schoolCateenList) {
        if (schoolCateenList == null) {
            mItems = new ArrayList<>(0);
        } else {
            mItems = schoolCateenList;
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.cateen_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Cateen cateen = mItems.get(position);
        holder.date.setText(cateen.getDate());
        holder.charge.setText(cateen.getCharge());
        holder.concept.setText(cateen.getConcept());
        holder.payment.setText(cateen.getPayment());
        holder.paymentConcept.setText(cateen.getPaymentConcept());
        holder.residue.setText(cateen.getResidue());
        holder.registeredAt.setText(cateen.getRegisteredAt());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView date,  charge, concept, eatingDate, payment, paymentConcept,paymentDate, registeredAt,residue;

        ViewHolder(View itemView) {
            super(itemView);
            date           = (TextView) itemView.findViewById(R.id.txtCateenDate);
            charge         = (TextView) itemView.findViewById(R.id.txtCateenCharge);
            concept        = (TextView) itemView.findViewById(R.id.txtCateenConcept);
            payment        = (TextView) itemView.findViewById(R.id.txtCateenPayment);
            paymentConcept = (TextView) itemView.findViewById(R.id.txtCateenPaymentConcept);
            residue        = (TextView) itemView.findViewById(R.id.txtCateenResidue);
            registeredAt   = (TextView) itemView.findViewById(R.id.txtCateenRegistered);
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
