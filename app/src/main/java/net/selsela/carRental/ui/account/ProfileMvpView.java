package net.selsela.carRental.ui.account;


import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.ui.base.MvpView;

public interface ProfileMvpView extends MvpView {
    void updateProfileSuccess(BaseResponse<LoginData> loginResponse);


    //void showAboutContent(AboutPage aboutData);
}
