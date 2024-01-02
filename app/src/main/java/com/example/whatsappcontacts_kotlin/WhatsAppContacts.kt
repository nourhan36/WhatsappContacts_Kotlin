package com.example.whatsappcontacts_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatsappcontacts_kotlin.databinding.ActivityWhatsAppContactsBinding

class WhatsAppContacts : AppCompatActivity() {
    private lateinit var binding: ActivityWhatsAppContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWhatsAppContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    lateinit var adapter: ContactsRecyclerAdapter
    lateinit var contactsLit: MutableList<Contact>
    private fun initRecyclerView() {
        createContactsList()
        adapter = ContactsRecyclerAdapter(contactsLit)
        binding.rvContacts.adapter = adapter
    }

    private fun createContactsList() {
        contactsLit = mutableListOf()
        for (i in 0..1000) {
            contactsLit.add(
                Contact(
                    id = i,
                    name = "contact num $i",
                    status = "busy",
                    imageId = R.drawable.profile
                )
            )
        }
    }
}