package fyp.weitong.coho;


import android.os.Bundle;
import android.os.Handler;
import fyp.weitong.coho.LoginActivity;
import fyp.weitong.coho.Splash;
import android.app.Activity;
import android.content.Intent;
import com.example.homeactivity.R;

public class Splash extends Activity {
    
    private boolean 			mIsBackButtonPressed;
    private static final int 	SPLASH_DURATION = 3000; 
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
       
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                
                finish();
                 
                if (!mIsBackButtonPressed) {           
                    Splash.this.startActivity(new Intent(Splash.this, LoginActivity.class));
               }       
            }
        }, SPLASH_DURATION);
    }
 
    @Override
   public void onBackPressed() {
        mIsBackButtonPressed = true;
        super.onBackPressed();
    }
}