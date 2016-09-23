///////////////////
//Name: HelloGoodbyeAD
//Author: Alex DiStasi
//Date: 8/30/2016
//Purpose: When a button is tapped, the text on screen changes
/////////////////

package com.example.alex.hellogoodbyead;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    //declares objects to screen interface with layout components
    private TextView greetingTextView;
    private TextView pokeTextView;

    //indicates that hello is being displayed
    private boolean isHello;
    //indicates if the app got POKED
    private boolean isPoked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //task 1:inflate(BUILD) the main screen layout that's used by the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //task2a: establish reference to textview and button for the exclaim button
        Button exclaimBtn = (Button) findViewById(R.id.button);
        greetingTextView = (TextView) findViewById(R.id.textView);

        //task 3: initialize greeting
        initializeGreeting();

        //task 4a: register the listener event for the exclaim button
        exclaimBtn.setOnClickListener(toggleGreeting);

        //////////////////////// Repeating the process above for a second button
        //Task 2B: Establish reference to textview2 and button2
        Button pokeBtn = (Button) findViewById(R.id.button2);
        pokeTextView = (TextView) findViewById(R.id.textView2);

        //Task 3B: Initialize poke text
        initializePokeComments();

        //Task 4B: Register the listener event for the poke button
        pokeBtn.setOnClickListener(toggleStopPoking);

    }
    /////////////////////////////////////////////////////////////
    //Description: Function that changes the text string value in the exclaim_btn
    //Input: Event listener, on click
    //Output: Value of greetingTextView is changed
    //Variables Used:
    //  -isHello: boolean that determines if 'hello' string has been displayed
    //Last Modified: 8/30/16
    ////////////////////////////////////////////////////////////
    private final View.OnClickListener toggleGreeting =
            new View.OnClickListener() {

                public void onClick(View btn) {
                    if (isHello) {
                        isHello = false;
                        greetingTextView.setText(R.string.goodbye);
                    } else {
                        isHello = true;
                        greetingTextView.setText(R.string.hello);
                    }
                }
            };

    private void initializeGreeting() {
        isHello = true;
    }

    /////////////////////////////////////////////////////////////
    //Description: Function that changes the text string value in the poke_btn
    //Input: Event listener, on click
    //Output: Value of pokeTextView is changed
    //Variables Used:
    //  -isPoked: boolean that determines if 'poked' string has been displayed
    //Last Modified: 9/2/16
    ////////////////////////////////////////////////////////////
    private final View.OnClickListener toggleStopPoking =
            new View.OnClickListener() {

                public void onClick(View btn) {
                    if (isPoked) {
                        isPoked = false;
                        pokeTextView.setText(R.string.ouch);
                       // pokeTextView.setTextColor(Color.parseColor(R.color.orange));


                    } else {
                        isPoked = true;
                        pokeTextView.setText(R.string.poked);
                    }
                }
            };

    private void initializePokeComments() {
        isPoked = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;
        // this adds items to the action bar if it is present.
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