package net.selsela.carRental.ui.account;

import android.content.Context;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.data.model.user.UserBody;
import net.selsela.carRental.ui.base.BasePresenter;
import net.selsela.carRental.util.RetrofitException;
import net.selsela.carRental.util.RxUtil;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import timber.log.Timber;


public class ProfilePresenter extends BasePresenter<ProfileMvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public ProfilePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(ProfileMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void update_profile(final Context context, final UserBody userBody) {
        getMvpView().showProgressView(true);
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        mDataManager.upate_profile(userBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<LoginData>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse<LoginData> loginResponse) {
                        getMvpView().isSuccess(true);
                        getMvpView().updateProfileSuccess(loginResponse);
                        getMvpView().showSuccessDialog(loginResponse.getResponseMessage());

                    }


                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "There was an error while update_profile");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            if (response != null)
                                getMvpView().showMessageDialog(response);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                        getMvpView().showProgressView(false);
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().showProgressView(false);
                    }
                });
    }

    public void changePassword(UserBody userBody) {
        checkViewAttached();
        getMvpView().showProgressView(true);
        Timber.d("changePassword");
        RxUtil.dispose(mDisposable);
        mDataManager.changePassword(userBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<LoginData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse<LoginData> response) {
                        Timber.d("changePassword done ");
                        getMvpView().isSuccess(true);
                        getMvpView().showSuccessDialog(response.getResponseMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.d("onError" + e.getMessage() + e.toString());
                        getMvpView().showProgressView(false);

                        try {
                            RetrofitException error = (RetrofitException) e;
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            Timber.d("changePassword %s", response);
                            if (response != null)
                                getMvpView().showMessageDialog(response);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (HttpException e1) {
                            e1.printStackTrace();
                        }
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().showProgressView(false);
                    }
                });
    }


}
