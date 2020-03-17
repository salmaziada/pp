package net.selsela.carRental.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.config.ConfigData;
import net.selsela.carRental.ui.MainPresenter.MainMvpView;
import net.selsela.carRental.ui.MainPresenter.MainPresenter;
import net.selsela.carRental.ui.auoth.LoginActivity;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.intro.IntroActivity;

import javax.inject.Inject;

public class SplachActivity extends BaseActivity implements MainMvpView {
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
        getActivityComponent().inject(this);
        mainPresenter.attachView(this);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.primary_dark));

       // mainPresenter.getSettingData();
        hideToolbar();

//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
//           @Override
//            public void onSuccess(InstanceIdResult instanceIdResult) {
//               String newToken = instanceIdResult.getToken();
//               Timber.d("newToken 44: %s ", newToken);
//                mUserSession.addNotificationToken(newToken);
//                mainPresenter.updateDeviceKey();
//               // sending reg id to your server
//          }
//       });


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
//                if (mUserSession.hasActiveSession()) {
//
//                    Intent mainIntent = new Intent(SplachActivity.this, MainActivity.class);
//                    SplachActivity.this.startActivity(mainIntent);
//                    SplachActivity.this.finish();
//                }
//                else if (preferencesHelper.isFirstRun()){

                    Intent mainIntent2 = new Intent(SplachActivity.this, IntroActivity.class);
                    SplachActivity.this.startActivity(mainIntent2);
                    SplachActivity.this.finish();
             //   }


            }

        }, SPLASH_DISPLAY_LENGTH);
    }

    @Override
    public void showSettingData(ConfigData settingData) {


    }

    @Override
    public void isSuccess(Boolean status) {
    }



}







