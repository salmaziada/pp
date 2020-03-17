package net.selsela.carRental.ui.auoth;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.BaseResponse;
import net.selsela.carRental.data.model.user.LoginData;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.main.MainActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginMvpView {


    @BindView(R.id.backgroundView)
    ImageView backgroundView;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.email_label)
    TextView emailLabel;
    @BindView(R.id.email_edit)
    AppCompatEditText emailEdit;
    @BindView(R.id.pass_label)
    TextView passLabel;
    @BindView(R.id.confrim_new_pass)
    AppCompatEditText confrimNewPass;
    @BindView(R.id.checkbox2)
    CheckBox checkbox2;
    @BindView(R.id.confim_pass_lay)
    LinearLayout confimPassLay;
    @BindView(R.id.forget_pass)
    TextView forgetPass;
    @BindView(R.id.new_user)
    TextView newUser;
    @BindView(R.id.register_now)
    TextView registerNow;
    @BindView(R.id.lay2)
    ConstraintLayout lay2;
    @BindView(R.id.login_btn)
    Button loginBtn;

    public LoginActivity() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);


    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void isSuccess(boolean loginResponse) {

        if (loginResponse) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }

    @Override
    public void register(BaseResponse<LoginData> loginResponse) {

    }

    @Override
    public void login(BaseResponse<LoginData> loginResponse) {
        EventBus.getDefault().postSticky(loginResponse.getData().getUserData());

    }


    @Override
    public void isSuccess(Boolean status) {

    }


    @OnClick({R.id.forget_pass, R.id.lay2, R.id.login_btn})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.forget_pass:
                intent=new Intent(this,ForgetPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.lay2:
                intent=new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_btn:
                intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}
