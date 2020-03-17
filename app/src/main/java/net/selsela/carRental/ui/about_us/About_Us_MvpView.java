package net.selsela.carRental.ui.about_us;


import net.selsela.carRental.data.model.about.AboutData;
import net.selsela.carRental.ui.base.MvpView;

public interface About_Us_MvpView extends MvpView {

    void showData(AboutData data);
}
