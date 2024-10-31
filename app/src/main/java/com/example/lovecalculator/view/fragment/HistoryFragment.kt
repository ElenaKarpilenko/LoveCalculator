package com.example.lovecalculator.view.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.di.LoveDataBase
import com.example.lovecalculator.di.room.HistoryEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var historyDao: LoveDataBase
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        historyAdapter = HistoryAdapter { historyEntity ->
            showDeleteDialog(historyEntity)
        }

        binding.recyclerView.apply {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(context)
        }

        val historyList = historyDao.loveDao().getAllHistorySorted()
        historyAdapter.submitList(historyList)

        binding.img.setOnClickListener {
            findNavController().navigateUp()
        }
        updateNoteList()
    }
    private fun updateNoteList() {
        val notes = historyDao.loveDao().getAll()
        historyAdapter.submitList(notes)
    }


    private fun showDeleteDialog(historyEntity: HistoryEntity) {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.delete_dialog, null)

        dialogView.findViewById<TextView>(R.id.dialog_title).text = "Delete Item"
        dialogView.findViewById<TextView>(R.id.dialog_message).text =
            "Are you sure, you want to delete this item?"

        val builder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setPositiveButton("Yes") { dialog, _ ->
                lifecycleScope.launch {
                    historyDao.loveDao().deleteHistory(historyEntity)
                    val updatedList = historyDao.loveDao().getAllHistorySorted()
                    historyAdapter.submitList(updatedList)
                }
                dialog.dismiss()
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        builder.show()
    }
}