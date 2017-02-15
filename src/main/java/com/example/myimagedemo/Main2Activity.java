package com.example.myimagedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
   private GridView gridView;
   private Imageloader imageloader;
    private ArrayList<String> list=new ArrayList<>();
    private Myadapter myadapter;
    private int height;//屏幕宽高

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
          init();
        initdata();
        initadapter();
    }

    private void initadapter() {
        myadapter=new Myadapter();
        gridView.setAdapter(myadapter);
    }

    private void init() {
        gridView= (GridView) findViewById(R.id.gridv);
        height=getResources().getDisplayMetrics().heightPixels;
        imageloader=Imageloader.getimageloader();

    }

    private void initdata() {
        for(int i=0;i<images.imgs.length;i++){
            list.add(images.imgs[i]);

        }
    }

    class Myadapter extends BaseAdapter{

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= LayoutInflater.from(Main2Activity.this).inflate(R.layout.rlitem,viewGroup,false);
            AbsListView.LayoutParams params= (AbsListView.LayoutParams) view.getLayoutParams();
            params.height=height/2;
            view.setLayoutParams(params);

            ImageView iv= (ImageView) view.findViewById(R.id.imagev);

            imageloader.loadimage(list.get(i),iv);
            return view;
        }


    }
}
