package net.selsela.carRental.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.main.MainActivity;
import net.selsela.carRental.util.Const;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SuccessOrderActivity extends BaseActivity {

    @BindView(R.id.iamge)
    ImageView iamge;
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.label_2)
    TextView label2;
    @BindView(R.id.see_details_label)
    Button seeDetailsLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_order);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
    }

    @OnClick(R.id.see_details_label)
    public void onViewClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Const.Name,1);
        startActivity(intent);
    }
}
