package fyp.weitong.coho;


import com.example.homeactivity.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class QuestionShowActivity extends Activity {
	
	private EditText mEdtTitle ;
	private EditText mEdtContent;
	private Button mBtnSave;
	private Button mBtnDelete;
	private Question quetion;
	
	private String mOrgTitle;		
	private String mOrgContent;		
	private String mId;	
	String title;
	String content;
	private Question question; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
				
		Intent intent = getIntent();
		Question question = (Question) intent.getSerializableExtra("question");
		
		title = question.getTitle();
		content = question.getContent();
		TextView title222 = (TextView)findViewById(R.id.itemnote_title_edit);
        title222.setText(title);
        
        TextView content222 = (TextView)findViewById(R.id.itemnote_content_edit);
        content222.setText(content);
				
	}
	

	
	
}
