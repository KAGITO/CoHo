package fyp.weitong.coho;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.example.homeactivity.R;


public class MainActivity extends Activity {
	 final Activity activity = this;  
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		webView = (WebView) findViewById(R.id.webView);
		WebSettings settings = webView.getSettings();
		settings.setJavaScriptEnabled(true);	
		
             
            
		 
		 webView.setWebViewClient(new WebViewClient() {
			    @Override
			    public boolean shouldOverrideUrlLoading(WebView view, String url) {
			        view.loadUrl(url);
			        return false;
			    }
			});
			
		webView.loadUrl("https://3a5822b7.ngrok.io");
	}
	
		
}	