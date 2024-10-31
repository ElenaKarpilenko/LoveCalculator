package com.example.lovecalculator.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.di.LoveDataBase
import com.example.lovecalculator.di.room.HistoryEntity
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    @Inject
    lateinit var appDatabase: LoveDataBase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
        initListener()
    }

    @SuppressLint("SetTextI18n")
    private fun fillData() = with(binding) {
        val loveResult = arguments?.getSerializable("calc_result") as LoveModel

        tvYouResult.text = loveResult.firstName
        tvMeResult.text = loveResult.secondName
        scorePercent.text = "${loveResult.percentage}%"

        imgBack.setOnClickListener {
            findNavController().navigate(R.id.calculatorFragment)
        }
//        imgHistory.setOnClickListener {
//            findNavController().navigate(R.id.historyFragment)
//        }
    }
    private fun initListener() {
        binding.imgHistory .setOnClickListener {
            val noteModel = HistoryEntity(
                firstName = binding.tvMeResult.text.toString(),
                secondName = binding.tvYouResult.text.toString(),
                lovePercentage = binding.scorePercent.text.toString(),
                result = "Love Score: ${binding.scorePercent.text}"
            )
            appDatabase.loveDao().insertHistory(noteModel)
            findNavController().navigate(
                R.id.historyFragment
            )
        }
    }
}
