package com.example.lamps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    public static final int RADIUS = 50;
    public static final int MARGIN = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView view = (GridView) findViewById(R.id.GridView);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        int columns = (height / (RADIUS + MARGIN)) - 1;
        int rows = (width / (RADIUS + MARGIN)) - 1;

        ArrayList<Lamp> lamps = new ArrayList<>();

        for (int i = 0; i < columns; i++) {
            for(int j = 0; j < rows; j++) {
                lamps.add(new Lamp(this));
            }
        }
        view.setAdapter(new LampAdapter(this, lamps));
    }
}
class LampAdapter extends ArrayAdapter<Lamp> {

    public LampAdapter(@NonNull Context context, ArrayList<Lamp> object) {
        super(context, 0, object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        getItem(position).setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT,MainActivity.RADIUS + MainActivity.MARGIN));
        return getItem(position);
    }
}