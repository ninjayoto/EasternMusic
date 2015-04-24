package net.androidbootcamp.easternmusic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Main extends Activity {

    Button btBamboo, btPalace;
    MediaPlayer mpBamboo, mpPalace;
    int playing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btBamboo = (Button) findViewById(R.id.btnBamboo);
        btPalace = (Button) findViewById(R.id.btnPalace);
        /*because we are dealing with more than one button,
        we cannot use anonymous class and make the code smaller
        we are setting a click listener for each button
        each click listener will then execute it's own Onclick action
        */
        btBamboo.setOnClickListener(bBamboo);
        btPalace.setOnClickListener(bPalace);
        // the variable mpBamboo is an instance of MediaPlayer Class
        mpBamboo = new MediaPlayer();
        //mpBamboo is assigned to an instance of MediaPlayer that access bamboo.mp3
        mpBamboo = MediaPlayer.create (this, R.raw.bamboo);
        //the same goes for mpPalace : Instantiate then assign
        mpPalace = new MediaPlayer();
        mpPalace = MediaPlayer.create (this,R.raw.palace);
        // this in to help determine if the media is playing or not
        playing = 0;

    }
        //to create an instance of button OnClickListener
        View.OnClickListener bBamboo = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        mpBamboo.start();
                        playing = 1;
                        btBamboo.setText("Pause Bamboo Song");
                        btPalace.setVisibility(View.INVISIBLE);
                        break;

                    case 1:
                        mpBamboo.pause();
                        playing = 0;
                        btBamboo.setText("Play Bamboo Song");
                        btPalace.setVisibility(View.VISIBLE);
                        break;
                }

            }
        };
          View.OnClickListener bPalace = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(playing){
                    case 0:
                        mpPalace.start();
                        playing = 1;
                        btPalace.setText("Pause Palace Song");
                        btBamboo.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        mpPalace.pause();
                        playing = 0;
                        btBamboo.setText("Play Palace Song");
                        btBamboo.setVisibility(View.VISIBLE);
                        break;

                }

            }
        };


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
