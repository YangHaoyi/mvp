package com.yhy.mvp.model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.yhy.mvp.R;
import com.yhy.mvp.presenter.MyPresenter;
import com.yhy.mvp.view.MvpView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yhy on 2016/5/16.
 */
public class MvpActivity extends AppCompatActivity implements MvpView, AdapterView.OnItemClickListener {

    ListView listView;
   MyPresenter myPresenter;
    ProgressBar pb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        myPresenter.onResume();
    }

    private void initView(){

        listView = (ListView) findViewById(R.id.mvp_listview);
        pb = (ProgressBar) findViewById(R.id.mvp_loading);
        listView.setOnItemClickListener(this);
        myPresenter = new MyPresenter(this);

    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setListItem(List<String> data) {

        ArrayAdapter adapter = new ArrayAdapter(MvpActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        myPresenter.onItemClick(position);
    }
}
