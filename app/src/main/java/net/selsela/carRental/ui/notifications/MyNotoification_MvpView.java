package net.selsela.carRental.ui.notifications;


import net.selsela.carRental.data.model.notification.Notification;
import net.selsela.carRental.ui.base.MvpView;

import java.util.List;

public interface MyNotoification_MvpView extends MvpView {
    void getNotification(List<Notification> notifications);

}
