package py.edu.facitec.mymail.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import py.edu.facitec.mymail.Models.Email;
import py.edu.facitec.mymail.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class DetailsFragment extends Fragment {

    TextView subject;
    TextView sender;
    TextView message;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_details, container, false);
        subject = view.findViewById(R.id.subjectTextView);
        sender = view.findViewById(R.id.senderTextView);
        message = view.findViewById(R.id.messageTextView);
        return view;
    }

    public void render(Email e){
        subject.setText(e.getSubject());
        sender.setText(e.getSender());
        message.setText(e.getMessage());
    }
}