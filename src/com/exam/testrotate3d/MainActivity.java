package com.exam.testrotate3d;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ViewSwitcher;

public class MainActivity extends Activity {
	private ViewSwitcher mSwitcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mSwitcher = (ViewSwitcher) findViewById(R.id.switcher);

		mSwitcher.setOnClickListener(onRotate);
	}

	private OnClickListener onRotate = new OnClickListener() {

		@Override
		public void onClick(View v) {
			TransitionUtil.flipTransition(mSwitcher, TransitionUtil.FlipDirection.LEFT_RIGHT, 0.0f);

			// Set the views here when outanimation is started.
			mSwitcher.getOutAnimation().setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
					findViewById(R.id.screen).setVisibility(View.VISIBLE);
					findViewById(R.id.img_a).setVisibility(View.GONE);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
				}

				@Override
				public void onAnimationEnd(Animation animation) {
				}
			});
			// Set the views here when inanimation is ended.
			mSwitcher.getInAnimation().setAnimationListener(new AnimationListener() {

				@Override
				public void onAnimationStart(Animation animation) {
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
				}

				@Override
				public void onAnimationEnd(Animation animation) {
					findViewById(R.id.screen).setVisibility(View.GONE);
					findViewById(R.id.img_a).setVisibility(View.VISIBLE);
				}
			});
		}
	};

}
