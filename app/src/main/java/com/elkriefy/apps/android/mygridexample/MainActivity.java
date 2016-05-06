package com.elkriefy.apps.android.mygridexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        assert recyclerView != null;
        recyclerView.setHasFixedSize(true);

        GridLayoutManager manager = new GridLayoutManager(this, 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }


            @Override
            public int getSpanIndex(int position, int spanCount) {
                switch (position) {
                    case 0:
                        return 0;
                    case 1:
                        return 3;
                    case 2:
                        return 3;
                    case 3:
                        return 3;
                    case 4:
                        return 3;
                    case 5:
                        return 0;
                    default:
                        return super.getSpanIndex(position, spanCount);
                }

            }


//            public int getSpanGroupIndex (int adapterPosition, int spanCount)
//            Returns the index of the group this position belongs.
//            For example, if grid has 3 columns and each item occupies 1 span, span group index for item 1 will be 0, item 5 will be 1.
//            Parameters
//            adapterPosition	int: The position in adapter
//            spanCount	int: The total number of spans in the grid
//            Returns
//            int	The index of the span group including the item at the given adapter position
//


//            @Override
//            public int getSpanGroupIndex(int adapterPosition, int spanCount) {
//                Log.e("getSpanGroupIndex", "position - " + adapterPosition + " spanCount" + spanCount);
//                switch (adapterPosition) {
//                    case 0:
//                    case 1:
//                    case 2:
//                    case 3:
//                    case 4:
//                    case 5:
//                    case 6:
//                    case 7:
//                    case 8:
//                        return 0;
//                    default:
//                        return super.getSpanGroupIndex(adapterPosition, spanCount);
//                }
//            }
        });

        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new SpacesItemDecoration(10));
        List<String> sList = getListItemData();
        SampleRecyclerViewAdapter rcAdapter = new SampleRecyclerViewAdapter(MainActivity.this, sList);
        recyclerView.setAdapter(rcAdapter);

    }


    private List<String> getListItemData() {
        List<String> listViewItems = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            listViewItems.add("" + 1);
        }
        return listViewItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
