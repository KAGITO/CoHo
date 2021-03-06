package fyp.weitong.coho;

import java.io.IOException;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.homeactivity.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import fyp.json.android.UrlJsonAsyncTask;

public class LoginActivity extends Activity{
	private final static String LOGIN_API_ENDPOINT_URL = "http://3a5822b7.ngrok.io//login";
	private SharedPreferences mPreferences;
	private String mUserEmail;
	private String mUserPassword;
	Button registerButton;
	Button demoButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_login);

	    
	    mPreferences = getSharedPreferences("CurrentUser", MODE_PRIVATE);
	    
	    registerButton = (Button) findViewById(R.id.registerButton);
	    
	    registerButton.setOnClickListener(new OnClickListener(){
	    	public void onClick(View v){
	    		Intent signUp =new Intent();
	    		signUp.setClass(LoginActivity.this,RegisterActivity.class);
	    		startActivity(signUp);
	    	}
	    });
	    
	    demoButton = (Button) findViewById(R.id.demoButton);
	    
	    demoButton.setOnClickListener(new OnClickListener(){
	    	public void onClick(View v){
	    		Intent demo =new Intent();
	    		demo.setClass(LoginActivity.this,MainActivity.class);
	    		startActivity(demo);
	    	}
	    });
	}
	
	public void login(View button) {
	    EditText userEmailField = (EditText) findViewById(R.id.userEmail);
	    mUserEmail = userEmailField.getText().toString();
	    EditText userPasswordField = (EditText) findViewById(R.id.userPassword);
	    mUserPassword = userPasswordField.getText().toString();

	    if (mUserEmail.length() == 0 || mUserPassword.length() == 0) {
	        Toast.makeText(this, "Please complete all the fields",
	            Toast.LENGTH_LONG).show();
	        return;
	    } else {
	        LoginTask loginTask = new LoginTask(LoginActivity.this);
	        loginTask.setMessageLoading("Logging in...");
	        loginTask.execute(LOGIN_API_ENDPOINT_URL);
	    }
	}
	
	private class LoginTask extends UrlJsonAsyncTask {
	    public LoginTask(Context context) {
	        super(context);
	    }

	    @Override
	    protected JSONObject doInBackground(String... urls) {
	        DefaultHttpClient client = new DefaultHttpClient();
	        HttpPost post = new HttpPost(urls[0]);
	        JSONObject holder = new JSONObject();
	        JSONObject userObj = new JSONObject();
	        String response = null;
	        JSONObject json = new JSONObject();

	        try {
	            try {
	                userObj.put("password", mUserPassword);
	                userObj.put("email", mUserEmail);
	                StringEntity se = new StringEntity(userObj.toString());
	                post.setEntity(se);

	                post.setHeader("Accept", "application/json");
	                post.setHeader("Content-Type", "application/json");

	                ResponseHandler<String> responseHandler = new BasicResponseHandler();
	                response = client.execute(post, responseHandler);
	                json = new JSONObject(response);

	            } catch (HttpResponseException e) {
	                e.printStackTrace();
	                Log.e("ClientProtocol", "" + e);
	                json.put("info", "Email and/or password are invalid. Retry!");
	            } catch (IOException e) {
	                e.printStackTrace();
	                Log.e("IO", "" + e);
	            }
	        } catch (JSONException e) {
	            e.printStackTrace();
	            Log.e("JSON", "" + e);
	        }

	        return json;
	    }

	    
	    @Override
	    protected void onPostExecute(JSONObject json) {
	        try {
	            if (!json.toString().contains("error")) {
	                Intent intent = new Intent(getApplicationContext(), QuestionlistActivity.class);
	                startActivity(intent);
	            }
	        } catch (Exception e) {
	            Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
	        } finally {
	            super.onPostExecute(json);
	        }
	    }
	}

}
