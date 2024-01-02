package com.example.whatsappcontacts_kotlin

import android.provider.ContactsContract.Contacts
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsRecyclerAdapter(val items:List<Contact>) : RecyclerView.Adapter<ContactsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = items.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = items[position]
        if(contact!=null) {
            holder.name.text = contact?.name
            holder.image.setImageResource(contact?.imageId ?: R.drawable.profile)
            holder.status.text = contact?.status
        }
        if(onItemClickListener!=null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, items!![position])
            }
        }
    }

    var onItemClickListener : OnItemClickListener?=null

    fun interface OnItemClickListener{
        fun onItemClick(position: Int , item:Contact)
    }
    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        //val image = itemView.findViewById<ImageView>(R.id.contact_image);  Both correct
        val image: ImageView = itemView.findViewById(R.id.contact_image);
        val name: TextView = itemView.findViewById(R.id.name);
        val status: TextView = itemView.findViewById(R.id.status);
    }
}