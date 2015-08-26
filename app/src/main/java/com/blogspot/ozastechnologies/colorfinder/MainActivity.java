package com.blogspot.ozastechnologies.colorfinder;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

/**
 * MainActivity - MainActivity UI view
 *
 * @author Ashish Sharma <technologist.ashish@gmail.com>
 * @version 1.0
 * @since 8/26/15 at 3:40 PM.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * mColorView {@link View}
     */
    private View mColorView;
    /**
     * mRedColor {@link String}
     */
    private String mRedColor;
    /**
     * mBlueColor {@link String}
     */
    private String mBlueColor;
    /**
     * mGreenColor {@link String}
     */
    private String mGreenColor;
    /**
     * mRedNumberPicker {@link NumberPicker}
     */
    private NumberPicker mRedNumberPicker;
    /**
     * mGreenNumberPicker {@link NumberPicker}
     */
    private NumberPicker mGreenNumberPicker;
    /**
     * mBlueNumberPicker {@link NumberPicker}
     */
    private NumberPicker mBlueNumberPicker;
    /**
     * mRedEditText {@link EditText}
     */
    private EditText mRedEditText;
    /**
     * mGreenEditText {@link EditText}
     */
    private EditText mGreenEditText;
    /**
     * mBlueEditText {@link EditText}
     */
    private EditText mBlueEditText;
    /**
     * mViewColor {@link Integer}
     */
    private int mViewColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRedNumberPicker = (NumberPicker) findViewById(R.id.numberPickerRed);
        mGreenNumberPicker = (NumberPicker) findViewById(R.id.numberPickerGreen);
        mBlueNumberPicker = (NumberPicker) findViewById(R.id.numberPickerBlue);

        mRedEditText = (EditText) findViewById(R.id.redEditTextValue);
        mGreenEditText = (EditText) findViewById(R.id.greenEditTextValue);
        mBlueEditText = (EditText) findViewById(R.id.blueEditTextValue);

        mRedNumberPicker.setValue(0);
        mRedNumberPicker.setMinValue(0);
        mRedNumberPicker.setMaxValue(255);
        mGreenNumberPicker.setValue(0);
        mGreenNumberPicker.setMinValue(0);
        mGreenNumberPicker.setMaxValue(255);
        mBlueNumberPicker.setValue(0);
        mBlueNumberPicker.setMinValue(0);
        mBlueNumberPicker.setMaxValue(255);

        mRedNumberPicker.setWrapSelectorWheel(true);
        mGreenNumberPicker.setWrapSelectorWheel(true);
        mBlueNumberPicker.setWrapSelectorWheel(true);

        mRedEditText.setText(String.valueOf(mRedNumberPicker.getValue()));
        mGreenEditText.setText(String.valueOf(mGreenNumberPicker.getValue()));
        mBlueEditText.setText(String.valueOf(mBlueNumberPicker.getValue()));

        mRedColor = mRedEditText.getText().toString();
        mGreenColor = mGreenEditText.getText().toString();
        mBlueColor = mBlueEditText.getText().toString();

        mViewColor = Color.rgb(Integer.valueOf(mRedColor), Integer.valueOf(mBlueColor), Integer.valueOf(mBlueColor));

        mColorView = findViewById(R.id.viewColor);
        mColorView.setBackgroundColor(mViewColor);

        mRedEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int redColor = Integer.valueOf(s.toString());
                    if (redColor >= 0 && redColor <= 255) {
                        mRedNumberPicker.setValue(redColor);
                        mGreenColor = mGreenEditText.getText().toString();
                        mBlueColor = mBlueEditText.getText().toString();
                        mViewColor = Color.rgb(redColor, Integer.valueOf(mGreenColor), Integer.valueOf(mBlueColor));
                        mColorView.setBackgroundColor(mViewColor);

                    } else {
                        Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_red_color), Snackbar.LENGTH_LONG).show();

                    }

                } else {
                    Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_red_color_empty), Snackbar.LENGTH_LONG).show();

                }
            }
        });

        mGreenEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int greenColor = Integer.valueOf(s.toString());
                    if (greenColor >= 0 && greenColor <= 255) {
                        mRedColor = mRedEditText.getText().toString();
                        mGreenNumberPicker.setValue(greenColor);
                        mBlueColor = mBlueEditText.getText().toString();
                        mViewColor = Color.rgb(Integer.valueOf(mRedColor), greenColor, Integer.valueOf(mBlueColor));
                        mColorView.setBackgroundColor(mViewColor);

                    } else {
                        Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_green_color), Snackbar.LENGTH_LONG).show();

                    }

                } else {
                    Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_green_color_empty), Snackbar.LENGTH_LONG).show();

                }
            }
        });

        mBlueEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    int blueColor = Integer.valueOf(s.toString());
                    if (blueColor >= 0 && blueColor <= 255) {
                        mRedColor = mRedEditText.getText().toString();
                        mGreenColor = mGreenEditText.getText().toString();
                        mBlueNumberPicker.setValue(blueColor);
                        mViewColor = Color.rgb(Integer.valueOf(mRedColor), Integer.valueOf(mGreenColor), blueColor);
                        mColorView.setBackgroundColor(mViewColor);

                    } else {
                        Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_blue_color), Snackbar.LENGTH_LONG).show();

                    }

                } else {
                    Snackbar.make(findViewById(android.R.id.content), getString(R.string.error_blue_color_empty), Snackbar.LENGTH_LONG).show();

                }
            }
        });

        mRedNumberPicker.setOnValueChangedListener(new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {
                mRedEditText.setText(String.valueOf(newVal));
                mGreenColor = mGreenEditText.getText().toString();
                mBlueColor = mBlueEditText.getText().toString();
                mViewColor = Color.rgb(newVal, Integer.valueOf(mGreenColor), Integer.valueOf(mBlueColor));
                mColorView.setBackgroundColor(mViewColor);
            }
        });

        mGreenNumberPicker.setOnValueChangedListener(new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {
                mRedColor = mRedEditText.getText().toString();
                mGreenEditText.setText(String.valueOf(newVal));
                mBlueColor = mBlueEditText.getText().toString();
                mViewColor = Color.rgb(Integer.valueOf(mRedColor), newVal, Integer.valueOf(mBlueColor));
                mColorView.setBackgroundColor(mViewColor);
            }
        });

        mBlueNumberPicker.setOnValueChangedListener(new NumberPicker.
                OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int
                    oldVal, int newVal) {
                mRedColor = mRedEditText.getText().toString();
                mGreenColor = mGreenEditText.getText().toString();
                mBlueEditText.setText(String.valueOf(newVal));
                mViewColor = Color.rgb(Integer.valueOf(mRedColor), Integer.valueOf(mGreenColor), newVal);
                mColorView.setBackgroundColor(mViewColor);
            }
        });

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
