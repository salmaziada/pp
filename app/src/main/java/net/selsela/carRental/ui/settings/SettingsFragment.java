package net.selsela.carRental.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.about_us.About_Us_Activity;
import net.selsela.carRental.ui.account.ProfileActivity;
import net.selsela.carRental.ui.auoth.LoginActivity;
import net.selsela.carRental.ui.base.BaseFragment;
import net.selsela.carRental.ui.contact_us.ContactUsActivity;
import net.selsela.carRental.ui.notifications.NotificationsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class SettingsFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.profile_info_lay)
    ConstraintLayout profileInfoLay;
    @BindView(R.id.lay)
    ConstraintLayout lay;
    @BindView(R.id.myaccount)
    TextView myaccount;
    @BindView(R.id.innerLine)
    View innerLine;
    @BindView(R.id.notifications)
    TextView notifications;
    @BindView(R.id.innerLine2)
    View innerLine2;
    @BindView(R.id.about_us)
    TextView aboutUs;
    @BindView(R.id.innerLine3)
    View innerLine3;
    @BindView(R.id.contatc_us)
    TextView contatcUs;
    @BindView(R.id.innerLine4)
    View innerLine4;
    @BindView(R.id.langauge)
    TextView langauge;
    @BindView(R.id.textView_arabic)
    TextView textViewArabic;
    @BindView(R.id.textView_english)
    TextView textViewEnglish;
    @BindView(R.id.innerLine5)
    View innerLine5;
    @BindView(R.id.login_logout)
    TextView loginLogout;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public SettingsFragment() {
        // Required empty public constructor
    }


    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        unbinder = ButterKnife.bind(this, view);
        getActivityComponent().inject(this);
        if (isArabic()) {
            textViewArabic.setBackground(getResources().getDrawable(R.drawable.horizantal_top_left__stroke_rec4));
            textViewEnglish.setBackground(getResources().getDrawable(R.drawable.horizantal_top_left_rec4));
        } else {

            textViewEnglish.setBackground(getResources().getDrawable(R.drawable.horizantal_top_left__stroke_rec4_en));
            textViewArabic.setBackground(getResources().getDrawable(R.drawable.horizantal_top_left_rec4_en));

        }
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

    @OnClick({R.id.myaccount, R.id.notifications, R.id.about_us, R.id.contatc_us, R.id.login_logout, R.id.profile_info_lay, R.id.textView_arabic, R.id.textView_english})
    public void onViewClicked(View view) {
        Intent intent = null;

        switch (view.getId()) {

            case R.id.myaccount:
                intent = new Intent(getContext(), ProfileActivity.class);
                getContext().startActivity(intent);

                break;

            case R.id.profile_info_lay:
                intent = new Intent(getContext(), ProfileActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.notifications:
                intent = new Intent(getContext(), NotificationsActivity.class);
                getContext().startActivity(intent);

                break;
            case R.id.about_us:
                intent = new Intent(getContext(), About_Us_Activity.class);
                getContext().startActivity(intent);
                break;
            case R.id.contatc_us:
                intent = new Intent(getContext(), ContactUsActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.login_logout:

                intent = new Intent(getContext(), LoginActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.textView_arabic:

                if (isArabic())
                    languageUtils.setEnglishLocale();
                else
                    languageUtils.setArabicLocale();

                goToMain();
                break;

            case R.id.textView_english:

                if (isArabic())
                    languageUtils.setEnglishLocale();
                else
                    languageUtils.setArabicLocale();

                goToMain();
                break;
        }
    }
}
