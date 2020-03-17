package net.selsela.carRental.ui.notifications.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.notification.Notification;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class NotificationsRecyclerViewAdapter extends RecyclerView.Adapter<NotificationsRecyclerViewAdapter.ViewHolder> {
    String currency;
    //List<Notification> notificationList;
    UpdateDataClickListener updateDataClickListener;


    private boolean isArabic;


    private Context context;

    public NotificationsRecyclerViewAdapter( Context context, UpdateDataClickListener updateDataClickListener) {
      //  this.notificationList = notifications;
        this.context = context;
        this.updateDataClickListener = updateDataClickListener;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notifications_list, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        final Notification notification = notificationList.get(position);
//        if (notification == null)
//            return;






        holder.deleteLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // updateDataClickListener.onNotificationdeleted(notification, position);
            }
        });
        if (isArabic) {
            holder.swipeLayout.setRightSwipeEnabled(false);
            holder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, holder.deleteLayout);

        }
        holder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        holder.swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
                YoYo.with(Techniques.Tada).duration(500).delay(100).playOn(layout.findViewById(R.id.delete));
            }
        });


    }

    public void isArabic(boolean arabic) {
        this.isArabic = arabic;
    }

    public void remove(Notification notification) {
       // notificationList.remove(notification);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title_value)
        TextView titleValue;
        @BindView(R.id.details_value)
        TextView detailsValue;
        @BindView(R.id.minits_value)
        TextView minitsValue;
        @BindView(R.id.delete)
        ImageView delete;
        @BindView(R.id.delete_layout)
        LinearLayout deleteLayout;
        @BindView(R.id.swipe_layout)
        SwipeLayout swipeLayout;
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

    public void setCurrency(String currency) {
        this.currency = currency;

    }

    public interface UpdateDataClickListener {
        void onNotificationdeleted(Notification notification, int position);


    }
}
