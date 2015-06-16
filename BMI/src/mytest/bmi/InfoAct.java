package mytest.bmi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class InfoAct extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);

		Bundle bundle = getIntent().getExtras();
		int status = bundle.getInt(getString(R.string.bundle_bmi_status));

		Toast.makeText(InfoAct.this, "status=" + status, Toast.LENGTH_LONG)
				.show();
	}

}
