package com.example.salesrecord

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TransactionListActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_list)

        findViewById<FloatingActionButton>(R.id.fabButton).setOnClickListener {
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        findViewById<RecyclerView>(R.id.transactionList).layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.transactionList).adapter =
            TransactionRecyclerAdapter(this, DataManager.transactions)

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        //(findViewById<ListView>(R.id.listTransactions).adapter as ArrayAdapter<*>).notifyDataSetChanged()
        findViewById<RecyclerView>(R.id.transactionList).adapter?.notifyDataSetChanged()
    }
}