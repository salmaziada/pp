package net.selsela.carRental.ui.MainPresenter;


import net.selsela.carRental.data.model.config.ConfigData;
import net.selsela.carRental.ui.base.MvpView;


public interface MainMvpView extends MvpView {

    void showSettingData(ConfigData settingData);

}
