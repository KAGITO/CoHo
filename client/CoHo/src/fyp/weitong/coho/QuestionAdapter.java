package fyp.weitong.coho;

import java.util.List;

import com.example.homeactivity.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class QuestionAdapter extends ArrayAdapter<Question>{
	
	private int resourceId;
    private Question question;


    public QuestionAdapter(Context context, int textViewResourceId,
                           List<Question> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	Question question = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        
        TextView title111 = (TextView) view.findViewById(R.id.item_t);
        title111.setText(question.getTitle());



        return view;
    }


}
