package mytest.bmi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends Activity {

	private EditText etHight;
	private EditText etWeight;
	private Button btnCalc;
	private TextView tvResult;
	/// one var comm with another
	private int iStatus = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmi);
		/// binding widget to local object
		etHight = (EditText) findViewById(R.id.etH);
		etWeight = (EditText) findViewById(R.id.etW);
		btnCalc = (Button) findViewById(R.id.btnCalc);
		tvResult = (TextView) findViewById(R.id.tvR);
		/// make a callback on button
		btnCalc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				try {
					double h = Double.parseDouble(etHight.getText().toString()) / 100;
					double w = Double
							.parseDouble(etWeight.getText().toString());
					double bmi = w / (h * h);

					if (bmi < 18.5) {
						tvResult.setText(R.string.str_thin);
						iStatus = 0;
					} else if (bmi > 24.9) {
						tvResult.setText(R.string.str_fat);
						iStatus = 1;
					} else {
						tvResult.setText(R.string.str_normal);
						iStatus = 2;
					}
				} catch (Exception e) {
					Toast.makeText(BMIActivity.this, R.string.str_error,
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bmi, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_info:
			// Toast.makeText(BMIActivity.this, "This is null info",
			// Toast.LENGTH_LONG).show();

			// / want to act another activity
			Intent itIntent = new Intent();
			Bundle bundle = new Bundle();
			// / trans infor to next activity
			// / get string from resource
			bundle.putInt(getString(R.string.bundle_bmi_status), iStatus);
			itIntent.putExtras(bundle);

			itIntent.setClass(BMIActivity.this, InfoAct.class);
			startActivity(itIntent);
			break;
		case R.id.menu_quit:
			finish();
			break;
		}
		return true;
	}

}
