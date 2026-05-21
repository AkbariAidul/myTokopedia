package arifaidulhaikal.tokopedia;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try {
            Log.d(TAG, "Setting content view");
            setContentView(R.layout.activity_splash);
            Log.d(TAG, "Content view set successfully");
            
            // Inisialisasi tombol Mulai Belanja
            Button btnMulai = findViewById(R.id.btn_mulai);
            btnMulai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Log.d(TAG, "Button clicked, starting LoginActivity");
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    } catch (Exception e) {
                        Log.e(TAG, "Error starting LoginActivity", e);
                    }
                }
            });
            
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
        }
    }
}
