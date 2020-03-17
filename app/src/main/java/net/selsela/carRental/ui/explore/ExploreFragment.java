package net.selsela.carRental.ui.explore;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseFragment;
import net.selsela.carRental.ui.explore.adapter.AllCarAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class ExploreFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.car_list)
    RecyclerView carList;
    Unbinder unbinder;
    @BindView(R.id.filter)
    ImageView filter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private BottomSheetDialog mBottomSheetDialog;


    public ExploreFragment() {
    }


    public static ExploreFragment newInstance(String param1, String param2) {
        ExploreFragment fragment = new ExploreFragment();
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
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        unbinder = ButterKnife.bind(this, view);
        getActivityComponent().inject(this);
        carList.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        carList.setAdapter(new AllCarAdapter(getContext(), new AllCarAdapter.UpdateDataClickListener() {
        }));
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

    @OnClick(R.id.filter)
    public void onViewClicked() {
        filter_dialoge();


    }


    public void filter_dialoge() {
        mBottomSheetDialog = new BottomSheetDialog(getContext());
        View sheetView = getLayoutInflater().inflate(R.layout.filter_bottom_sheet, null);
        mBottomSheetDialog.setContentView(sheetView);
        mBottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackground(getContext().getResources().getDrawable(R.drawable.shape_button_sheet_background));
        BottomSheetBehavior mBottomSheetBehavior = BottomSheetBehavior.from(((View) sheetView.getParent()));
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        mBottomSheetBehavior.setSkipCollapsed(true);

        final TextView automatic_action=mBottomSheetDialog.findViewById(R.id.automatic_action);
        final TextView normal_action=mBottomSheetDialog.findViewById(R.id.normal_action);

        final ImageView dismiss_action = mBottomSheetDialog.findViewById(R.id.dismiss_action);
        dismiss_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheetDialog.dismiss();
            }
        });
        automatic_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                automatic_action.setBackground(getActivity().getDrawable(R.drawable.rec5_black));
                normal_action.setBackground(getActivity().getDrawable(R.drawable.rec5_orange));
            }
        });
        normal_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normal_action.setBackground(getActivity().getDrawable(R.drawable.rec5_black));
                automatic_action.setBackground(getActivity().getDrawable(R.drawable.rec5_orange));
            }
        });


        mBottomSheetDialog.show();
    }
}
