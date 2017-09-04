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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.vAbFade).setOnClickListener(mOnClickListener);
        findViewById(R.id.vAbZoom).setOnClickListener(mOnClickListener);
        ((CircleAniButton)findViewById(R.id.vCabZoom)).setOnCircleClickListener(mOnCircleClickListener);
        ((CircleAniImageButton)findViewById(R.id.vCaibZoom)).setOnCircleClickListener(mOnCircleClickListener);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.vAbFade:
                    Toast.makeText(MainActivity.this, "Fade clicked", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.vAbZoom:
                    Toast.makeText(MainActivity.this, "Zoom clicked", Toast.LENGTH_SHORT)
                            .show();
                    break;
            }
        }
    };

    private OnCircleClickListener mOnCircleClickListener = new OnCircleClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.vCabZoom:
                    Toast.makeText(MainActivity.this, "Circle zoom clicked", Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.vCaibZoom:
                    Toast.makeText(MainActivity.this, "Circle image zoom clicked", Toast.LENGTH_SHORT)
                            .show();
                    break;
            }
        }
    };
}
