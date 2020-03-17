package net.selsela.carRental.ui.notifications;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.notification.Notification;
import net.selsela.carRental.data.model.user.UserBody;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.notifications.adapter.NotificationsRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotificationsActivity extends BaseActivity implements MyNotoification_MvpView {

    @BindView(R.id.empty_view)
    TextView emptyView;


    @BindView(R.id.notifications_recycleView)
    RecyclerView notificationsRecycleView;
    @Inject
    Notofication_Presenter notofication_presenter;
    @BindView(R.id.image)
    ImageView image;

    private NotificationsRecyclerViewAdapter notificationsRecyclerViewAdapter;
    private UserBody userBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        notofication_presenter.attachView(this);
        activityTitle = getString(R.string.notifications);
        initToolbar();
         //userBody =new UserBody();
       // notofication_presenter.getNotofication();
        pullToRefresh.setColorSchemeResources(R.color.bron);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullToRefresh.setRefreshing(false);
                //notofication_presenter.getNotofication();

            }
        });

        notificationsRecycleView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
           notificationsRecycleView.setAdapter(new NotificationsRecyclerViewAdapter(this, new NotificationsRecyclerViewAdapter.UpdateDataClickListener() {
               @Override
               public void onNotificationdeleted(Notification notification, int position) {

               }
           }));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void getNotification(List<Notification> notifications) {
//        notificationsRecycleView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        notificationsRecyclerViewAdapter = new NotificationsRecyclerViewAdapter(notifications, this, new NotificationsRecyclerViewAdapter.UpdateDataClickListener() {
//            @Override
//            public void onNotificationdeleted(Notification notification, int position) {
//                userBody.setType(3);
//                userBody.setNotification_id(notification.getId());
//                userBody.setToken(preferencesHelper.getCurrentUser().getToken());
//                userBody.setId(preferencesHelper.getCurrentUser().getId());
//                notofication_presenter.deleteNotification(userBody);
//                notificationsRecyclerViewAdapter.remove(notification);
//
//            }
//        });
        notificationsRecyclerViewAdapter.isArabic(isArabic());
        notificationsRecycleView.setAdapter(notificationsRecyclerViewAdapter);
    }

    @Override
    public void showEmpty() {
        super.showEmpty();
        emptyView.setVisibility(View.VISIBLE);
        image.setVisibility(View.VISIBLE);
        notificationsRecycleView.setVisibility(View.GONE);

    }
}
