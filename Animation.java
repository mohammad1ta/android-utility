import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Animation Class
 * Set useful animations for any layouts
 * @author Mohammadreza Yektamaram <mohammad.1ta@gmail.com>
 * @since 2020-01-22 12:01 PM
 */
public class Animation {

    public static LayoutAnimationController Scale( int speed, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(speed);
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        animation = new ScaleAnimation(0f, 1.0f, 0f, 1.0f, android.view.animation.Animation.RELATIVE_TO_SELF, 0.5f, android.view.animation.Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setStartOffset( offset );
        animation.setDuration(speed/2);
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0.2f);

    }

    public static LayoutAnimationController SlideUp( int speed, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration( speed );
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        animation = new TranslateAnimation(
                0,
                0,
                200,
                0
        );
        animation.setDuration( speed );
        animation.setFillAfter(true);
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0.3f);

    }

    public static LayoutAnimationController SlideDown( int speed, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(speed);
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        animation = new TranslateAnimation( 0, 0, -200, 0 );
        animation.setDuration(speed);
        animation.setStartOffset( offset );
        animation.setFillAfter(true);
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0.3f);

    }

    public static LayoutAnimationController PushRight( int speed, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration( speed );
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        animation = new TranslateAnimation( -600, 0, 0, 0 );
        animation.setDuration( speed );
        animation.setStartOffset( offset );
        animation.setFillAfter(true);
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0.3f);

    }

    public static LayoutAnimationController PushLeft( int speed, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration( speed );
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        animation = new TranslateAnimation( 600, 0, 0, 0 );
        animation.setDuration( speed );
        animation.setStartOffset( offset );
        animation.setFillAfter(true);
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0.3f);

    }

    public static LayoutAnimationController FadeIn( int delayTime, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration( delayTime );
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0);

    }

    public static LayoutAnimationController FadeOut( int delayTime, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration( delayTime );
        animation.setStartOffset( offset );
        set.addAnimation(animation);

        return new LayoutAnimationController(set, 0);

    }

    public static void BounceImage( ImageView element, int duration ) {

        ObjectAnimator animY = ObjectAnimator.ofFloat(element, "translationY", -250f, 0f);
        animY.setDuration(duration);
        animY.setInterpolator(new BounceInterpolator());
        animY.start();

    }

    public static android.view.animation.Animation FadeInBox( int delayTime, int offset ) {

        AnimationSet set = new AnimationSet(true);

        android.view.animation.Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration( delayTime );
        animation.setStartOffset( offset );

        return animation;

    }

}
