package com.example.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ContactDitails : AppCompatActivity() {
lateinit var userName:TextView
    lateinit var userNumber:TextView
    lateinit var userdescription:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_ditails)
        init()
        userNumber.text =intent?.getStringExtra("name")
        userNumber.text =intent?.getStringExtra("number")
        userdescription.text =intent?.getStringExtra("description")
    }
    private fun init(){
        userName=findViewById(R.id.user_name_tv)
        userNumber=findViewById(R.id.user_number_tv)
        userdescription=findViewById(R.id.description_tv)
    }
}