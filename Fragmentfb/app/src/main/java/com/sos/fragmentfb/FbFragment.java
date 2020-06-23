package com.sos.fragmentfb;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


/**
 * A simple {@link Fragment} subclass.
 */
public class FbFragment extends Fragment {
Button d;
FirebaseAuth auth;
    public FbFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View v=inflater.inflate(R.layout.fragment_fb, container, false);

    d=v.findViewById(R.id.button2);
        auth = FirebaseAuth.getInstance();
    d.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            auth.signOut();
        }
    });

        return v ;
    }

}
