package com.pinank.example.tipcalc;

import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalc extends Activity {
	protected static final double PERCENT_10 = 0.1;
	protected static final double PERCENT_15 = 0.15;
	protected static final double PERCENT_20 = 0.2;

	private Button btn10Percent;
	private Button btn15Percent;
	private Button btn20Percent;
	private EditText editTextNewAmount;
	private TextView tvTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);
        btn10Percent = (Button) findViewById(R.id.btn10Percent);
        btn15Percent = (Button) findViewById(R.id.btn15Percent);
        btn20Percent = (Button) findViewById(R.id.btn20Percent);
        editTextNewAmount = (EditText) findViewById(R.id.editTextNewAmount);
        tvTip = (TextView) findViewById(R.id.tvTip);
        
        setUpButtonListeners(btn10Percent, PERCENT_10);
        setUpButtonListeners(btn15Percent, PERCENT_15);
        setUpButtonListeners(btn20Percent, PERCENT_20);
    }

    private void setUpButtonListeners(Button btn, final double percent) {
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				computeTip(percent);
			}
		});
	}

    private void computeTip(double percent) {
    	String strAmount = editTextNewAmount.getText().toString();
    	double tip = 0.0;
    	try {
    		tip = Double.parseDouble(strAmount) * percent;
    	} catch (NumberFormatException e) {
    		Toast.makeText(this, "Invalid Amount", Toast.LENGTH_SHORT).show();
    	}
    	tvTip.setText(String.format(new Locale("en"), "Tip is: $%.2f", tip));
	}
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calc, menu);
        return true;
    }
    
}
