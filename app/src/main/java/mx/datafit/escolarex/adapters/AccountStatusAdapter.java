package mx.datafit.escolarex.adapters;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import android.support.v7.widget.RecyclerView;

import mx.datafit.escolarex.R;
import mx.datafit.escolarex.entities.AccountStatus;

import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;


/**
 * Created by Gerardo on 15/08/2017.
 * https://stackoverflow.com/questions/38236948/how-to-make-an-expandable-list-of-cardviews //flechita
 */

public class AccountStatusAdapter extends RecyclerView.Adapter<AccountStatusAdapter.ViewHolder> {

    private List<AccountStatus> mItems;
    private Context mContext;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public AccountStatusAdapter(Context context, List<AccountStatus> items) {
        mItems = items;
        mContext = context;
        for (int i = 0; i < mItems.size(); i++) {
            expandState.append(i, false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.account_status_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        AccountStatus account = mItems.get(position);
        holder.conceptAccount.setText(account.getConcept());
        holder.chargeNumber.setText(account.getChargeNumber());
        holder.paymentAmount.setText(account.getPaymentAmount());
        holder.amountPaid.setText(account.getAmountPaid());
        holder.paymentDate.setText(account.getPaymentDate());
        holder.chargeDate.setText(account.getChargeDate());
        holder.paymentMethod.setText(account.getPaymentMethod());
        holder.paymentReference.setText(account.getPaymentReference());
        holder.transactionCode.setText(account.getTransactionCode());
        holder.txtDetailsLegend.setText(R.string.lbl_more_details);

        //check if view is expanded
        final boolean isExpanded = expandState.get(position);
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(
                    holder.expandableLayout,
                    holder.buttonLayout,
                    position,
                    holder.txtDetailsLegend
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView conceptAccount, chargeNumber, paymentAmount, amountPaid,
            paymentDate, chargeDate, paymentMethod, paymentReference,
            transactionCode, txtDetailsLegend;

        LinearLayout expandableLayout;
        RelativeLayout buttonLayout;

        ViewHolder(View itemView) {
            super(itemView);
            conceptAccount   = (TextView) itemView.findViewById(R.id.txtConceptAccount);
            chargeNumber     = (TextView) itemView.findViewById(R.id.txtChargeNumberAccount);
            paymentAmount    = (TextView) itemView.findViewById(R.id.txtPaymentAmountAccount);
            amountPaid       = (TextView) itemView.findViewById(R.id.txtAmountPaidAccount);
            paymentDate      = (TextView) itemView.findViewById(R.id.txtPaymentDateAccount);
            chargeDate       = (TextView) itemView.findViewById(R.id.txtChargeDateAccount);
            paymentMethod    = (TextView) itemView.findViewById(R.id.txtPaymentMethodAccount);
            paymentReference = (TextView) itemView.findViewById(R.id.txtPaymentReferenceAccount);
            transactionCode  = (TextView) itemView.findViewById(R.id.txtTransactionCodeAccount);
            buttonLayout     = (RelativeLayout) itemView.findViewById(R.id.button);
            expandableLayout = (LinearLayout) itemView.findViewById(R.id.expandableLayout);
            txtDetailsLegend = (TextView) itemView.findViewById(R.id.txtDetailsLegend);
        }
    }

    private void onClickButton(
            final LinearLayout expandableLayout,
            final RelativeLayout buttonLayout,
            final int position,
            final TextView txtDetailsLegend) {

        //Simply set View to Gone if not expanded
        //Not necessary but I put simple rotation on button layout
        if (expandableLayout.getVisibility() == View.VISIBLE) {
            createRotateAnimator(buttonLayout, 180f, 0f).start();
            expandableLayout.setVisibility(View.GONE);
            txtDetailsLegend.setText(R.string.lbl_more_details);
            expandState.put(position, false);
        } else {
            createRotateAnimator(buttonLayout, 0f, 180f).start();
            expandableLayout.setVisibility(View.VISIBLE);
            txtDetailsLegend.setText(R.string.lbl_less_details);
            expandState.put(position, true);
        }
    }

    private ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }
}
