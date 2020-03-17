package net.selsela.carRental.ui.order.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.selsela.carRental.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class Paymnet_methodsAdapter extends RecyclerView.Adapter<Paymnet_methodsAdapter.ViewHolder> {

    // UpdateDataClickListener updateDataClickListener;


    private int selectedItem = -1;


    private Context context;

    public Paymnet_methodsAdapter(Context context) {
        this.context = context;
        //this.updateDataClickListener = updateDataClickListener;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_cell, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        if (selectedItem == holder.getAdapterPosition()) {
            holder.lay.setBackground(ContextCompat.getDrawable(context, R.drawable.rec5_orange2));
            holder.paymentTypeValue.setTextColor(ContextCompat.getColor(context, R.color.blak));

        } else {
            holder.lay.setBackground(ContextCompat.getDrawable(context, R.drawable.rec5_black_stroke));
            holder.paymentTypeValue.setTextColor(ContextCompat.getColor(context, R.color.gray_yellow));


        }
        holder.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItem != holder.getAdapterPosition()) {
                    holder.lay.setBackground(ContextCompat.getDrawable(context, R.drawable.rec5_orange2));
                    holder.paymentTypeValue.setTextColor(ContextCompat.getColor(context, R.color.blak));
                    notifyItemChanged(selectedItem);
                    selectedItem = holder.getAdapterPosition();
                    ///  updateDataClickListener.onTYpeSelected(type);
                }


            }
        });


    }


    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;

        @BindView(R.id.lay)
        ConstraintLayout lay;
        @BindView(R.id.payment_typeValue)
        TextView paymentTypeValue;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);

            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }


    public interface UpdateDataClickListener {
    }
}
