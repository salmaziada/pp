package net.selsela.carRental.ui.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.car_details.Car_detailsActivity;
import net.selsela.carRental.ui.main.MainActivity;
import net.selsela.carRental.ui.main.adapter.TimeAdapter;
import net.selsela.carRental.ui.order.adapter.Paymnet_methodsAdapter;
import net.selsela.carRental.util.Const;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderActivity extends BaseActivity {

    @BindView(R.id.innerline)
    View innerline;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.info_label)
    TextView infoLabel;
    @BindView(R.id.edit_action)
    TextView editAction;
    @BindView(R.id.car_image)
    ImageView carImage;
    @BindView(R.id.car_name)
    TextView carName;
    @BindView(R.id.care_price_value)
    TextView carePriceValue;
    @BindView(R.id.currency_2)
    TextView currency2;
    @BindView(R.id.lay_info)
    ConstraintLayout layInfo;
    @BindView(R.id.address_label)
    TextView addressLabel;
    @BindView(R.id.edit_address_action)
    TextView editAddressAction;
    @BindView(R.id.address_value)
    TextView addressValue;
    @BindView(R.id.rent_label)
    TextView rentLabel;
    @BindView(R.id.edit_rent_time)
    TextView editRentTime;
    @BindView(R.id.date_label_from)
    TextView dateLabelFrom;
    @BindView(R.id.date_value_from)
    TextView dateValueFrom;
    @BindView(R.id.from_time_lay)
    ConstraintLayout fromTimeLay;
    @BindView(R.id.date_label_end)
    TextView dateLabelEnd;
    @BindView(R.id.date_valu_end)
    TextView dateValuEnd;
    @BindView(R.id.end_time_lay)
    ConstraintLayout endTimeLay;
    @BindView(R.id.from_to_image)
    ImageView fromToImage;
    @BindView(R.id.payment_method_label)
    TextView paymentMethodLabel;
    @BindView(R.id.payment_recycle)
    RecyclerView paymentRecycle;
    @BindView(R.id.total_label)
    TextView totalLabel;
    @BindView(R.id.total_price_value)
    TextView totalPriceValue;
    @BindView(R.id.currency_3)
    TextView currency3;
    @BindView(R.id.finish_order)
    Button finishOrder;
    @BindView(R.id.price_details)
    Button priceDetails;
    @BindView(R.id.price_lay)
    ConstraintLayout priceLay;
    @BindView(R.id.lay)
    NestedScrollView lay;
    private BottomSheetDialog mBottomSheetDialog;
    private MaterialDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        activityTitle = getString(R.string.total_amount_order);
        initToolbar();
        paymentRecycle.setLayoutManager(new GridLayoutManager(this, 3));
        paymentRecycle.setAdapter(new Paymnet_methodsAdapter(this));
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

    @OnClick({R.id.finish_order, R.id.price_details, R.id.edit_action,R.id.edit_address_action,R.id.edit_rent_time})
    public void onViewClicked(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.finish_order:
                intent = new Intent(this, SuccessOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.price_details:
                PRICE_DETAILS();
                break;

            case R.id.edit_action:
                intent = new Intent(this, Car_detailsActivity.class);
                startActivity(intent);
                break;
            case R.id.edit_address_action:
                intent = new Intent(this, MainActivity.class);
                intent.putExtra(Const.TYPE, 0);
                startActivity(intent);
                break;
            case R.id.edit_rent_time:
                time_dailog();
                break;
        }
    }


    public void PRICE_DETAILS() {
        mBottomSheetDialog = new BottomSheetDialog((this));

        View sheetView = getLayoutInflater().inflate(R.layout.price_details_bottomsheet, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackground(getApplicationContext().getResources().getDrawable(R.drawable.shape_button_sheet_background));
        BottomSheetBehavior mBottomSheetBehavior = BottomSheetBehavior.from(((View) sheetView.getParent()));
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        mBottomSheetBehavior.setSkipCollapsed(true);

        final ImageView dismiss_action = mBottomSheetDialog.findViewById(R.id.dismiss_action);
        dismiss_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });
        mBottomSheetDialog.show();
    }

    public void time_dailog() {
        // mBottomSheetDialog = new BottomSheetDialog(getContext());
        //  View sheetView = getLayoutInflater().inflate(R.layout.booking_data, null);
        //   mBottomSheetDialog.setContentView(sheetView);


//        BottomSheetBehavior mBottomSheetBehavior = BottomSheetBehavior.from(((View) sheetView.getParent()));
//        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

//        mBottomSheetBehavior.setSkipCollapsed(true);
        dialog = new MaterialDialog.Builder(this)
                .customView(R.layout.booking_data, false)
                .contentGravity(GravityEnum.START)
                .build();
        Window window = dialog.getWindow();

        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(this.getResources().getDrawable(R.color.blak));


        final RecyclerView time_RV = (RecyclerView) dialog.findViewById(R.id.renatl_time_rv);
        final ImageView dismiss_action = (ImageView) dialog.findViewById(R.id.dismiss_action);

        final ImageView from_to=(ImageView) dialog.findViewById(R.id.from_to_image);
        final TextView am=(TextView) dialog.findViewById(R.id.am_label);
        final TextView pm=(TextView) dialog.findViewById(R.id.pm_label);
        final ConstraintLayout from_time_lay=(ConstraintLayout)dialog.findViewById(R.id.from_time_lay);
        final ConstraintLayout end_time_lay=(ConstraintLayout)dialog.findViewById(R.id.end_time_lay);
        final TextView label_value=(TextView)dialog.findViewById(R.id.label_value);

        if (isArabic())
            from_to.setImageResource(R.drawable.to_english);
        else
            from_to.setImageResource(R.drawable.to);

        /////////////////////////////////////////////////////////
        ArrayList<String> time = new ArrayList<>();
        time.add(0, getString(R.string.one_label));
        time.add(1, getString(R.string.two_label));
        time.add(2, getString(R.string.there_label));
        time.add(3, getString(R.string.there_label4));
        time.add(4, getString(R.string.there_label5));
        time.add(5, getString(R.string.there_label6));
        time.add(6, getString(R.string.there_label7));
        time.add(7, getString(R.string.there_label8));
        time.add(8, getString(R.string.there_label9));
        time.add(9, getString(R.string.there_label10));
        time.add(10, getString(R.string.there_label11));
        time.add(11, getString(R.string.there_label12));


        //////////////////////////////////////////////////////////////////
        time_RV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        time_RV.setAdapter(new TimeAdapter(this, time));

        dismiss_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });




        am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.setTextColor(getResources().getColor(R.color.primary_dark));
                pm.setTextColor(getResources().getColor(R.color.white));
            }
        });

        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pm.setTextColor(getResources().getColor(R.color.primary_dark));
                am.setTextColor(getResources().getColor(R.color.white));

            }
        });

        from_time_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                from_time_lay.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.rec5_orange2));
                end_time_lay.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.rec5_grayr));
                label_value.setText(getString(R.string.rent_time_label2));





            }
        });


        end_time_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end_time_lay.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.rec5_orange2));
                from_time_lay.setBackground(getApplicationContext().getResources().getDrawable(R.drawable.rec5_grayr));
                label_value.setText(getString(R.string.returne_date_label));





            }
        });


        //  final TextView normal_action=mBottomSheetDialog.findViewById(R.id.normal_action);
//        automatic_action.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                automatic_action.setBackground(getActivity().getDrawable(R.drawable.rec5_black));
//                normal_action.setBackground(getActivity().getDrawable(R.drawable.rec5_orange));
//            }
//        });
//        normal_action.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                normal_action.setBackground(getActivity().getDrawable(R.drawable.rec5_black));
//                automatic_action.setBackground(getActivity().getDrawable(R.drawable.rec5_orange));
//            }
//        });


        dialog.show();
    }

}
