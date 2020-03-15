package com.mehmet.merzigoandroidchallaeng.UI;

import android.graphics.PorterDuff;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

public class UIHelper
{
    public static void AssignButtonTouchEffect(View button)
    {
        button.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
        button.invalidate();
    }
    public static void RevokeButtonTouchEffect(View button)
    {
        button.getBackground().clearColorFilter();
        button.invalidate();
    }
    public static void CenterScaleAnimation(View v, boolean status)
    {
        ScaleAnimation scaleAnimation;
        if(status)
        {
            scaleAnimation =  new ScaleAnimation(0f, 1.2f, 0f, 1.2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        else
        {
            scaleAnimation =  new ScaleAnimation(1.2f, 1f, 1.2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        }
        scaleAnimation.setDuration(1250);
        scaleAnimation.setFillAfter(true);
        v.startAnimation(scaleAnimation);
    }
}