package net.selsela.carRental.ui.main;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.home.HomeData;
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
import timber.log.Timber;


public class Home_Presenter extends BasePresenter<Home_MvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public Home_Presenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(Home_MvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }
    public void getHome() {
        checkViewAttached();
        getMvpView().onRequestStart();
        RxUtil.dispose(mDisposable);
        mDataManager.gethome()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<HomeData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResponse<HomeData> Response) {
                              getMvpView().get_tower_home(Response.getData());

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error while getHome");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            if (response != null)
                                getMvpView().showMessageDialog(response);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        getMvpView().onRequestEnd();
                    }

                    @Override
                    public void onComplete() {
                        getMvpView().onRequestEnd();
                    }
                });
    }
    public void logout(UserBody userBody) {
        checkViewAttached();
        RxUtil.dispose(mDisposable);
        //getMvpView().showProgressView(true);

        mDataManager.makeLogout(userBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<LoginData>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse<LoginData> loginResponse) {
                        getMvpView().isSuccessLogout(loginResponse.getStatus());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        //getMvpView().showProgressView(false);
                        getMvpView().isSuccessLogout(true);

                    }

                    @Override
                    public void onComplete() {
                        //getMvpView().showProgressView(false);

                    }
                });

    }

}


