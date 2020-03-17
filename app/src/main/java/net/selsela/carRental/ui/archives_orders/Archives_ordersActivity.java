package net.selsela.carRental.ui.archives_orders;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.archives_orders.adapter.ArchivesAdapter;
import net.selsela.carRental.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Archives_ordersActivity extends BaseActivity {

    @BindView(R.id.archives_rv)
    RecyclerView archivesRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archives_orders);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);
        activityTitle = getString(R.string.orders_archives_label);
        initToolbar();

        archivesRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        archivesRv.setAdapter(new ArchivesAdapter(this));
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
}
