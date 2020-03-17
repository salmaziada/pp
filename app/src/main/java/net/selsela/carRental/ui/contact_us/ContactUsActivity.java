package net.selsela.carRental.ui.contact_us;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.MenuItem;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.about.AboutData;
import net.selsela.carRental.ui.about_us.About_Us_MvpView;
import net.selsela.carRental.ui.base.BaseActivity;

import butterknife.ButterKnife;
import timber.log.Timber;

public class ContactUsActivity extends BaseActivity implements About_Us_MvpView {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        activityTitle = getString(R.string.contact_us_label2);
        initToolbar();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showData(AboutData data) {

    }


    public boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.checkSelfPermission(Manifest.permission.CALL_PHONE)
                    == PackageManager.PERMISSION_GRANTED) {
                Timber.d("Permission is granted");
                return true;
            } else {

                Timber.d("Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Timber.d("Permission is granted");
            return true;
        }
    }

    public void call_action() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        //callIntent.setData(Uri.parse("tel:+" + mobiletxt));
        if (isPermissionGranted()) {
            startActivity(callIntent);
        }
    }

    @Override
    public void isSuccess(Boolean status) {

    }

}
