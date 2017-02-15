package com.example.myimagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     private Imageloader imageloader;
     private RecyclerView recyclerView;
     private ArrayList<String> list=new ArrayList<>();
    private Myadapter myadapter;
    private int height;//屏幕宽高
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         init();
         initdata();
        initadapter();

    }

    private void initadapter() {
          myadapter=new Myadapter();
         recyclerView.setAdapter(myadapter);

    }

    private void initdata() {
      for(int i=0;i<images.imgs.length;i++){
          list.add(images.imgs[i]);

      }
    }

    private void init() {
        recyclerView= (RecyclerView) findViewById(R.id.ry);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
         imageloader=Imageloader.getimageloader();
        height=getResources().getDisplayMetrics().heightPixels;
    }
    class Myadapter extends  RecyclerView.Adapter<Myadapter.Viewholder>{


        @Override
        public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            Viewholder vh=new Viewholder(LayoutInflater.from(MainActivity.this).inflate(R.layout.rlitem,parent,false));

            return vh;
        }

        @Override
        public void onBindViewHolder(Viewholder holder, int position) {
            holder.iv.setImageResource(R.mipmap.ic_launcher);

            RecyclerView.LayoutParams layoutParams= (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
            layoutParams.height=height/2;
            holder.itemView.setLayoutParams(layoutParams);

             holder.iv.setMaxHeight(height/2/5*4);
            imageloader.loadimage(list.get(position),holder.iv);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class Viewholder extends  RecyclerView.ViewHolder{
                ImageView iv;
            public Viewholder(View itemView) {
                super(itemView);
                iv= (ImageView) itemView.findViewById(R.id.imagev);
            }

        }

    }
}
