package arifaidulhaikal.tokopedia;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class LandingActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private View[] dots;
    private int[] images = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_landing);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        // Initialize ViewPager2
        viewPager = findViewById(R.id.view_pager_slider);
        SliderAdapter adapter = new SliderAdapter(images);
        viewPager.setAdapter(adapter);
        
        // Initialize dots
        dots = new View[]{
            findViewById(R.id.dot_0),
            findViewById(R.id.dot_1),
            findViewById(R.id.dot_2)
        };
        
        // Set up ViewPager2 page change callback
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                updateDots(position);
            }
        });
        
        // Set colored text for terms TextView
        TextView tvTerms = findViewById(R.id.tv_terms);
        String termsText = "Dengan mendaftar, saya menyetujui Syarat & Ketentuan serta Kebijakan Privasi.";
        SpannableString spannableString = new SpannableString(termsText);
        
        // Color "Syarat & Ketentuan" in green
        int startSyarat = termsText.indexOf("Syarat & Ketentuan");
        int endSyarat = startSyarat + "Syarat & Ketentuan".length();
        spannableString.setSpan(
            new ForegroundColorSpan(Color.parseColor("#00AA5B")),
            startSyarat,
            endSyarat,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        
        // Color "Kebijakan Privasi" in green
        int startKebijakan = termsText.indexOf("Kebijakan Privasi");
        int endKebijakan = startKebijakan + "Kebijakan Privasi".length();
        spannableString.setSpan(
            new ForegroundColorSpan(Color.parseColor("#00AA5B")),
            startKebijakan,
            endKebijakan,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        
        tvTerms.setText(spannableString);
    }
    
    private void updateDots(int position) {
        for (int i = 0; i < dots.length; i++) {
            ViewGroup.LayoutParams params = dots[i].getLayoutParams();
            if (i == position) {
                // Active dot
                params.width = dpToPx(24);
                dots[i].setBackgroundResource(R.drawable.dot_active);
            } else {
                // Inactive dot
                params.width = dpToPx(6);
                dots[i].setBackgroundResource(R.drawable.dot_inactive);
            }
            dots[i].setLayoutParams(params);
        }
    }
    
    private int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}