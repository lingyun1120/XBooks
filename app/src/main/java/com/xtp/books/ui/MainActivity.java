package com.xtp.books.ui;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xtp.books.R;
import com.xtp.books.base.BaseActivity;


public class MainActivity extends BaseActivity {

    Toolbar toolbar;
    RecyclerView rvList;
    SmartRefreshLayout refreshLayout;

    private BookAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mImmersionBar
                .titleBar(toolbar)
                .statusBarDarkFont(true, 0.2f)
                .navigationBarEnable(false)
                .init();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        rvList = findViewById(R.id.rvList);
        refreshLayout = findViewById(R.id.refreshLayout);
        setSupportActionBar(toolbar);

        mAdapter = new BookAdapter(this);
        LinearLayoutManager linear = new LinearLayoutManager(this);
        rvList.setLayoutManager(linear);
        rvList.setAdapter(mAdapter);
        rvList.setHasFixedSize(true);

        refreshLayout.setOnRefreshListener(layout -> {
            refreshLayout.postDelayed(() -> {
                mAdapter.setData(DataManager.getBookList());
                refreshLayout.finishRefresh();
            }, 2000);
        });
        refreshLayout.autoRefresh();
    }
}
