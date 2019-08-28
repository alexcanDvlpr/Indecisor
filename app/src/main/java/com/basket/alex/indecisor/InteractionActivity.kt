package com.basket.alex.indecisor

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.*
import kotlinx.android.synthetic.main.activity_interaction.*

class InteractionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interaction)

        val inItem: EditText = findViewById<EditText>(R.id.newItem_input)
        val btnAdd: Button = findViewById(R.id.btnAdd) as Button
        val btnResolve: Button = findViewById(R.id.btnResolve) as Button
        val lstItems:  MutableList<String> = mutableListOf<String>()
        val listView: ListView = findViewById<ListView>(R.id.lstItems)

        btnAdd.setOnClickListener {
            if (!inItem.text.toString().isNullOrEmpty())
                lstItems.add(inItem.text.toString())
            setItemsIntoList(lstItems, listView)
            inItem.setText("")
        }

        btnResolve.setOnClickListener {
            val itemSelected = lstItems.get(selectItemRandom(lstItems.size))
            showDialog(this, R.string.title_dialog, "He decidido... $itemSelected", R.string.close)
        }

    }

    fun setItemsIntoList(list: MutableList<String>, listView: ListView) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listView.adapter = adapter
    }

    fun selectItemRandom(size: Int): Int {
        val random: Double = Math.floor(Math.random() * size)
        val index: Int = random.toInt()
        return index
    }

    fun showDialog(context: Context, title: Int, message: String, btnText: Int) {

        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton(btnText) { dialog, which ->
            // Se deja en blanco para cerrar el show dialog
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}
