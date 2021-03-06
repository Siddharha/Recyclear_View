package com.recycleapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.recycleapp.R;
import com.recycleapp.adapters.MyRecyclerAdapter;
import com.recycleapp.bean.Items;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Items> list;
    MyRecyclerAdapter myAdapter;
    RecyclerView R_view;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        initializition();
        loadData();
        displayItems();
        onTouchFunction();
    }

    private void onTouchFunction() {
        SwipeableRecyclerViewTouchListener swipeTouchListener =
                new SwipeableRecyclerViewTouchListener(R_view,
                        new SwipeableRecyclerViewTouchListener.SwipeListener()
                        {

                            @Override
                            public boolean canSwipe(int position) {
                                return true;
                            }

                            @Override
                            public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    list.remove(position);
                                    myAdapter.notifyItemRemoved(position);
                                }
                                myAdapter.notifyDataSetChanged();
                            }

                            @Override
                            public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    list.remove(position);
                                    myAdapter.notifyItemRemoved(position);
                                }
                                myAdapter.notifyDataSetChanged();
                            }

                        });
        R_view.addOnItemTouchListener(swipeTouchListener);

    }

    private void displayItems() {

        Log.e("List Items: ",list.toString());
        R_view.setAdapter(myAdapter);
    }

    private void initializition() {
        list = new ArrayList<>();

        R_view = (RecyclerView)findViewById(R.id.R_view);
        R_view.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        myAdapter = new MyRecyclerAdapter(list,R.layout.list_layout);

    }

    private void loadData() {

        for(int i = 0;i<100;i++)
        {
            Items item = new Items();
            item.setName("Siddhartha "+i);
            item.setPhone_number("9732533406 " + i);
            list.add(item);
        }

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
