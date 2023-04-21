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
import py.edu.facitec.mymail.Utils.Util;

public class EmailAdapter extends BaseAdapter {

    private Context context;
    private List<Email> emails;
    private final int SUBJECT_MAX_LENGHT = 40;
    private final int MESSAGE_MAX_LENGHT = 80;

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
        ViewHolder viewHolder;
        if(convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.subject= (TextView) convertView.findViewById(R.id.subjectTextView);
            viewHolder.sender= (TextView) convertView.findViewById(R.id.senderTextView);
            viewHolder.message= (TextView) convertView.findViewById(R.id.messageTextView);

        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        Email email = emails.get(position);
        String shortSubject;
        if(email.getSubject().length() < SUBJECT_MAX_LENGHT){
            shortSubject = email.getSubject();

        }else{
            shortSubject = email.getSubject().substring(0,SUBJECT_MAX_LENGHT) + "...";
        }
        viewHolder.subject.setText(shortSubject);

        String shortMessage;
        if(email.getSubject().length() > MESSAGE_MAX_LENGHT){
            shortMessage = email.getMessage().substring(0,MESSAGE_MAX_LENGHT) + "...";
        }else{
            shortMessage = email.getMessage();
        }
        viewHolder.message.setText(shortMessage);

        viewHolder.sender.setText(email.getSender().substring(0,1));
        viewHolder.sender.getBackground().setColorFilter(Color.parseColor(Util.getRandomColor()), PorterDuff.Mode.SRC);

        return convertView;
    }

    static class ViewHolder{
       private TextView subject;
       private TextView message;
       private TextView sender;

    }
}
