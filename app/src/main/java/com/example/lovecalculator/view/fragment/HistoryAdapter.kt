package com.example.lovecalculator.view.fragment


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemColorBinding
import com.example.lovecalculator.di.room.HistoryEntity

class HistoryAdapter(private val onLongClickListener: (HistoryEntity) -> Unit) :
    ListAdapter<HistoryEntity, HistoryAdapter.HistoryViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemColorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
        holder.itemView.setOnLongClickListener {
            onLongClickListener(current)
            true
        }
    }

    class HistoryViewHolder(private val binding: ItemColorBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(historyEntity: HistoryEntity) {
            binding.tvName1.text = historyEntity.firstName
            binding.tvName2.text = historyEntity.secondName
            binding.tvResult.text = historyEntity.result
            binding.tvPercentage.text = historyEntity.lovePercentage
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<HistoryEntity>() {
            override fun areItemsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}
