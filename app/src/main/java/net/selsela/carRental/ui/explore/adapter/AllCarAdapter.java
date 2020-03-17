package net.selsela.carRental.ui.explore.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.car_details.Car_detailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class AllCarAdapter extends RecyclerView.Adapter<AllCarAdapter.ViewHolder> {
    /// List<Notification> notificationList;
    UpdateDataClickListener updateDataClickListener;


    private boolean isArabic;


    private Context context;

    public AllCarAdapter(Context context, UpdateDataClickListener updateDataClickListener) {
        //  this.notificationList = notifications;
        this.context = context;
        this.updateDataClickListener = updateDataClickListener;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_cell, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Car_detailsActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        @BindView(R.id.car_image)
        ImageView carImage;
        @BindView(R.id.car_model)
        TextView carModel;
        @BindView(R.id.price_value)
        TextView priceValue;
        @BindView(R.id.currency)
        TextView currency;
        @BindView(R.id.day_counts)
        TextView dayCounts;
        @BindView(R.id.label_days)
        TextView labelDays;


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
        // void onNotificationdeleted(Notification notification, int position);


    }
}
