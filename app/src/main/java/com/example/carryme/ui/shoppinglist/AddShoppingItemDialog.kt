package com.example.carryme.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.carryme.R
import com.example.carryme.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_shopping_item.*
import kotlinx.android.synthetic.main.shopppingitems.*

class AddShoppingItemDialog(context: Context,val addDialogListner: AddDialogListner):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_shopping_item)
        tvAdd.setOnClickListener{
            val name:String=etName.text.toString()
            val amount:String=etAmount.text.toString()
            if(name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context,"Please enter all the information",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item=ShoppingItem(name,amount.toInt())
            addDialogListner.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener{
            cancel()
        }



    }
}