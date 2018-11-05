package me.rohitmukund.outreach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

public class MainActivity extends AppCompatActivity
{
    final String url = "https://api.github.com/orgs/JBossOutreach/repos";
    ArrayList<String> repositories;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list);
        repositories = new ArrayList<>();

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repositories);
        listView.setAdapter(arrayAdapter);

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
