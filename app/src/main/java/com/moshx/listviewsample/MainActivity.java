package com.moshx.listviewsample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

@SuppressLint("NewApi")
public class MainActivity extends Activity {


    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View headerView = getLayoutInflater().inflate(R.layout.view_list_item_header, null);


        ListView listView = (ListView) findViewById(R.id.exactListView);
        String[] str = getResources().getStringArray(R.array.shamsur_Kobita_listName);

        final ListView_Adapter ad = new ListView_Adapter(this, str);//image
        listView.setAdapter(ad);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "" + ad.getItem(position), Toast.LENGTH_SHORT).show();

/*                switch (position) {
                    case 0:
                        intent = new Intent(List_main.this, Details_Class.class);
                        break;
                    case 1:
                        intent = new Intent(List_main.this, Grid_main_Activity.class);
                        break;
                    case 2:
                        intent = new Intent(List_main.this, Button_style_main.class);
                        break;

                }

                startActivity(intent);*/

            }
        });


        listView.addHeaderView(headerView, null, false);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                View headerView = view.findViewById(R.id.header);

                final float mTop = -headerView.getTop();
                float height = headerView.getHeight();
                if (mTop > height) {
                    // ignore
                    return;
                }


                View imgView = headerView.findViewById(R.id.imageView);
                imgView.setTranslationY(mTop / 2f);

            }
        });
    }
}
