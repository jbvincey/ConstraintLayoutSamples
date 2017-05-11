package com.backelite.constraintlayoutmaug;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class ConstraintActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout);

        addTextViewTopLeftConstraint();
        addTextViewVerticalBias();
        addTextViewGuideline();
        addTextViewMatchConstraint();
    }

    private void addTextViewTopLeftConstraint() {
        TextView textView = buildSimpleButton();
        textView.setText("TextView top left constraint");

        constraintLayout.addView(textView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 18);
        constraintSet.connect(textView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 18);
        constraintSet.applyTo(constraintLayout);
    }

    private void addTextViewVerticalBias() {
        TextView textView = buildSimpleButton();
        textView.setText("TextView vertical bias 60%");

        constraintLayout.addView(textView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 18);
        constraintSet.connect(textView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 18);
        constraintSet.setVerticalBias(textView.getId(), 0.6f);
        constraintSet.applyTo(constraintLayout);
    }

    private void addTextViewGuideline() {
        TextView textView = buildSimpleButton();
        textView.setText("TextView vertical guideline 40%");

        constraintLayout.addView(textView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.create(R.id.guideline, ConstraintSet.HORIZONTAL_GUIDELINE);
        constraintSet.setGuidelinePercent(R.id.guideline, 0.4f);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, R.id.guideline, ConstraintSet.BOTTOM, 18);
        constraintSet.applyTo(constraintLayout);
    }

    private void addTextViewMatchConstraint() {
        TextView textView = buildSimpleButton();
        textView.setText("TextView match horizontal constraint");

        constraintLayout.addView(textView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.connect(textView.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 18);
        constraintSet.connect(textView.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 18);
        constraintSet.connect(textView.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 18);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.MATCH_CONSTRAINT);
        constraintSet.applyTo(constraintLayout);

    }

    private TextView buildSimpleButton() {
        TextView textView = new TextView(this);
        textView.setTextSize(18);
        textView.setId(new Random().nextInt());
        textView.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));

        ConstraintLayout.LayoutParams constraintLayoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT
        );
        textView.setLayoutParams(constraintLayoutParams);

        return textView;
    }

}
