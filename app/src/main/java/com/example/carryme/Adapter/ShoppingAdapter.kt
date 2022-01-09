package com.example.carryme.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carryme.R
import com.example.carryme.data.db.entities.ShoppingItem
import com.example.carryme.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopppingitems.view.*

class ShoppingAdapter (
    var items:List<ShoppingItem>,
    val ViewModel:ShoppingViewModel
        ):RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>(){
    var chk:Boolean=false




    inner class ShoppingViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.shopppingitems,parent,false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
      val currentitem=items[position]
        holder.itemView.tvName.text=currentitem.name
        holder.itemView.tvAmount.text="${currentitem.amount}"
        holder.itemView.ivDelete.setOnClickListener{
            ViewModel.delete(currentitem)
        }
        holder.itemView.tvName.setOnClickListener{
           if(!currentitem.name.isEmpty()){
               holder.itemView.tvName.text=currentitem.name
           }
        }
        holder.itemView.ivPlus.setOnClickListener{
            currentitem.amount++
            ViewModel.upsert(currentitem)
        }
        holder.itemView.ivMinus.setOnClickListener{
            if(currentitem.amount>0){
                currentitem.amount--
                ViewModel.upsert(currentitem)
            }

        }

        holder.itemView.star.setOnClickListener{
                holder.itemView.star.visibility=View.INVISIBLE
                holder.itemView.star1.visibility=View.VISIBLE
        }
        holder.itemView.star1.setOnClickListener{

                holder.itemView.star.visibility=View.VISIBLE
                holder.itemView.star1.visibility=View.INVISIBLE


        }


    }

    override fun getItemCount(): Int {
       return items.size
    }
}