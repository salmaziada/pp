package net.selsela.carRental.ui.about_us;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.about.AboutData;
import net.selsela.carRental.data.model.error.ErrorResponse;
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


public class About_Us_Presenter extends BasePresenter<About_Us_MvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public About_Us_Presenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(About_Us_MvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

    public void getAbout() {
        checkViewAttached();
        getMvpView().showProgressView(true);
        RxUtil.dispose(mDisposable);
        mDataManager.get_about_page()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse<AboutData>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(@NonNull BaseResponse<AboutData> aboutDataBaseResponse) {
                        getMvpView().showData(aboutDataBaseResponse.getData());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e, "There was an error while about");
                        RetrofitException error = (RetrofitException) e;
                        try {
                            ErrorResponse response = error.getErrorBodyAs(ErrorResponse.class);
                            if (response != null && response.getResponseMessage() != null)
                                getMvpView().showMessageDialog(response.getResponseMessage());
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

    public void contact(UserBody postBody) {
        Timber.d("contact");
        checkViewAttached();
        getMvpView().showProgressView(true);
        RxUtil.dispose(mDisposable);
        mDataManager.postContact(postBody)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<BaseResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseResponse response) {
                        getMvpView().showSuccessDialog(response.getResponseMessage());
                    }

                    @Override
                    public void onError(Throwable e) {

                        try {
                            RetrofitException error = (RetrofitException) e;
                            BaseResponse response = error.getErrorBodyAs(BaseResponse.class);
                            Timber.d("response %s", response);
                            if (response != null)
                                getMvpView().showMessageDialog(response.getResponseMessage());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        } catch (HttpException e1) {
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

}


