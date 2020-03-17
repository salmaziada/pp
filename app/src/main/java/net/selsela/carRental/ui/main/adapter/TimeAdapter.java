package net.selsela.carRental.ui.main.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.ViewHolder> {


    // UpdateDataClickListener updateDataClickListener;

    ArrayList<String> time;
    private int selectedItem = -1;


    private Context context;

    public TimeAdapter(Context context, ArrayList<String> time) {
        this.context = context;
        this.time = time;
        //this.updateDataClickListener = updateDataClickListener;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rental_time_cell, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.timeVlue.setText(time.get(position));

        if (selectedItem == holder.getAdapterPosition()) {
            holder.timeVlue.setTextColor(ContextCompat.getColor(context, R.color.primary_dark));
            holder.selected_item.setVisibility(View.VISIBLE);

        } else {
            holder.timeVlue.setTextColor(ContextCompat.getColor(context, R.color.white));
            holder.selected_item.setVisibility(View.INVISIBLE);

        }
        holder.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItem != holder.getAdapterPosition()) {
                    holder.timeVlue.setTextColor(ContextCompat.getColor(context, R.color.primary_dark));
                    holder.selected_item.setVisibility(View.VISIBLE);


                    notifyItemChanged(selectedItem);
                    selectedItem = holder.getAdapterPosition();
                    ///  updateDataClickListener.onTYpeSelected(type);
                }


            }
        });


    }


    @Override
    public int getItemCount() {
        return time.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;

        @BindView(R.id.selected_item)
        ImageView selected_item;
        @BindView(R.id.time_vlue)
        TextView timeVlue;
        @BindView(R.id.lay)
        ConstraintLayout lay;


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
