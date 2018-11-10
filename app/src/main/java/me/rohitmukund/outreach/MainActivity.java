package me.rohitmukund.outreach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import me.rohitmukund.outreach.Internals.Contributors;
import me.rohitmukund.outreach.Internals.Contributors1;
import me.rohitmukund.outreach.Internals.Contributors10;
import me.rohitmukund.outreach.Internals.Contributors11;
import me.rohitmukund.outreach.Internals.Contributors12;
import me.rohitmukund.outreach.Internals.Contributors13;
import me.rohitmukund.outreach.Internals.Contributors14;
import me.rohitmukund.outreach.Internals.Contributors15;
import me.rohitmukund.outreach.Internals.Contributors16;
import me.rohitmukund.outreach.Internals.Contributors17;
import me.rohitmukund.outreach.Internals.Contributors2;
import me.rohitmukund.outreach.Internals.Contributors3;
import me.rohitmukund.outreach.Internals.Contributors4;
import me.rohitmukund.outreach.Internals.Contributors5;
import me.rohitmukund.outreach.Internals.Contributors6;
import me.rohitmukund.outreach.Internals.Contributors7;
import me.rohitmukund.outreach.Internals.Contributors8;
import me.rohitmukund.outreach.Internals.Contributors9;

public class MainActivity extends AppCompatActivity
{
    final String url = "https://api.github.com/orgs/JBossOutreach/repos";
    Contributors contributors = new Contributors();
    ArrayList<String> repositories;
    Information info = new Information();
    int counter = 0;
    public int getCounter() {
        return counter;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        repositories = new ArrayList<>();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repositories);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Intent myIntent = new Intent(view.getContext(),Contributors.class);
                    startActivityForResult(myIntent, 0);
                    stopService(myIntent);

                }
                if(position == 1) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors1.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 2) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors2.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 3) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors3.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 4) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors4.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 5) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors5.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 6) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors6.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 7) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors7.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 8) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors8.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 9) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors9.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 10) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors10.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 11) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors11.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 12) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors12.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 13) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors13.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 14) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors14.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 15) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors15.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 16) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors16.class);
                    startActivityForResult(myIntent2, 0);
                }
                if(position == 17) {
                    Intent myIntent2 = new Intent(view.getContext(),Contributors17.class);
                    startActivityForResult(myIntent2, 0);
                }
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("MainActivity", response);

                try
                {
                    JSONArray arr = new JSONArray(response);
                    for (int i = 0; i < arr.length(); i++)
                    {
                        JSONObject part = arr.getJSONObject(i);
                        String repoName = part.getString("name");

                        repositories.add(repoName);
                        arrayAdapter.notifyDataSetChanged();
                    }

                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }


}
