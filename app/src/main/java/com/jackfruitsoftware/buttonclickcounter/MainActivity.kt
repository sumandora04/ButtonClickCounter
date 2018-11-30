package com.jackfruitsoftware.buttonclickcounter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MAIN_ACTIVITY"
private const val TEXT_VIEW_DATA = "TEXT_DATA"

class MainActivity : AppCompatActivity() {
//    private var userInput = null
//    private var userClick = null
//    private var outPutResult = null

    //    private var userInput: EditText? = null
//    private var userClick: Button? = null
    private var outPutResult: TextView? = null

    //private var numTimesClicked = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: Called")

//        userInput = findViewById(R.id.editText)
//        userClick = findViewById(R.id.button)
//        outPutResult = findViewById(R.id.textView)

        val userInput: EditText = findViewById<EditText>(R.id.editText)
        val userClick: Button = findViewById<Button>(R.id.button)
        outPutResult = findViewById<TextView>(R.id.textView)

        outPutResult?.movementMethod =
                ScrollingMovementMethod() //Enables scrolling in a textView. But 1st add scrollView to textView in xml layout.
        outPutResult?.text = ""


        //Long process:
        /* userClick?.setOnClickListener(object : View.OnClickListener {
             override fun onClick(p0: View?) {
                 //Toast.makeText(this@MainActivity,"Button Clicked",Toast.LENGTH_SHORT).show()
                 numTimesClicked += 1
                 outPutResult?.append("The button got tapped for $numTimesClicked time")
                 if (numTimesClicked !=1) {
                     outPutResult?.append("s.\n")
                 }else{
                     outPutResult?.append("\n")
                 }
             }
         })*/


        // ? mark is needed when it is var and not needed when it is val.
//        userClick?.setOnClickListener {
//            //outPutResult?.append(userInput?.text.toString()+"\n") // Single line code
//
//            //Multi-line code.
//            outPutResult?.append(userInput?.text)
//            outPutResult?.append("\n")
//        }


        userClick.setOnClickListener {
            //outPutResult?.append(userInput?.text.toString()+"\n") // Single line code

            //Multi-line code.
            outPutResult?.append(userInput.text)
            outPutResult?.append("\n")
//            userInput.setText("")
            userInput.text.clear()
        }


        //Using lambda expression:
//        userClick?.setOnClickListener {
//
//            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
//        }
    }


    /* Android life-cycle: */

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Called")
    }

    // Restoring data on orientation change
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState: Called")
//        val savedString = savedInstanceState?.getString(TEXT_VIEW_DATA,"")
//        outPutResult?.text = savedString
        outPutResult?.text = savedInstanceState?.getString(TEXT_VIEW_DATA, "")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Called")
    }

    // Saving data on orientation change
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState: Called")
        outState?.putString(TEXT_VIEW_DATA, outPutResult?.text.toString())
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Called")
    }
}
