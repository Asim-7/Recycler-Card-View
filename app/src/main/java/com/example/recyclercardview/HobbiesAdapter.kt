package com.example.recyclercardview

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val hobby = hobbies[p1]
        p0.setData(hobby, p1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby: Hobby? = null
        var currentPos: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentHobby!!.title + " Clicked", Toast.LENGTH_SHORT).show()
            }

            itemView.imgShare.setOnClickListener {
                val dataMsg: String = "My hobby is: " + currentHobby!!.title
                //Implicit Intent
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT, dataMsg)
                shareIntent.type = "text/plain"

                context.startActivity(Intent.createChooser(shareIntent,"Share to: "))
            }
        }

        fun setData(hobby: Hobby? , pos: Int){
            itemView.txvTitle.text = hobby!!.title

            this.currentHobby = hobby
            this.currentPos = pos
        }
    }
}