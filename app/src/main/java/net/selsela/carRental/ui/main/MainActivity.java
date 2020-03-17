package net.selsela.carRental.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.data.model.config.Time;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.explore.ExploreFragment;
import net.selsela.carRental.ui.orders_fragment.ordersFragment;
import net.selsela.carRental.ui.settings.SettingsFragment;
import net.selsela.carRental.util.Const;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

public class
MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    @BindView(R.id.nav_view)
    BottomNavigationView navView;
    @BindView(R.id.add_image)
    ImageView addImage;
    @BindView(R.id.text_add)
    TextView textAdd;
    @BindView(R.id.text_myestate)
    TextView textMyestate;
    @BindView(R.id.container)
    CoordinatorLayout container;
    Fragment home_fragment = new HomeFragment();
    Fragment settings_fragment = new SettingsFragment();
    Fragment explore_fragmet = new ExploreFragment();
    Fragment orders_fragment = new ordersFragment();

    Fragment active = home_fragment;

     int Flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        // Toolbar toolbar = findViewById(R.id.toolbar);


        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, home_fragment, "1").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, explore_fragmet, "2").hide(explore_fragmet).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, orders_fragment, "3").hide(orders_fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, settings_fragment, "4").hide(settings_fragment).commit();



        setSupportActionBar(toolbar);
        initToolbar();
        hideToolbar();
             if (getIntent().hasExtra(Const.Name)){

            hideToolbar();
            toolbar.setTitle(R.string.orders);
            getSupportFragmentManager().beginTransaction().hide(active).show(orders_fragment).commit();
            active = orders_fragment;

        }else if(getIntent().hasExtra(Const.TYPE)){

                 hideToolbar();
                 getSupportFragmentManager().beginTransaction().hide(active).show(home_fragment).commit();
                 active = home_fragment;


             }
             else if (getIntent().hasExtra(Const.Reg)){

                 hideToolbar();
                 toolbar.setTitle(R.string.explore_cars_label);
                 getSupportFragmentManager().beginTransaction().hide(active).show(explore_fragmet).commit();
                 active = explore_fragmet;

             }

        navView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.rent_car:
                hideToolbar();
                getSupportFragmentManager().beginTransaction().hide(active).show(home_fragment).commit();
                active = home_fragment;
                return true;
            case R.id.explore_cars:
                hideToolbar();
                toolbar.setTitle(R.string.explore_cars_label);
                getSupportFragmentManager().beginTransaction().hide(active).show(explore_fragmet).commit();
                active = explore_fragmet;
                return true;
            case R.id.orders:
                hideToolbar();
                toolbar.setTitle(R.string.orders);
                getSupportFragmentManager().beginTransaction().hide(active).show(orders_fragment).commit();
                active = orders_fragment;
                return true;
            case R.id.settings:
                hideToolbar();
                getSupportFragmentManager().beginTransaction().hide(active).show(settings_fragment).commit();
                active = settings_fragment;
                return true;

        }
        return false;
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (Flag == 1){
            Timber.d("11test");
        getMenuInflater().inflate(R.menu.reload, menu);
    }

        return true;
    }


    public void showToolbar() {
        if (getSupportActionBar() != null)
            getSupportActionBar().show();


    }



    @Override
    public void initToolbar() {
        super.initToolbar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(false);
        }

    }
}




