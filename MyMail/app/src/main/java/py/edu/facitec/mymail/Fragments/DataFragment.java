package py.edu.facitec.mymail.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import py.edu.facitec.mymail.Adapters.EmailAdapter;
import py.edu.facitec.mymail.Models.Email;
import py.edu.facitec.mymail.R;
import py.edu.facitec.mymail.Utils.Util;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DataFragment extends Fragment {
    private ListView emailListView;
    private OnFragmentInteractionListener mListener;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        emailListView = view.findViewById(R.id.emailListView);
        emailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Email e = (Email) parent.getAdapter().getItem(position);
                mListener.onFragmentInteraction(e);
            }
        });

        // ArrayAdapter<Email> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, Util.getDummyData());
        EmailAdapter adapter = new EmailAdapter(getActivity(), Util.getDummyData());
        emailListView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Email email);
    }
}