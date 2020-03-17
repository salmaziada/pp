package net.selsela.carRental.ui.orders_fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.archives_orders.Archives_ordersActivity;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ordersFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.logo_imageView)
    TextView logoImageView;
    @BindView(R.id.Archives)
    ImageView Archives;
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    Unbinder unbinder;
    @BindView(R.id.info_label)
    TextView infoLabel;
    @BindView(R.id.car_image)
    ImageView carImage;
    @BindView(R.id.car_name)
    TextView carName;
    @BindView(R.id.care_price_value)
    TextView carePriceValue;
    @BindView(R.id.currency_2)
    TextView currency2;
    @BindView(R.id.order_status_label)
    TextView orderStatusLabel;
    @BindView(R.id.order_status_value)
    TextView orderStatusValue;
    @BindView(R.id.lay_info)
    ConstraintLayout layInfo;
    @BindView(R.id.office_label)
    TextView officeLabel;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.innerline)
    View innerline;
    @BindView(R.id.office_name)
    ConstraintLayout officeName;
    @BindView(R.id.address_value)
    TextView addressValue;
    @BindView(R.id.address_label)
    TextView addressLabel;
    @BindView(R.id.delevry_address_value)
    TextView delevryAddressValue;
    @BindView(R.id.office_location)
    TextView officeLocation;
    @BindView(R.id.whats_icon)
    ImageView whatsIcon;
    @BindView(R.id.phone_icon)
    ImageView phoneIcon;

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
    @BindView(R.id.payment_method_type)
    TextView paymentMethodType;
    @BindView(R.id.payment_image)
    ImageView paymentImage;
    @BindView(R.id.payment_lay)
    ConstraintLayout paymentLay;
    @BindView(R.id.diver_label)
    TextView diverLabel;
    @BindView(R.id.has_driver)
    TextView hasDriver;
    @BindView(R.id.driver_lay)
    ConstraintLayout driverLay;
    @BindView(R.id.total_label)
    TextView totalLabel;
    @BindView(R.id.total_price_value)
    TextView totalPriceValue;
    @BindView(R.id.currency_3)
    TextView currency3;
    @BindView(R.id.price_details_lay)
    ConstraintLayout priceDetailsLay;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BottomSheetDialog mBottomSheetDialog;


    public ordersFragment() {
    }


    public static ordersFragment newInstance(String param1, String param2) {
        ordersFragment fragment = new ordersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.Archives)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), Archives_ordersActivity.class);
        getContext().startActivity(intent);
    }


    public void PRICE_DETAILS() {
        mBottomSheetDialog = new BottomSheetDialog((getContext()));

        View sheetView = getLayoutInflater().inflate(R.layout.price_details_bottomsheet, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackground(getContext().getResources().getDrawable(R.drawable.shape_button_sheet_background));
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

    @OnClick({R.id.office_location, R.id.price_details_lay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.office_location:
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 31.444, 32.566);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                getContext().startActivity(intent);
                break;
            case R.id.price_details_lay:
                PRICE_DETAILS();
                break;
        }
    }
}
