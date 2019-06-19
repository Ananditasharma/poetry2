package com.example.poetry;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {

    private static final String HI = "http://192.168.1.4/Apiphp/poem.php";

    private RecyclerView rv;
    private List <List_data> list_data;

    private MyAdapter adapter;
    private JsonArrayRequest request;
    private RequestQueue requestQueue;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = (RecyclerView) view.findViewById(R.id.recyclerview);
        list_data = new ArrayList <>();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new MyAdapter(list_data, getContext());
        rv.setAdapter(adapter);
        getdata();

    }

    private void getdata() {
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.show();


        request = new JsonArrayRequest(HI, new Response.Listener <JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject ob = response.getJSONObject(i);
                        List_data listData = new List_data(ob.getInt("id"),
                                ob.getString("title"),
                                ob.getString("shortdesc"),
                                ob.getDouble("rating"),
                                ob.getString("poetry"),
                                ob.getString("image"));


                        list_data.add(listData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                //  setupData(list_data);
                progressDialog.dismiss();
                adapter.notifyDataSetChanged();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error", error.toString());
                progressDialog.dismiss();

            }
        });
        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);


    }

    private void setupData(List <List_data> list_data) {

        adapter = new MyAdapter(list_data, getContext());
        rv.setAdapter(adapter);

    }
}

