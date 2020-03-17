package net.selsela.carRental.ui.auoth;

import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ForgetPasswordActivity extends BaseActivity implements LoginMvpView {


    @BindView(R.id.backgroundView)
    ImageView backgroundView;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.eamil_label)
    TextView eamilLabel;
    @BindView(R.id.email_editText)
    AppCompatEditText emailEditText;
    @BindView(R.id.follow_btn)
    Button followBtn;
    @BindView(R.id.my_toolbar)
    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        activityTitle = getString(R.string.password_recover_label);
        initToolbar();

        toolbar.setNavigationIcon(R.drawable.ic_arrow);
        toolbar.setTitleTextColor(getResources().getColor(R.color.blak));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void isSuccess(boolean isSuccess) {


    }

    @Override
    public void register(BaseResponse<LoginData> loginResponse) {

    }

    @Override
    public void login(BaseResponse<LoginData> loginResponse) {

    }


    @Override
    public void isSuccess(Boolean status) {

    }


}
