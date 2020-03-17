package net.selsela.carRental.ui.main;


import net.selsela.carRental.data.model.home.HomeData;
import net.selsela.carRental.ui.base.MvpView;

public interface Home_MvpView extends MvpView {
    void get_tower_home(HomeData homeData);
    void isSuccessLogout(Boolean status);


}
