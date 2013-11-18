package com.halfbeard.finalapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity
{
    Intent intent;

    private static final String TAG =  "Transition";

    private View.OnClickListener onClick = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            Log.d(TAG, String.valueOf((char) v.getId()));
            if (v.getId() == 'P')
            {
                startActivity(intent);
            }
            else if(v.getId() == 'E')
            {
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        intent = new Intent(this, Game.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupGame()
    {
        //This sets up the Layout and the Button which will take the user to GoogleMaps
        LinearLayout question = (LinearLayout) this.findViewById(R.id.Buttons);

        Button playButton = new Button(this.getApplicationContext());
        playButton.setText("Play");
        playButton.setId('P');
        playButton.setOnClickListener(onClick);
        question.addView(playButton);

        Button exitButton = new Button(this.getApplicationContext());
        exitButton.setText("Exit");
        exitButton.setId('E');
        exitButton.setOnClickListener(onClick);
        question.addView(exitButton);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment
    {

        public PlaceholderFragment()
        {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
