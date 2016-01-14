package com.example.aditya.imageeffects;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.effect.Effect;
import android.media.effect.EffectContext;
import android.media.effect.EffectFactory;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Aditya on 22-10-2015.
 */
public class EffectsRenderer implements GLSurfaceView.Renderer
{
    private Bitmap photo;
    private int choice;
    private int photoWidth, photoHeight;
    private EffectContext effectContext;
    private Effect effect;

    public EffectsRenderer(Context context,Bitmap b,int choice)
    {
        super();


        photo =b;
        photoWidth = photo.getWidth();
        photoHeight = photo.getHeight();
        this.choice=choice; //choice sent, use in switch case.
    }





    @Override
    public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config)
    {


    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0,0,width, height);
        GLES20.glClearColor(0, 0, 0, 1);
        generateSquare();
    }

    @Override
    public void onDrawFrame(GL10 gl)
    {
        if(effectContext==null) {
            effectContext = EffectContext.createWithCurrentGlContext();
        }
        if(effect!=null){
            effect.release();
        }

        //add switch here, all func given now create the interme act
        switch(this.choice)
        {
            case 0: grayScaleEffect();
                    break;

            case 1: fisheye();
                break;
            case 2: grain();
                break;
            case 3: negative();
                break;
            case 4: sharpen();
                break;
            case 5: sepia();
                break;
            case 6: temp();
                break;
            case 7: posterize();
                break;
            case 8: lomoish();
                break;
            case 9: saturate();
                break;
            case 10: vignette();
                break;
            case 11: autofix();
                break;
            case 12: duotone();
                break;
            case 13: cross();
                break;
            case 14: blacknwhite();
                break;
            case 15: overlay();
                break;

            /* "lomoish",
                "saturate",
                "vignette",
                "autofix",
                "duotone",
                "brightness",
                "contrast",
                "overlay" */

        }

        square.draw(textures[1]);
    }

    //method to apply grey scale effect
    private void grayScaleEffect(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_GRAYSCALE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void fisheye(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_FISHEYE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void grain(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_GRAIN);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void negative(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_NEGATIVE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void sharpen(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_SHARPEN);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void sepia(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_SEPIA);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void temp(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_TEMPERATURE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void posterize(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_POSTERIZE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void lomoish(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_LOMOISH);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void saturate(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_SATURATE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void vignette(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_VIGNETTE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void autofix(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_AUTOFIX);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void duotone(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_DUOTONE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void cross(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_CROSSPROCESS);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void blacknwhite(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_BLACKWHITE);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }

    private void overlay(){
        EffectFactory factory = effectContext.getFactory();
        effect = factory.createEffect(EffectFactory.EFFECT_BITMAPOVERLAY);
        effect.apply(textures[0], photoWidth, photoHeight, textures[1]);
    }
    //new method
    private int textures[] = new int[2];
    private com.example.aditya.imageeffects.Square square;

    private void generateSquare(){
        GLES20.glGenTextures(2, textures, 0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textures[0]);

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S, GLES20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T, GLES20.GL_CLAMP_TO_EDGE);

        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, photo, 0);
        square = new com.example.aditya.imageeffects.Square();
    }

}
