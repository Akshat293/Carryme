package com.example.carryme.ui.shoppinglist

import com.example.carryme.data.db.entities.ShoppingItem

interface AddDialogListner {
    fun onAddButtonClicked(item:ShoppingItem)
}