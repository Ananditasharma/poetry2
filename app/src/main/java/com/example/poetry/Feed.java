package com.example.poetry;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.ViewGroup;

public class Feed extends Fragment {
    GridLayout gridLayout;
    TextView a,b,c,d,e,f,h;
    OnadddocListener adddocListener;
    public interface OnadddocListener
    {
        public void adddoc();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed, container, false);
        gridLayout=(GridLayout)view.findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);

        return view;

    }
    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Toast.makeText(getActivity(),"Clicked at index "+ finalI,
                     //       Toast.LENGTH_SHORT).show();
                    adddocListener.adddoc();

                }
            });
        }
    }
    public void onAttach(Context context) {

        super.onAttach(context);
        Activity activity = (Activity) context;

        adddocListener =(OnadddocListener) activity;
    }

}