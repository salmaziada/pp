package net.selsela.carRental.ui.notifications;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.notification.NotoficationData;
import net.selsela.carRental.data.model.user.UserBody;
import net.selsela.carRental.ui.base.BasePresenter;
import net.selsela.carRental.util.RetrofitException;
import net.selsela.carRental.util.RxUtil;

import java.io.IOException;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;


public class Notofication_Presenter extends BasePresenter<MyNotoification_MvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public Notofication_Presenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(MyNotoification_MvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void getNotofication() {
        checkViewAttached();
        getMvpView().onRequestStart();
        RxUtil.dispose(mDisposable);
        mDataManager.getNotification()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<NotoficationData>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResponse<NotoficationData> Response) {
                     if (Response.getData().getNotifications() != null && Response.getData().getNotifications().size() > 0)
                            getMvpView().getNotification(Response.getData().getNotifications());
                     else
                           getMvpView().showEmpty();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error while Flats");
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

    public void deleteNotification( UserBody userBody) {
        checkViewAttached();
        getMvpView().onRequestStart();
        RxUtil.dispose(mDisposable);
        mDataManager.deleteNotification(userBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseResponse response) {
                        if (response.getStatus())
                            getMvpView().isSuccess(true);
                        //  getMvpView().showSuccessDialog(response.getResponseMessage());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error while deleteNotification");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            Timber.d("response %s", response);

                            if (response != null)
                                getMvpView().showMessageDialog(response.getResponseMessage());

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

}


