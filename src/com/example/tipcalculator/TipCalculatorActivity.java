package com.example.tipcalculator;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		TextView tvTip = (TextView)findViewById(R.id.tvTip);
		String tipMessage = String.format(getResources().getString(R.string.tip_message),"0"); 
		tvTip.setText(tipMessage);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	public void calculateTip(View v) {
		EditText etAmount = (EditText)findViewById(R.id.etAmount);
		TextView tvTip = (TextView)findViewById(R.id.tvTip);
		
		String tipString = etAmount.getText().toString();
		Double amount = Double.valueOf((tipString != null && tipString.length() > 0) ? tipString : "0");
		Double tip = Double.valueOf(0.0);
		if (amount > 0) {
			switch (v.getId()) {
			case R.id.btn10Percent:
				tip = .1 * amount;
				break;
			case R.id.btn15Percent:
				tip = .15 * amount;
				break;
			case R.id.btn20Percent:
				tip = .2 * amount;
				break;
			}
		}
		
		tvTip.setText(String.format(getResources().getString(R.string.tip_message),
				NumberFormat.getCurrencyInstance().format(tip)));
	}
}
