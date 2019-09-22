package com.tigaes.android_java_bottom_sheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class MainActivity extends AppCompatActivity {

    Button btShow;
    Button btHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi LinearLayout sebagai base bottom sheet view
        final View bottomsheet = findViewById(R.id.bs_ll);

        //Assign LinearLayout tersebut ke BottomSheetBehavior
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);

        //Set BottomSheet view supaya bisa disembunyikan semuanya
        bottomSheetBehavior.setHideable(true);

        //Inisialisasi tombol
        btShow = findViewById(R.id.bt_show);
        btHide = findViewById(R.id.bt_hide);

        //Set listener dan set BottomSheet state
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    btShow.setText("Close Bottom Sheet");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    btShow.setText("Show Bottom Sheet");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        btHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                    btHide.setText("Hide");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    btHide.setText("Peek");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }

            }
        });

    }
}
