package com.chenxu.material.design.mdtest;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chenxu.material.design.mdtest.adapter.BeautyAdapter;
import com.chenxu.material.design.mdtest.bean.Beauty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Beauty[] beauties={new Beauty("皇上",R.mipmap.image_a),
            new Beauty("皇阿玛",R.mipmap.image_b),new Beauty("奥巴马",R.mipmap.image_j),
            new Beauty("父皇",R.mipmap.image_d),new Beauty("艾欧尼亚",R.mipmap.image_k),
            new Beauty("爹地",R.mipmap.image_c),new Beauty("超人",R.mipmap.image_m),
            new Beauty("Father",R.mipmap.image_e),new Beauty("钢铁侠",R.mipmap.image_l),
            new Beauty("太上皇",R.mipmap.image_f),new Beauty("雷神",R.mipmap.image_o),
            new Beauty("我是你爸爸",R.mipmap.image_g),new Beauty("暗影岛",R.mipmap.image_p),
            new Beauty("我是你哥哥",R.mipmap.image_h),new Beauty("黑色玫瑰",R.mipmap.image_q),
            new Beauty("我是你爷爷",R.mipmap.image_i),new Beauty("紫色诱惑",R.mipmap.image_a),
            };

    private List<Beauty> mBeautyList=new ArrayList<>();
    private RecyclerView mRecyclerView;
    private BeautyAdapter adapter;
    private SwipeRefreshLayout reFresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBeautys();
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        reFresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        adapter = new BeautyAdapter(mBeautyList);
        mRecyclerView.setAdapter(adapter);
        reFresh.setColorSchemeResources(R.color.colorPrimary);
        reFresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reFreshBeauties();
            }
        });
    }

    private void reFreshBeauties() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initNewBeautys();
                        adapter.notifyDataSetChanged();
                        reFresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    private void initNewBeautys() {
        mBeautyList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(beauties.length);
            mBeautyList.add(beauties[index]);

        }
    }

    private void initBeautys() {
        mBeautyList.clear();
        for (Beauty beauty : beauties) {
            mBeautyList.add(beauty);
        }
    }
}
