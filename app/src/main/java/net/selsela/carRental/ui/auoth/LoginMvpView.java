package net.selsela.carRental.ui.auoth;


import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.ui.base.MvpView;

public interface LoginMvpView extends MvpView {

    void isSuccess(boolean isSuccess);

    void register(BaseResponse<LoginData> loginResponse);

    void login(BaseResponse<LoginData> loginResponse);

}
