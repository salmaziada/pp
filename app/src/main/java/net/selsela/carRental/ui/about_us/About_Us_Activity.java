package net.selsela.carRental.ui.about_us;


import android.os.Bundle;
import android.view.MenuItem;
;


import net.selsela.carRental.R;
import net.selsela.carRental.data.model.about.AboutData;
import net.selsela.carRental.ui.base.BaseActivity;


import javax.inject.Inject;

import butterknife.ButterKnife;

public class About_Us_Activity extends BaseActivity implements About_Us_MvpView {

    @Inject
    About_Us_Presenter about_us_presenter;


    public About_Us_Activity() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us_);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        about_us_presenter.attachView(this);
      //  about_us_presenter.getAbout();
        activityTitle = getString(R.string.about_label);
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
      //  aboutContent.setHtml(data.getPage().getText());
      //  bout.setText(data.getPage().getTitle());


    }

    @Override
    public void isSuccess(Boolean status) {

    }


}
