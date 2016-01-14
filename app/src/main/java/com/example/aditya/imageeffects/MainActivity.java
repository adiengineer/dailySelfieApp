package  com.example.aditya.imageeffects;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.media.effect.Effect;
import android.media.effect.EffectContext;
import android.media.effect.EffectFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.view.WindowManager;
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // (NEW)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); // (NEW)


        //this will take bitmap from act between effect and damle's  activity.

        //Bitmap photo=(Bitmap)getIntent().getParcelableExtra("bitmap");

        Bitmap photo = BitmapFactory.decodeResource(this.getResources(), R.drawable.selfie);
        int choice=(int) getIntent().getIntExtra("choice",0); //will have to send bitmap and int.
        //only this object will occupy the screen
        GLSurfaceView view = new GLSurfaceView(this);
        setContentView(view);

           // FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT);
     //params.gravity= Gravity.CENTER;
        //params.weight = 1.0f;


       // view.setLayoutParams(params);



        //sets us the gl view to display the texture
        view.setEGLContextClientVersion(2);



        view.setRenderer(new EffectsRenderer(this,photo,choice)); //renderer set,bitmap b.
        view.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

        //params.weight = 1.0f;




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
