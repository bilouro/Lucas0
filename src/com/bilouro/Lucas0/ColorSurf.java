package com.bilouro.Lucas0;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.util.Random;

public class ColorSurf extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.lucas0_colorsurf_seekBar);
        seekBar.setMax(50);
        seekBar.setProgress(13);

        final Random rand = new Random();
        final LinearLayout ll = (LinearLayout) findViewById(R.id.lucas0_colorsurf_layout);

        ll.setOnTouchListener(new View.OnTouchListener() {
            int actual = 0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (actual >= seekBar.getProgress()) {
                    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    v.setBackgroundColor(Color.rgb(r, g, b));
                    actual = 0;
                    return true;
                }
                actual++;
                return true;
            }
        });
    }
}
