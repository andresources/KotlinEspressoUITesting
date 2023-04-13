package com.kotlinespressouitestingfinaldemo

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class Ex14DateTimePickerActivity : AppCompatActivity() {
    private lateinit var statusTextView: TextView
    private lateinit var date_picker_button: Button
    private lateinit var time_picker_button:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex14_date_time_picker)
        statusTextView = findViewById(R.id.status)
        date_picker_button = findViewById(R.id.date_picker_button)
        date_picker_button.setOnClickListener {
            showDatePickerDialog()
        }
        time_picker_button = findViewById(R.id.time_picker_button)
        time_picker_button.setOnClickListener {
            showTimePickerDialog()
        }
    }
    private fun showTimePickerDialog() {
        val calendar: Calendar = Calendar.getInstance()
        val hour: Int = calendar.get(Calendar.HOUR_OF_DAY)
        val minute: Int = calendar.get(Calendar.MINUTE)
        val timePicker = TimePickerDialog(this,
            { view, hourOfDay, minute -> updateStatusView("$hourOfDay:$minute") },
            hour,
            minute,
            true
        )
        timePicker.setTitle("Pick a time")
        timePicker.show()
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerDialog(this,
            { view, year, monthOfYear, dayOfMonth -> updateStatusView("$year/$monthOfYear/$dayOfMonth") },
            2015,
            0,
            1
        )
        datePicker.setTitle("Pick a date")
        datePicker.show()
    }
    private fun updateStatusView(str:String){
        statusTextView.text = str
    }
}