package me.rohitmukund.outreach.Internals;

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

import me.rohitmukund.outreach.Information;
import me.rohitmukund.outreach.R;

public class Contributors2 extends AppCompatActivity
{
    ArrayList<String> repositorie;
    Information info = new Information();
    final String url = "https://api.github.com/repos/JBossOutreach/lead-management-android/contributors";
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        ListView listView = findViewById(R.id.lists);
        repositorie = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, repositorie);
        listView.setAdapter(arrayAdapter);


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.d("Contributors", response);

                try
                {
                    JSONArray arr = new JSONArray(response);
                    for (int i = 0; i < arr.length(); i++)
                    {
                        JSONObject part = arr.getJSONObject(i);
                        String repoName = part.getString("login");

                        repositorie.add(repoName);
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
