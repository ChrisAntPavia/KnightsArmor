package com.example.knightsarmor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Knights Armor is always dark, so keep the system bar icons light
        EdgeToEdge.enable(this, SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showScreen(R.layout.activity_main);
    }

    // UI-only demo navigation: swaps the visible layout so each screen can be shown in the emulator
    private void showScreen(int layout) {
        setContentView(layout);
        link(R.id.btn_login, R.layout.screen_onboarding);
        link(R.id.btn_continue, R.layout.screen_home);
        link(R.id.btn_filter, R.layout.screen_categories);
        link(R.id.btn_close_categories, R.layout.screen_home);
        link(R.id.pin_events, R.layout.screen_pin_detail);
        link(R.id.pin_alerts, R.layout.screen_pin_detail);
        link(R.id.pin_water, R.layout.screen_pin_detail);
        link(R.id.pin_events_2, R.layout.screen_pin_detail);
        link(R.id.btn_close_pin, R.layout.screen_home);
        link(R.id.scrim, R.layout.screen_home);
        link(R.id.btn_cancel_report, R.layout.screen_home);
        link(R.id.btn_submit_report, R.layout.screen_home);
        link(R.id.nav_map, R.layout.screen_home);
        link(R.id.nav_report, R.layout.screen_report);
        link(R.id.nav_profile, R.layout.screen_profile);
    }

    private void link(int viewId, int layout) {
        View view = findViewById(viewId);
        if (view != null) {
            view.setOnClickListener(v -> showScreen(layout));
        }
    }
}
