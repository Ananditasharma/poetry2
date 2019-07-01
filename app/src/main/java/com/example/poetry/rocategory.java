package com.example.poetry;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class rocategory extends Fragment {
    TextView a;
    OnRoPoemActivityListener RoPoemActivityListener;
    public interface OnRoPoemActivityListener
    {
        public void performAdd();

    }

    public rocategory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_rocategory, container, false);
        a = view.findViewById(R.id.txt1);

        a.setOnClickListener(new View.OnClickListener() {
            @NonNull
            @Override
            public void onClick(View v) {
                RoPoemActivityListener.performAdd();
            }
        });
        return view;
    }



}
