package com.example.note

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
     var save : Button? = null
     var write : EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
         save  = findViewById(R.id.btnsave)
         write = findViewById(R.id.write)
        loadData()
        save?.setOnClickListener{
            saveData()
        }

    }
      private fun saveData(){
        var insertedText = write?.text.toString()
        val sharedPreferences = getSharedPreferences("yourText" , Context.MODE_PRIVATE)
          val editor = sharedPreferences.edit()
          editor.apply{
            putString("STRING_KEY", insertedText)

          }.apply()
          Toast.makeText(this, insertedText  , Toast.LENGTH_SHORT).show();

    }
    private fun loadData(){
        val sharedPreferences = getSharedPreferences("yourText" , Context.MODE_PRIVATE);
        val savetext = sharedPreferences.getString("STRING_KEY",null)
            write?.setText(savetext)
    }

}