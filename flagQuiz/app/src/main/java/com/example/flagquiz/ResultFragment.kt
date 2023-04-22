package com.example.flagquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.flagquiz.databinding.FragmentCharacterBinding
import com.example.flagquiz.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding?=null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentResultBinding.inflate(inflater,container,false)
        val view = binding.root

        arguments?.let {
            val incomingTrue = ResultFragmentArgs.fromBundle(it).trueCounter
            val incomingWrong = ResultFragmentArgs.fromBundle(it).wrongCounter

            binding.textViewTrue.text="True: $incomingTrue"
            binding.textViewFalse.text="False: $incomingWrong"
            binding.textViewSuccess.text="Success % ${(incomingTrue*10)}"

        }

        binding.button.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_resultFragment_to_hobbitFragment)
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}