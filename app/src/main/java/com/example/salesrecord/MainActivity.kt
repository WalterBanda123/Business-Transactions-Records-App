package com.example.salesrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var transPosition = POSITION_NOTE_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapterProducts = ArrayAdapter<InventoryInfo>(
            this,
            android.R.layout.simple_spinner_item,
            DataManager.stocks.values.toList()
        )
        adapterProducts.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        findViewById<Spinner>(R.id.spinner_product_list).adapter = adapterProducts


        transPosition = savedInstanceState?.getInt(EXTRA_TRANS_POSITION, POSITION_NOTE_SET)
            ?: intent.getIntExtra(EXTRA_TRANS_POSITION, POSITION_NOTE_SET)
        if (transPosition != POSITION_NOTE_SET) {
            displayTransaction()

        } else {
            DataManager.transactions.add(TransactionInfo())
            transPosition = DataManager.transactions.lastIndex
        }

    }

    private fun displayTransaction() {

        val trans = DataManager.transactions[transPosition]
        findViewById<TextInputEditText>(R.id.product_quantity).setText(trans.quantitySold.toString())
        findViewById<TextInputEditText>(R.id.product_price).setText(trans.productPrice.toString())
        findViewById<TextInputEditText>(R.id.amount_paid).setText(trans.amountPaid.toString())
        findViewById<TextInputEditText>(R.id.change_left).setText(trans.changeLeft.toString())
        val transactionPS = DataManager.sales.values.indexOf(trans.sales)

        findViewById<Spinner>(R.id.spinner_product_list).setSelection(transactionPS)
    }

    override fun onPause() {
        super.onPause()
        saveTransaction()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putInt(EXTRA_TRANS_POSITION, transPosition)
    }

    private fun saveTransaction() {
        val trans = DataManager.transactions[transPosition]
        trans.quantitySold =
            findViewById<TextInputEditText>(R.id.product_quantity).text.toString().toInt()
        trans.amountPaid =
            findViewById<TextInputEditText>(R.id.amount_paid).text.toString().toDouble()
        trans.productPrice =
            findViewById<TextInputEditText>(R.id.product_price).text.toString().toDouble()
        trans.changeLeft =
            findViewById<TextInputEditText>(R.id.change_left).text.toString().toDouble()

        trans.inventory =
            findViewById<Spinner>(R.id.spinner_product_list).selectedItem as InventoryInfo

    }
}