package com.hencoder.hencoderpracticedraw6.practice;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;

    private boolean isAnim;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO 在这里处理点击事件，同时对多个属性做动画
                if (isAnim) {
                    imageView.animate()
                            .translationX(250)
                            .alpha(1)
                            .scaleX(1)
                            .scaleY(1)
                            .rotation(360)
                            .setInterpolator(new OvershootInterpolator())
                            .setDuration(1500);
                } else {
                    imageView.animate()
                            .translationX(0)
                            .alpha(0)
                            .scaleX(0)
                            .scaleY(0)
                            .rotation(0)
                            .setInterpolator(new AccelerateDecelerateInterpolator())
                            .setDuration(1500);
                }
                isAnim = !isAnim;
            }
        });
    }
}
