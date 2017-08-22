/*******************************************************************************
 * Copyright 2017 Ilya Pavlovskii
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package by.ilya.pavlovskii.anibutton;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 11.08.17<br>
 * Time: 1:36<br>
 * Project name: AniButton<br>
 * ===================================================================================
 */
public class AniButton extends android.support.v7.widget.AppCompatButton {

    protected Animator mInAnimator;
    protected Animator mOutAnimator;
    private boolean mPressed;

    public AniButton(Context context) {
        super(context);
        init( context, null, 0 );
    }

    public AniButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init( context, attrs, 0 );
    }

    public AniButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init( context, attrs, defStyleAttr);
    }

    private void init(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {

        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.AniButton, defStyleAttr, 0);
            int animInRes = typedArray.getResourceId(R.styleable.AniButton_anim_in, 0);
            int animOutRes = typedArray.getResourceId(R.styleable.AniButton_anim_out, 0);

            mInAnimator = AnimatorInflater.loadAnimator( context, animInRes );
            mOutAnimator = AnimatorInflater.loadAnimator( context, animOutRes );
            mInAnimator.setTarget(this);
            mOutAnimator.setTarget(this);

        } finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if( !mPressed ){
                    if( mInAnimator != null ){
                        mInAnimator.start();
                    }
                    mPressed = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                if( mPressed ){
                    if( mOutAnimator != null ){
                        mOutAnimator.start();
                    }
                    mPressed = false;
                }
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setInAnimator(Animator inAnimator) {
        mInAnimator = inAnimator;
    }

    public void setOutAnimator(Animator outAnimator) {
        mOutAnimator = outAnimator;
    }
}
