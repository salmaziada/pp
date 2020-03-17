package net.selsela.carRental.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.gms.maps.SupportMapFragment;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseFragment;
import net.selsela.carRental.ui.main.adapter.TimeAdapter;
import net.selsela.carRental.util.Const;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class HomeFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.logo_imageView)
    TextView logoImageView;
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.marker)
    ImageView marker;
    @BindView(R.id.map_lay)
    ConstraintLayout mapLay;
    @BindView(R.id.gove_label)
    TextView goveLabel;
    @BindView(R.id.area_label)
    TextView areaLabel;
    @BindView(R.id.block_label)
    TextView blockLabel;
    @BindView(R.id.gove_value)
    TextView goveValue;
    @BindView(R.id.area_value)
    TextView areaValue;
    @BindView(R.id.block_value)
    TextView blockValue;
    @BindView(R.id.street_label)
    TextView streetLabel;
    @BindView(R.id.innerline)
    View innerline;
    @BindView(R.id.street_value)
    TextView streetValue;
    @BindView(R.id.lay)
    ConstraintLayout lay;
    @BindView(R.id.label)
    TextView label;
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
    @BindView(R.id.show_cars)
    Button showCars;
    Unbinder unbinder;
    @BindView(R.id.from_to_image)
    ImageView fromToImage;
    private SupportMapFragment mapFragment;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BottomSheetDialog mBottomSheetDialog;
    private MaterialDialog dialog;


    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        getActivityComponent().inject(this);
        if (isArabic())
            fromToImage.setImageResource(R.drawable.to_english);
        else
            fromToImage.setImageResource(R.drawable.to);


        intieMap();
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


    public void intieMap() {

        mapFragment = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map2));

    }


    public void time_dailog() {
        // mBottomSheetDialog = new BottomSheetDialog(getContext());
        //  View sheetView = getLayoutInflater().inflate(R.layout.booking_data, null);
        //   mBottomSheetDialog.setContentView(sheetView);


        dialog = new MaterialDialog.Builder(getContext())
                .customView(R.layout.booking_data, false)
                .contentGravity(GravityEnum.START)
                .build();
//        BottomSheetBehavior mBottomSheetBehavior = BottomSheetBehavior.from(((View) sheetView.getParent()));
//        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//        mBottomSheetBehavior.setSkipCollapsed(true);
        Window window = dialog.getWindow();

        window.setLayout(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(getContext().getResources().getDrawable(R.color.blak));
      //  window.setNavigationBarColor(getResources().getColor(R.color.nav_color));
        dialog.getWindow().setNavigationBarColor(getResources().getColor(R.color.nav_color));


        final RecyclerView time_RV = (RecyclerView) dialog.findViewById(R.id.renatl_time_rv);
        final ImageView dismiss_action = (ImageView) dialog.findViewById(R.id.dismiss_action);
        final ImageView from_to=(ImageView) dialog.findViewById(R.id.from_to_image);
        final TextView am=(TextView) dialog.findViewById(R.id.am_label);
        final TextView pm=(TextView) dialog.findViewById(R.id.pm_label);
        final ConstraintLayout from_time_lay=(ConstraintLayout)dialog.findViewById(R.id.from_time_lay);
        final ConstraintLayout end_time_lay=(ConstraintLayout)dialog.findViewById(R.id.end_time_lay);
        final TextView label_value=(TextView)dialog.findViewById(R.id.label_value);
        final CalendarView calendarView=(CalendarView)dialog.findViewById(R.id.calendar_view);






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
        time.add(11, getString(R.string.there_label12));


        //////////////////////////////////////////////////////////////////
        time_RV.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        time_RV.setAdapter(new TimeAdapter(getContext(), time));


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
                from_time_lay.setBackground(getContext().getResources().getDrawable(R.drawable.rec5_orange2));
                end_time_lay.setBackground(getContext().getResources().getDrawable(R.drawable.rec5_grayr));
                label_value.setText(getString(R.string.rent_time_label2));





            }
        });


        end_time_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end_time_lay.setBackground(getContext().getResources().getDrawable(R.drawable.rec5_orange2));
                from_time_lay.setBackground(getContext().getResources().getDrawable(R.drawable.rec5_grayr));
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

    @OnClick({R.id.from_time_lay, R.id.end_time_lay,R.id.show_cars})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.from_time_lay:
                time_dailog();
                break;
            case R.id.end_time_lay:
                time_dailog();
                break;
            case R.id.show_cars:
                Intent intent= new Intent(getContext(),MainActivity.class);
                intent.putExtra(Const.Reg,0);
                getContext().startActivity(intent);
                break;
        }
    }
}
