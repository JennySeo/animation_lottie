package test.hjdev.testanimation;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;


public class MainActivity extends AppCompatActivity {


    private LinearLayout mMotionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mMotionLayout = (LinearLayout) findViewById( R.id.motion_animation_layout );
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation("coinpig.json");
        animationView.loop(true);
//Lottie Animation start
        animationView.playAnimation();


    }

    public static AnimationSet showAnimation(AnimationSet aniset, boolean open) {
        if (aniset == null) {
            return null;
        }

        TranslateAnimation translate;

        if (open) {
            translate = new TranslateAnimation( -450, 0, 0, 0 );
            translate.setDuration( 500 );
            translate.setFillEnabled( true );
            translate.setInterpolator( new LinearInterpolator() );
        } else {
            translate = new TranslateAnimation( 0, -450, 0, 0 );
            translate.setDuration( 500 );
            translate.setFillEnabled( true );
            translate.setInterpolator( new LinearInterpolator() );
        }

        aniset.addAnimation( translate );

        return aniset;
    }

    private void finishAnimation() {
        AnimationSet aniset = new AnimationSet( true );
        aniset = showAnimation( aniset, false );
        if (mMotionLayout != null) {
            aniset.setAnimationListener( new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mMotionLayout.clearAnimation();
                    mMotionLayout.setVisibility( View.INVISIBLE );
                    finish();
                }
            } );
            mMotionLayout.startAnimation( aniset );
        }
    }


    public void startAnimation(final ImageView imageView) {

    }




}
