package net.selsela.carRental.ui.base;


import net.selsela.carRental.data.model.BaseResponse;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface MvpView {

    void showMessageDialog(String responseMessage);

    void showProgressView(boolean show);

    void onRequestStart();

    void onRequestEnd();

    void showEmpty();

    void showMessageDialog(BaseResponse response);

    void showSuccessDialog(String message);

    void showAlertDialog(String message);
    void isSuccess(Boolean status);


}
