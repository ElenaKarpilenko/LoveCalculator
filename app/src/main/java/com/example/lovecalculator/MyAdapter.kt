package com.example.lovecalculator

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MyAdapter() : ListAdapter<String, MyAdapter.MyViewHolder>(DiffCallback()), Parcelable {

    // Define the ViewHolder class
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(android.R.id.text1)

        // Method to bind data to the TextView
        fun bind(item: String) {
            textView.text = item
        }
    }

    constructor(parcel: Parcel) : this() {
    }

    // This method inflates the layout and creates the ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return MyViewHolder(view) // Returning the ViewHolder instance
    }

    // This method binds the data to the ViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    // DiffCallback class for calculating differences between items efficiently
    class DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyAdapter> {
        override fun createFromParcel(parcel: Parcel): MyAdapter {
            return MyAdapter(parcel)
        }

        override fun newArray(size: Int): Array<MyAdapter?> {
            return arrayOfNulls(size)
        }
    }
}
