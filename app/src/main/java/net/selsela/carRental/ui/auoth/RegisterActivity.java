package net.selsela.carRental.ui.auoth;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatEditText;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.backgroundView)
    ImageView backgroundView;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.name_label)
    TextView nameLabel;
    @BindView(R.id.name_edit)
    AppCompatEditText nameEdit;
    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.mobile_editText)
    EditText mobileEditText;
    @BindView(R.id.country_key)
    TextView countryKey;
    @BindView(R.id.mobile_lay)
    ConstraintLayout mobileLay;
    @BindView(R.id.eamil_label)
    TextView eamilLabel;
    @BindView(R.id.email_editText)
    AppCompatEditText emailEditText;
    @BindView(R.id.pass_label)
    TextView passLabel;
    @BindView(R.id.confrim_new_pass)
    AppCompatEditText confrimNewPass;
    @BindView(R.id.checkbox2)
    CheckBox checkbox2;
    @BindView(R.id.confim_pass_lay)
    LinearLayout confimPassLay;
    @BindView(R.id.register_btn)
    Button registerBtn;
    @BindView(R.id.mask)
    ImageView mask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.register_btn)
    public void onViewClicked() {
        Intent intent= new Intent(this,ActivationActivity.class);
        startActivity(intent);
    }
}
