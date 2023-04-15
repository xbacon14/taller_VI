package py.edu.facitec.mymail.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import py.edu.facitec.mymail.Models.Email;
import py.edu.facitec.mymail.R;

public class EmailAdapter extends BaseAdapter {

    private Context context;
    private List<Email> emails;

    public EmailAdapter(Context context, List<Email> emails) {
        this.context = context;
        this.emails = emails;
    }

    @Override
    public int getCount() {
        return this.emails.size();
    }

    @Override
    public Object getItem(int position) {
        return this.emails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
        }
        Email email = emails.get(position);
        TextView senderTextView = convertView.findViewById(R.id.senderTextView);
        senderTextView.getBackground().setColorFilter(Color.parseColor(email.getColor()), PorterDuff.Mode.SRC);
        TextView subjectTextView = convertView.findViewById(R.id.subjectTextView);
        TextView messageTextView = convertView.findViewById(R.id.messageTextView);

        senderTextView.setText(email.getSender().substring(0,1).toUpperCase());
        subjectTextView.setText(email.getSubject());
        messageTextView.setText(email.getMessage().substring(0,50));

        return convertView;
    }
}
