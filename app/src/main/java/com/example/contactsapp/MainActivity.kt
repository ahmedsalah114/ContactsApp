package com.example.contactsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.contactsapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var adapter: ContactsAdapter
    private lateinit var contactsList: ArrayList<ContactItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsList=ArrayList<ContactItem>()
        initRecyclerView()
        initContacts()
        onItemClickListener()

    }
    private fun initRecyclerView(){

        initContacts()
        adapter = ContactsAdapter(contactsList)
        binding.contactsRv.adapter=adapter


    }
    private fun onItemClickListener(){
        adapter.onItemClickListener=object:ContactsAdapter.OnItemClickListener{
            override fun onItemClick(item: ContactItem, position: Int) {

                val intent = Intent(this@MainActivity,ContactDitails::class.java)
                intent.putExtra("name",item.name)
                intent.putExtra("number",item.number)
                intent.putExtra("description",item.description)
                startActivity(intent)
            }

        }
    }
    private fun initContacts(){
        binding.btnCreate.setOnClickListener(View.OnClickListener {
            val userName= binding.contactName.text.toString()
            val number= binding.contactNumber.text.toString()
            val description =binding.contactDescription.text.toString()

        if(userName.isEmpty()||userName.length<3){
            Toast.makeText(this@MainActivity,
                "Name can't be empty or less than 3 character!"
                , Toast.LENGTH_SHORT).show()
            return@OnClickListener
        }
        if (number.isEmpty()||number.length!=11){
            Toast.makeText(this@MainActivity,
                "Phone Number can't be empty or greater than and less than 11 digits!",
                Toast.LENGTH_SHORT).show()
            return@OnClickListener
        }
        if (description.isEmpty()){
            Toast.makeText(this@MainActivity,
                "description cant be Empty",
                Toast.LENGTH_SHORT).show()
            return@OnClickListener
        }
        val contactsSize =contactsList.size-1
        for (i in 0..contactsSize) {
            if (userName == contactsList[i].name) {
                Toast.makeText(
                    this@MainActivity,
                    "cant use this name",
                    Toast.LENGTH_SHORT
                ).show()
                binding.contactName.setText("")
                return@OnClickListener
            }
        }

        contactsList.add(ContactItem(userName,number,description))
            binding.contactName.setText("")
            binding.contactNumber.setText("")
            binding.contactDescription.setText("")
            adapter.notifyDataSetChanged()
            })


}
}