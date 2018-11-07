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

public class MainActivity extends AppCompatActivity
{
    final String url = "https://api.github.com/orgs/JBossOutreach/repos";
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

                switch (position) {
                    case 0:
                        Intent myintent = new Intent(view.getContext(),Option1.class);
                        info.setCounter(0);
                        startActivityForResult(myintent,0);
                        break;
                    case 1:
                        Intent myintent2 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(1);
                        startActivity(myintent2);
                        startActivityForResult(myintent2,0);
                        finish();
                        startActivity(getIntent());
                        break;
                    case 2:
                        Intent myintent3 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(2);
                        startActivityForResult(myintent3,0);
                        break;
                    /*8case 3:
                        Intent myintent4 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(3);
                        startActivityForResult(myintent4,0);
                        break;

                    case 4:
                        Intent myintent5 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(4);
                        startActivityForResult(myintent5,0);
                        break;
                    case 5:
                        Intent myintent6 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(5);
                        startActivityForResult(myintent6,0);
                        break;
                    case 6:
                        Intent myintent7 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(6);
                        startActivityForResult(myintent7,0);
                        break;
                    case 7:
                        Intent myintent8 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(7);
                        startActivityForResult(myintent8,0);
                        break;
                    case 8:
                        Intent myintent9 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(8);
                        startActivityForResult(myintent9,0);
                        break;
                    case 9:
                        Intent myintent10 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(9);
                        startActivityForResult(myintent10,0);
                        break;
                    case 10:
                        Intent myintent11 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(10);
                        startActivityForResult(myintent11,0);
                        break;
                    case 11:
                        Intent myintent12 = new Intent(view.getContext(),Option1.class);

                        info.setCounter(11);
                        startActivityForResult(myintent12,0);
                        break;
                    case 12:
                        Intent myintent13 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(12);
                        startActivityForResult(myintent13,0);
                        break;
                    case 13:
                        Intent myintent14 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(13);
                        startActivityForResult(myintent14,0);
                        break;
                    case 14:
                        Intent myintent15 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(14);
                        startActivityForResult(myintent15,0);
                        break;
                    case 15:
                        Intent myintent16 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(15);
                        startActivityForResult(myintent16,0);
                        break;
                    case 16:
                        Intent myintent17 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(16);
                        startActivityForResult(myintent17,0);
                        break;
                    case 17:
                        Intent myintent18 = new Intent(view.getContext(),Option1.class);
                        info.setCounter(17);
                        startActivityForResult(myintent18,0);
                        break;
*/

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
