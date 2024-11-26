package it.unimib.worldnews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

public class PickCategoriesActivity extends AppCompatActivity {

    public static final String TAG = PickCategoriesActivity.class.getName();
    private MaterialCardView sportcard;
    private MaterialCardView healthcard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pick_categories);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sportcard = findViewById(R.id.sport_card);
        healthcard = findViewById(R.id.health_card);

        sportcard.setOnClickListener(view -> {
            sportcard.setChecked(!sportcard.isChecked());
        });

        healthcard.setOnClickListener(view -> {
            healthcard.setChecked(!healthcard.isChecked());
        });



    }
}