package arifaidulhaikal.tokopedia;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        // Set status bar to white with dark icons
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.WHITE);
            
            // Set status bar icons to dark
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                WindowInsetsControllerCompat windowInsetsController =
                        WindowCompat.getInsetsController(window, window.getDecorView());
                if (windowInsetsController != null) {
                    windowInsetsController.setAppearanceLightStatusBars(true);
                }
            }
        }

        final EditText etLogin = findViewById(R.id.et_login);
        Button btnMasuk = findViewById(R.id.btn_masuk);
        ImageView ivClose = findViewById(R.id.iv_close);

        // Close button to go back to LandingActivity
        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close current activity and return to previous activity
            }
        });

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = etLogin.getText().toString().trim();
                if (!input.isEmpty()) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Masukkan Nomor HP atau Email", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        // Set colored text for bottom register TextView
        TextView tvBottomRegister = findViewById(R.id.tv_bottom_register);
        String registerText = "Belum punya akun? Daftar";
        SpannableString spannableString = new SpannableString(registerText);
        
        // Color "Daftar" in green
        int startDaftar = registerText.indexOf("Daftar");
        int endDaftar = startDaftar + "Daftar".length();
        spannableString.setSpan(
            new ForegroundColorSpan(Color.parseColor("#00AA5B")),
            startDaftar,
            endDaftar,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        
        tvBottomRegister.setText(spannableString);
    }
}
