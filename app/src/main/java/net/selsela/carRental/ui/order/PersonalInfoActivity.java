package net.selsela.carRental.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PersonalInfoActivity extends BaseActivity {

    @BindView(R.id.gender_label)
    TextView genderLabel;
    @BindView(R.id.male_button)
    RadioButton maleButton;
    @BindView(R.id.male_label)
    TextView maleLabel;
    @BindView(R.id.female_button)
    RadioButton femaleButton;
    @BindView(R.id.fmale_label)
    TextView fmaleLabel;
    @BindView(R.id.name_label)
    TextView nameLabel;
    @BindView(R.id.name_edit)
    AppCompatEditText nameEdit;
    @BindView(R.id.eamil_label)
    TextView eamilLabel;
    @BindView(R.id.email_editText)
    AppCompatEditText emailEditText;
    @BindView(R.id.mobile)
    TextView mobile;
    @BindView(R.id.mobile_editText)
    EditText mobileEditText;
    @BindView(R.id.country_key)
    TextView countryKey;
    @BindView(R.id.mobile_lay)
    ConstraintLayout mobileLay;
    @BindView(R.id.age_check)
    CheckBox ageCheck;
    @BindView(R.id.follow_btn)
    Button followBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        activityTitle = getString(R.string.personal_information);
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





    @OnClick({R.id.male_button, R.id.female_button,R.id.follow_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.male_button:
                maleButton.setChecked(true);
                femaleButton.setChecked(false);
                break;
            case R.id.female_button:
                maleButton.setChecked(false);
                femaleButton.setChecked(true);
                break;
            case R.id.follow_btn:
                Intent intent = new Intent(this, OrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
