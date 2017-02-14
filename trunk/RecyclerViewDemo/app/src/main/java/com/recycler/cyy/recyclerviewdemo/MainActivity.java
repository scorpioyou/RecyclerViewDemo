package com.recycler.cyy.recyclerviewdemo;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.recycler.lib.OnItemClickListener;
import com.recycler.lib.RecyclerAdatper;
import com.recycler.lib.RecyclerHolder;
import com.recycler.lib.RecyclerViewDivider;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHorizontal;
    private RecyclerView rvVertical;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHorizontal = (RecyclerView) findViewById(R.id.rv_main_horizontal);
        rvVertical = (RecyclerView) findViewById(R.id.rv_main_vertical);

        initView();
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvHorizontal.setLayoutManager(layoutManager);
        RecyclerViewDivider divder = new RecyclerViewDivider(false); // 创业分割，false为HORIZONTAL
        divder.setColor(0xff5ED0F2); // 分割线颜色
        divder.setMargin(this, 0, 15, 0, 15);  // 分割线边距
        divder.setDividerHeight(this, 1);// 分割线宽度
        rvHorizontal.addItemDecoration(divder);
        DataAdapter dataAdapter = new DataAdapter(this);
        rvHorizontal.setAdapter(dataAdapter);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVertical.setLayoutManager(layoutManager);
        divder = new RecyclerViewDivider(true);// 创业分割，true为VERTICAL
        divder.setMargin(10, 10, 10, 10); // 分割线边距
        divder.setDividerHeight(50);// 分割线宽度 50要大于（10+10）
        // 分割线Drawable
        divder.setDrawable(ContextCompat.getDrawable(this, R.drawable.circle_bg));
        rvVertical.addItemDecoration(divder);
        DataAdapter dataAdapter1 = new DataAdapter(this);
        rvVertical.setAdapter(dataAdapter1);

        OnItemClickListener listener = new OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerHolder holder, int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        };
         // 设置监听
        dataAdapter.setOnItemClickListener(listener);
        dataAdapter1.setOnItemClickListener(listener);
    }


    public class DataAdapter extends RecyclerAdatper<Data> {

        public DataAdapter(Context context, List<Data> list) {
            super(context, list);
        }


        public DataAdapter(Context context) {
            super(context);
            for (int i = 0; i < 20; i++) {
                Data data = new Data();
                data.setName("Name:" + i);
                getList().add(data);
            }
        }


        @Override
        public int getContentView(int viewType) {
            return R.layout.item_main_data;
        }

        @Override
        public void onInitView(RecyclerHolder holder, Data object, int position) {
            holder.setText(R.id.tv_item_main_name, object.getName());
        }

    }
}
