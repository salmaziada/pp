package net.selsela.carRental.data.remote;

import android.view.View;

import net.selsela.carRental.data.model.home.FlatService;


public interface CustomItemClickListener {

    public void onItemClick(View v, int position);
    public void update(FlatService flatService);



}
