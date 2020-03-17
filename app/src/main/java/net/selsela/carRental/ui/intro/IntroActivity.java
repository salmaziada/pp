package net.selsela.carRental.ui.intro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.selsela.carRental.R;
import net.selsela.carRental.ui.base.BaseActivity;
import net.selsela.carRental.ui.main.MainActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class IntroActivity extends BaseActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    ArrayList<String> intro = new ArrayList<>();
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.backgroundView)
    ImageView backgroundView;
    @BindView(R.id.label)
    TextView label;
    @BindView(R.id.selected)
    ImageView selected;
    @BindView(R.id.selected2)
    ImageView selected2;
    @BindView(R.id.selected3)
    ImageView selected3;
    @BindView(R.id.selected4)
    ImageView selected4;
    @BindView(R.id.start_btn)
    Button startBtn;
    private Animation animZoomout;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        ButterKnife.bind(this);
        getActivityComponent().inject(this);

        intro.add(0, getString(R.string.intro_label));
        intro.add(1, getString(R.string.intro_label));
        intro.add(2, getString(R.string.intro_label));
        intro.add(3, getString(R.string.intro_label));

        label.setText(intro.get(0));

        slide();

    }

    public void slide() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                label.setText(intro.get(i));
                animZoomout = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);
                label.setAnimation(animZoomout);
                if (i == 0) {
                    selected.setImageResource(R.drawable.selsetced_tetx);
                    selected2.setImageResource(R.drawable.unselected_text);
                    selected3.setImageResource(R.drawable.unselected_text);
                    selected4.setImageResource(R.drawable.unselected_text);

                } else if (i == 1) {
                    selected2.setImageResource(R.drawable.selsetced_tetx);
                    selected.setImageResource(R.drawable.unselected_text);
                    selected3.setImageResource(R.drawable.unselected_text);
                    selected4.setImageResource(R.drawable.unselected_text);

                } else if (i == 2) {
                    selected3.setImageResource(R.drawable.selsetced_tetx);
                    selected.setImageResource(R.drawable.unselected_text);
                    selected2.setImageResource(R.drawable.unselected_text);
                    selected4.setImageResource(R.drawable.unselected_text);
                } else if (i == 3) {
                    selected4.setImageResource(R.drawable.selsetced_tetx);
                    selected.setImageResource(R.drawable.unselected_text);
                    selected2.setImageResource(R.drawable.unselected_text);
                    selected3.setImageResource(R.drawable.unselected_text);
                }
                if (i < intro.size() - 1) {
                    i++;
                    slide();

                }


            }

        }, SPLASH_DISPLAY_LENGTH);
    }


    @OnClick(R.id.start_btn)
    public void onViewClicked() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

