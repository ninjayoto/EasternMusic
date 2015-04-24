package net.androidbootcamp.easternmusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
/*Timer and TimerTask work together , Timer schedules the TimerTask to run
But the task need to be an instance of TimerTask
thus we start by creating a TimerTask object
* */
        TimerTask task = new TimerTask() {
            @Override //run is an abstract, we override it
            public void run() {
                //here we are defining the task that will execute, stops/finishes the current activity, and launches another
                finish();
                startActivity(new Intent(Splash.this,Main.class));

            }
        };
/*Now we schedule the TimerTask to execute using Timer

* */
        Timer opening = new Timer();
        opening.schedule(task,5000);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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
