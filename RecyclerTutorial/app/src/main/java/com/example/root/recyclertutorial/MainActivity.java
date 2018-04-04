package com.example.root.recyclertutorial;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private RecyclerView mRecyclerView;
    private SubActivityAdapter mAdapter;
    final int duration = 50;
    final int pixelsToMove = 200;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private RecyclerView.LayoutManager mLayoutManager;
    private final Runnable SCROLLING_RUNNABLE = new Runnable() {

        @Override
        public void run() {
            mRecyclerView.smoothScrollBy(pixelsToMove, 0);
            mHandler.postDelayed(this, duration);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.hrlist_recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SubActivityAdapter(this, getData());
        mRecyclerView.setAdapter(mAdapter);

//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, 200, dy);
//                int lastItem = layoutManager.findLastCompletelyVisibleItemPosition();
//                if(lastItem == layoutManager
//                        .getItemCount()-1){
//                    mHandler.removeCallbacks(SCROLLING_RUNNABLE);
//                    Handler postHandler = new Handler();
//                    postHandler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            mRecyclerView.setAdapter(null);
//                            mRecyclerView.setAdapter(mAdapter);
//                            mHandler.postDelayed(SCROLLING_RUNNABLE, 50000);
//                        }
//                    }, 50000);
//                }
//            }
//        });
//        mHandler.postDelayed(SCROLLING_RUNNABLE, 2000);

        //Layout manager for the Recycler View
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public static List<SubActivityData> getData() {
        List<SubActivityData> subActivityData = new ArrayList<>();
        String[] cardTitle = {
                "Card 1",
                "Card 2",
                "Card 3",
                "Card 4",
                "Card 5",
                "Card 6",
        };
        for (int i = 0; i < cardTitle.length; i++) {
            SubActivityData current = new SubActivityData();
            current.cardTitle = cardTitle[i];
            subActivityData.add(current);
        }

        return subActivityData;
    }
}
