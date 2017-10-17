package com.example.transferstation;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.transferstation.model.Row;
import com.example.transferstation.model.SubwayTransitInfo;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<Row> list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        load();
    }

    private void load() {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... urlString) {
                String result = Remote.getData(urlString[0]);
                Log.d("확인", result);
                return result;
            }

            @Override
            protected void onPostExecute(String str) {
                super.onPostExecute(str);
                list = parse(str);
                Log.d("확인", str);
                setListener();
            }
        }.execute("http://openapi.seoul.go.kr:8088/686a766b466a697334385a717a6e51/json/StationDayTrnsitNmpr/1/44/");
    }

    private ArrayList<Row> parse(String string) {
        Gson gson = new Gson();
        SubwayTransitInfo info = gson.fromJson(string, SubwayTransitInfo.class); //항상 최상위 클래스를 가져와야 한다.
        List<Row> list = info.getStationDayTrnsitNmpr().getRow();
        //ArrayList<Row> list = (ArrayList) Arrays.asList(row);
        return (ArrayList) list;


    }

    private void setListener() {
        MyAdapter myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
