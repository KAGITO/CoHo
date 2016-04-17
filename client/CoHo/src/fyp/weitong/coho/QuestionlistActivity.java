package fyp.weitong.coho;


import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import  com.example.homeactivity.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;




public class QuestionlistActivity extends Activity {
	Question question;
	private Button mBtnAdd;
	private ListView mListView;
	List<Question> Questionlist = new ArrayList<Question>();
	QuestionAdapter adapter;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feed);
		
		adapter = new QuestionAdapter(QuestionlistActivity.this,R.layout.listitem, Questionlist);
		mListView = (ListView) this.findViewById(R.id.notelist_listview);
		mListView.setAdapter(adapter);
		
		
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent,  View view, int position, long id) {
                Context context = view.getContext();
                Question question1 = Questionlist.get(position);

                Intent i = new Intent(context, QuestionShowActivity.class);
                i.putExtra("question", question1);
                startActivity(i);
            }

        });
		
		
		
		
		
		HttpAsyncTask task = new HttpAsyncTask();
        task.execute("http://3a5822b7.ngrok.io//getquestion.js");
		
	}
	
	

	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GetQuestion.POST(urls[0], QuestionlistActivity.this.question);

        }
            @Override
            protected void onPostExecute(String result) {


                String parseresult=parse(result);
                if(parseresult.equals("success")){
                    Toast.makeText(QuestionlistActivity.this, "Conncted!", Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(QuestionlistActivity.this, "fails", Toast.LENGTH_LONG).show();
                }


            }
        }

        private String parse(String result) {
            String results="";

            try {
                JSONArray jArray = new JSONArray(result);
                for (int i = 0; i < jArray.length(); i++) {
                    JSONObject temp = (JSONObject)jArray.get(i);
                   
                    String title = temp.getString("title");
                    String content = temp.getString("content");
                    

                    question = new Question();
                    question.setTitle(title);
                    question.setContent(content);
                    
                    
                    Questionlist.add(question);
                    



                }

                adapter.notifyDataSetChanged();


                if(!result.equals(null)){
                    results = "success";
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return results;

        }
	
	
	
	
	
	
}
	


