package com.example.salesrecord

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TransactionRecyclerAdapter(
    private val context: Context,
    private val transactions: List<TransactionInfo>
) :
    RecyclerView.Adapter<TransactionRecyclerAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val productTitle = itemView?.findViewById<TextView?>(R.id.text_product_name)
        val productQuantity = itemView?.findViewById<TextView?>(R.id.text_quantity_sold)
        val productPrice = itemView?.findViewById<TextView?>(R.id.text_amount_received)
        var transPosition = 0

        init {
            itemView?.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(EXTRA_TRANS_POSITION, transPosition)
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = layoutInflater.inflate(R.layout.item_transaction_list, parent, false)
        return ViewHolder(itemView)
    }


    override fun getItemCount(): Int {
        return transactions.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val trans = transactions[position]
        holder.productTitle?.text = trans.inventory?.productName
        holder.productQuantity?.text = trans.quantitySold.toString()
        holder.productPrice?.text = trans.amountPaid.toString()
        holder.transPosition = position
    }
}




