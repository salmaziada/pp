package net.selsela.carRental.ui.auoth;

import android.content.Context;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.countries.Country;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.data.model.user.UserBody;
import net.selsela.carRental.ui.base.BasePresenter;
import net.selsela.carRental.util.RetrofitException;
import net.selsela.carRental.util.RxUtil;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class LoginPresenter extends BasePresenter<LoginMvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public LoginPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(LoginMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void login(final Context context, final UserBody userBody) {
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        getMvpView().showProgressView(true);

        mDataManager.makeLogin(userBody)
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
                        getMvpView().login(loginResponse);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "There was an error while login");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            if (response != null )
                                getMvpView().showMessageDialog(response);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (RetrofitException e1) {
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

    public void register(final Context context, final UserBody userBody) {
        getMvpView().showProgressView(true);
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        mDataManager.makeRegister(userBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<LoginData>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse<LoginData> loginResponse) {

                                //updateDeviceKey();
                                getMvpView().isSuccess(true);
                                 getMvpView().register(loginResponse);


                    }


                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "There was an error while register");
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


    public void forget_password(final Context context, final UserBody userBody) {
        checkViewAttached();
        getMvpView().showProgressView(true);

        RxUtil.dispose(mDisposable);

        mDataManager.forget_password(userBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse loginResponse) {
                        getMvpView().isSuccess(true);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "There was an error while forget_password");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            if (response != null)
                                getMvpView().showMessageDialog(response);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (RetrofitException e1) {
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
    public void getCountry() {
        checkViewAttached();
        // getMvpView().onRequestStart();
        RxUtil.dispose(mDisposable);
        mDataManager.getCountry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Country>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Country> response) {
                        //if (response != null && response.size() > 0)
                            //getMvpView().showState(response);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error while getGov");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            if (response != null)
                                getMvpView().showMessageDialog(response);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        //getMvpView().onRequestEnd();
                    }

                    @Override
                    public void onComplete() {
                        // getMvpView().onRequestEnd();

                    }
                });
    }


}


