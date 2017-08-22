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

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Create with Android Studio<br>
 * Created by Pavlovskii Ilya<br>
 * E-mail: pavlovskii_ilya@mail.ru, trane91666@gmail.com<br>
 * Skype: trane9119<br>
 * Date: 23.08.17<br>
 * Time: 1:11<br>
 * Project name: AniButton<br>
 * ===================================================================================
 */
public class CircleAniImageButton extends AniImageButton {

    //center x of Image
    private float centerX;
    //center y of Image
    private float centerY;
    //the radius of circle
    private float radius;

    private OnCircleClickListener mOnCircleClickListener;

    public CircleAniImageButton(Context context) {
        super(context);
    }

    public CircleAniImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleAniImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = radius = w / 2;
        centerY = h / 2;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float eventX = event.getX();
                float eventY = event.getY();
                if (eventY == centerY) {
                    if (Math.abs(eventX - centerX) <= radius) {
                        if (mOnCircleClickListener != null){
                            mOnCircleClickListener.onClick(this);
                        }
                        return super.onTouchEvent(event);
                    }
                } else {
                    double firstLeg = Math.pow(Math.abs(eventX - centerX), 2);
                    double secLeg = Math.pow(Math.abs(eventY - centerY), 2);
                    double hypotenuse = Math.sqrt(firstLeg + secLeg);
                    if (hypotenuse <= radius) {
                        if (mOnCircleClickListener != null){
                            mOnCircleClickListener.onClick(this);
                        }
                        return super.onTouchEvent(event);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                return super.onTouchEvent(event);
        }
        return false;
    }

    public void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        mOnCircleClickListener = onCircleClickListener;
    }
}
