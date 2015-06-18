package mytest.colorcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ColorCardActivity extends Activity {

	private LinearLayout sampleTab = null;
	private LinearLayout searchTab = null;
	private LinearLayout identifyTab = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_color_card);

		sampleTab = (LinearLayout) findViewById(R.id.sampleTab);
		searchTab = (LinearLayout) findViewById(R.id.searchTab);
		identifyTab = (LinearLayout) findViewById(R.id.identifyTab);

		sampleTab.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				sampleTab.setBackgroundResource(R.drawable.tabselected);
				TextView tView = (TextView) sampleTab.getChildAt(0);
				tView.setTextColor(getResources().getColor(R.color.gray));
			}
		});
		searchTab.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				searchTab.setBackgroundResource(R.drawable.tabselected);
				TextView tView = (TextView) searchTab.getChildAt(0);
				tView.setTextColor(getResources().getColor(R.color.gray));
			}
		});
		identifyTab.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				searchTab.setBackgroundResource(R.drawable.tabselected);
				TextView tView = (TextView) searchTab.getChildAt(0);
				tView.setTextColor(getResources().getColor(R.color.gray));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.color_card, menu);
		return true;
	}

}
