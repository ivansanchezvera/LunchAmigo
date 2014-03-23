package mingle.unimelb.lunchamigo;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;


import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

//should have used dialog fragment
public class InputTime extends Activity {
	/* Switch statement for choosing dialog */
	static final int TIME_DIALOG_FROM_ID = 0;
	static final int TIME_DIALOG_UNTIL_ID = 1;
	static final int DATE_DIALOG_ID = 3;
	
	//We use listener so we need an iVar of it
	private Button setFrom;
	private Button setUntil;
	private Button setDate;
	
	final Calendar c = Calendar.getInstance();
	//time1 correspond to from
	// time2 correspond to until
	private TextView time1View;
	private TextView time2View;
	private TextView dateView;
	private int from_hour = c.get(Calendar.HOUR_OF_DAY);
	private int from_minute = c.get(Calendar.MINUTE);
	private int until_hour;
	private int until_minute;
    private int year = c.get(Calendar.YEAR);
    private int month = c.get(Calendar.MONTH);
    private int day = c.get(Calendar.DAY_OF_MONTH);

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input_time);
		setCurrentTimeOnView();
		addListenerOnButton();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.input_time, menu);
		return true;
	}
	//Refresh the display for the current time an day
	public void setCurrentTimeOnView() {
		until_hour = from_hour + 1;
		until_minute = from_minute;
		time1View = (TextView) findViewById(R.id.time1View);
		time2View = (TextView) findViewById(R.id.time2View);
		dateView = (TextView) findViewById(R.id.dateView);
		
		// set current time into textview1 (from time)
		time1View.setText(
                    new StringBuilder().append(pad(from_hour))
                                       .append(":").append(pad(from_minute)));
		
		time2View.setText(
					new StringBuilder().append(pad(until_hour))
                						.append(":").append(pad(until_minute)));
		dateView.setText(new StringBuilder().append(pad(day))
				.append("/").append(pad(month)).append("/").append(pad(year)));
	}
	// adding listener to from button
	public void addListenerOnButton() {
		setUntil = (Button) findViewById(R.id.setUntil);
		setFrom = (Button) findViewById(R.id.setFrom);
		setDate = (Button) findViewById(R.id.setDate);
		//setup listener for each button
		setUntil.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
 
				showDialog(TIME_DIALOG_UNTIL_ID);
			}
		});
		
		setFrom.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
 
				showDialog(TIME_DIALOG_FROM_ID);
			}
		});
		
		setDate.setOnClickListener(new OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
 
				showDialog(DATE_DIALOG_ID);
			}
		});
		
		
		
		
		
	
	}
	
// constructor for the various dialog
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_FROM_ID:
			// set time picker as current time (From Time)
			return new TimePickerDialog(this, 
                                        timePickerListener1, from_hour, from_minute,true);
			
		case TIME_DIALOG_UNTIL_ID:
			// set time picker as current time (Until Time)
			return new TimePickerDialog(this, 
                                        timePickerListener2, until_hour, until_minute,true);
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, datePickerListener,
											year, month, day);
		}	
		
		
		
		return null;
	}	
	//From Time Picker
	private TimePickerDialog.OnTimeSetListener timePickerListener1 = 
            new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			from_hour = selectedHour;
			from_minute = selectedMinute;
 
			// set current time into TextView
			time1View.setText(new StringBuilder().append(pad(from_hour))
					.append(":").append(pad(from_minute)));
		}
	};
	//Until Time Picker
	private TimePickerDialog.OnTimeSetListener timePickerListener2 = 
            new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int selectedHour,
				int selectedMinute) {
			until_hour = selectedHour;
			until_minute = selectedMinute;
 
			// set current time into TextView
			time2View.setText(new StringBuilder().append(pad(until_hour))
					.append(":").append(pad(until_minute)));
		}
	};
	//Until Date Picker
	private DatePickerDialog.OnDateSetListener datePickerListener = 
            new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth,int selectedDay) {
			year = selectedYear;
			month = selectedMonth;
			day = selectedDay;
			// set current time into TextView
			dateView.setText(new StringBuilder().append(pad(day))
					.append("/").append(pad(month)).append("/").append(pad(year)));
		}
	};
	// http://www.mkyong.com/android/android-time-picker-example/
	// convert calendar Int to string
	private static String pad(int c) {
		if (c >= 10)
		   return String.valueOf(c);
		else
		   return "0" + String.valueOf(c);
	}
	

}


