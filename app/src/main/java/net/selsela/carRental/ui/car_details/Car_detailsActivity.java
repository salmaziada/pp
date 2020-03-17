package net.selsela.carRental.ui.car_details;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
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
import net.selsela.carRental.ui.main.adapter.TimeAdapter;
import net.selsela.carRental.ui.order.PersonalInfoActivity;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Car_detailsActivity extends BaseActivity {
    @BindView(R.id.price_details)
    Button price_details;
    @BindView(R.id.rent_action)
    Button rent_action;

    @BindView(R.id.edit_action)
    TextView edit_action;

    private BottomSheetDialog mBottomSheetDialog;
    private MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);

        activityTitle=getString(R.string.car_details_label);

        initToolbar();
        mBottomSheetDialog = new BottomSheetDialog((this));

        dialog = new MaterialDialog.Builder(this)
                .customView(R.layout.booking_data, false)
                .contentGravity(GravityEnum.START)
                .build();

        price_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PRICE_DETAILS();

            }
        });
        rent_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Car_detailsActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
        edit_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time_dailog();

            }
        });




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

    public void PRICE_DETAILS() {
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
