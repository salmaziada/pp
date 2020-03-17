package net.selsela.carRental.ui.contact_us;

import net.selsela.carRental.data.DataManager;
import net.selsela.carRental.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;


public class Contact_Us_Presenter extends BasePresenter<Contact_UsMvpView> {

    private final DataManager mDataManager;
    private Disposable mDisposable;

    @Inject
    public Contact_Us_Presenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(Contact_UsMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mDisposable != null) mDisposable.dispose();
    }

}


