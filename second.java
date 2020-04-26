package com.example.skcetview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

public class second extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
    private VrPanoramaView panoWidgetView;
    private ImageLoaderTask backgroundImageLoaderTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Window w=getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        panoWidgetView=(VrPanoramaView)findViewById(R.id.pano_view);
        mdrawerlayout=(DrawerLayout)findViewById(R.id.drawer);
        mtoggle=new ActionBarDrawerToggle(second.this,mdrawerlayout,R.string.open,R.string.close);
        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView=(NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        showdialog();
    }
    private void showdialog(){
        new AlertDialog.Builder(this)
                .setTitle("Instruction")
                .setMessage("Please press the side menu option to experience the 360 view of skcet")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        /*switch (id) {
            case R.id.campus:
                //Toast.makeText(MainActivity.this,"login",Toast.LENGTH_SHORT).show();
                loadPanoImage1();
                mdrawerlayout.closeDrawers();
                break;
            case R.id.auditoriam:
                //Toast.makeText(MainActivity.this,"paper",Toast.LENGTH_SHORT).show();
                loadPanoImage2();
                mdrawerlayout.closeDrawers();
                break;
            case R.id.classroom:
                Toast.makeText(getApplicationContext(),"home",Toast.LENGTH_SHORT).show();
                //loadPanoImage1();
                mdrawerlayout.closeDrawers();
                break;
            case R.id.it:
                Toast.makeText(getApplicationContext(),"settings",Toast.LENGTH_SHORT).show();
                //loadPanoImage1();
                mdrawerlayout.closeDrawers();
                break;
            case R.id.department:
                Toast.makeText(getApplicationContext(),"settings",Toast.LENGTH_SHORT).show();
                //loadPanoImage1();
                mdrawerlayout.closeDrawers();
                break;
        }
        return false;
    }*/
        if (id == R.id.campus) {
            loadPanoImage1();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.department) {
            loadPanoImage2();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.classroom) {
            loadPanoImage3();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.convention) {
            //loadPanoImage4();
            Toast.makeText(getApplicationContext(), "CONVENTION CENTER", Toast.LENGTH_SHORT).show();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.bs03) {
            //loadPanoImage5();
            Toast.makeText(getApplicationContext(), "BS03", Toast.LENGTH_SHORT).show();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.krishna) {
            //loadPanoImage6();
            Toast.makeText(getApplicationContext(), "KRISHNA HALL", Toast.LENGTH_SHORT).show();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.it) {
            loadPanoImage7();
            //Toast.makeText(getApplicationContext(), "IT/CS LAB", Toast.LENGTH_SHORT).show();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.mech) {
            loadPanoImage8();
            //Toast.makeText(getApplicationContext(), "MECH/MCT LAB", Toast.LENGTH_SHORT).show();

            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.ece) {
           // Toast.makeText(getApplicationContext(), "ECE/EEE LAB", Toast.LENGTH_SHORT).show();
            loadPanoImage9();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.library) {
           // Toast.makeText(getApplicationContext(), "LIBRARY", Toast.LENGTH_SHORT).show();
            loadPanoImage10();
            mdrawerlayout.closeDrawers();
        }
        if (id == R.id.admin) {
            loadPanoImage11();
            //Toast.makeText(getApplicationContext(), "ADMIN BLOCK", Toast.LENGTH_SHORT).show();
            mdrawerlayout.closeDrawers();
        }
        return false;
    }

    private synchronized void loadPanoImage1(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "3con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage2(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "5con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage3(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "2con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage4(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "1con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage5(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "1con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage6(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "1con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage7(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "it.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage8(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "mech.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage9(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "civil.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage10(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "4con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
    private synchronized void loadPanoImage11(){
        ImageLoaderTask task = backgroundImageLoaderTask;
        if (task != null && !task.isCancelled()) {
            // Cancel any task from a previous loading.
            task.cancel(true);
        }

        // pass in the name of the image to load from assets.
        VrPanoramaView.Options viewOptions = new VrPanoramaView.Options();
        viewOptions.inputType = VrPanoramaView.Options.TYPE_MONO;

        // use the name of the image in the assets/ directory.
        String panoImageName = "1con.jpg";

        /* create the task passing the widget view and call execute to start. */
        task = new ImageLoaderTask(panoWidgetView, viewOptions, panoImageName);
        task.execute(this.getAssets());
        backgroundImageLoaderTask = task;
    }
}
