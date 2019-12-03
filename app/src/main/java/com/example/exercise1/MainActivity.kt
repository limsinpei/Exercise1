package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calButton: Button = findViewById(R.id.buttonCalculate)

        calButton.setOnClickListener { calculate() }

        val resetButton: Button = findViewById(R.id.buttonReset)

        resetButton.setOnClickListener { reset() }

    }

    private fun calculate()
    {
        val editText1 = findViewById<EditText>(R.id.editTextCarPrice)
        val editText2 = findViewById<EditText>(R.id.editTextDownPayment)
        val editText3 = findViewById<EditText>(R.id.editTextLoanPeriod)
        val editText4 = findViewById<EditText>(R.id.editTextInterestRate)
        val textview1 = findViewById<TextView>(R.id.textViewLoan)
        val textview2 = findViewById<TextView>(R.id.textViewInterest)
        val textview3 = findViewById<TextView>(R.id.textViewMonthlyRepayment)
        val carprice = Integer.parseInt(editText1.text.toString())
        val downpayment = Integer.parseInt(editText2.text.toString())
        val loanperiod = Integer.parseInt(editText3.text.toString())
        val rate = Integer.parseInt(editText4.text.toString())

        val loan = carprice-downpayment
        val interest = loan*rate*loanperiod
        val monthly = (loan+interest)/loanperiod/12
        textview1.text = ("Loan : " + (loan).toString()+" .")
        textview2.text = ("Interest : " + (interest).toString()+" .")
        textview3.text = ("MonthlyRepayment : " + (monthly).toString()+" .")

    }

    private fun reset()
    {
        val editText1 = findViewById<EditText>(R.id.editTextCarPrice)
        val editText2 = findViewById<EditText>(R.id.editTextDownPayment)
        val editText3 = findViewById<EditText>(R.id.editTextLoanPeriod)
        val editText4 = findViewById<EditText>(R.id.editTextInterestRate)
        val textview1 = findViewById<TextView>(R.id.textViewLoan)
        val textview2 = findViewById<TextView>(R.id.textViewInterest)
        val textview3 = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        editText1.setHint(R.string.car_price)
        editText2.setHint(R.string.down_payment)
        editText3.setHint(R.string.loan_period)
        editText4.setHint(R.string.interest_rate)
        textview1.setHint(R.string.loan)
        textview2.setHint(R.string.interest)
        textview3.setHint(R.string.monthly_repayment)
        editText1.setText("")
        editText2.setText("")
        editText3.setText("")
        editText4.setText("")


    }
}

