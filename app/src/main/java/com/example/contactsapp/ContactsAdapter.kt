package com.example.contactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter(private var contactsItems:ArrayList<ContactItem>):RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>() {


var onItemClickListener:OnItemClickListener?=null

    interface OnItemClickListener{
       fun onItemClick(item:ContactItem,position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.contact_item,parent,false)
        return ContactViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactsItems.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contactsItems[position]
        holder.userName.text = item.name
        holder.phoneNumber.text = item.number.toString()
        holder.itemView.setOnClickListener{
            onItemClickListener?.onItemClick(item,position)
        }

    }
    class ContactViewHolder (view:View):RecyclerView.ViewHolder(view){
        val userName:TextView=itemView.findViewById(R.id.userName)
        val phoneNumber:TextView=itemView.findViewById(R.id.phoneNumber)
    }
}