package com.example.flagquiz
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.flagquiz.databinding.FragmentCharacterBinding
import com.example.flagquiz.databinding.FragmentHobbitBinding


class HobbitFragment : Fragment() {
    private var _binding: FragmentHobbitBinding?=null
    private val binding get() = _binding!!

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(activity,R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(activity,R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(activity,R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(activity,R.anim.to_bottom_anim) }

    private var clicked = false

    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHobbitBinding.inflate(inflater,container,false)
        val view = binding.root

        binding.addFloatingButton.setOnClickListener{
            onAddButtonClicked()
        }
        binding.ringFloatingButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_hobbitFragment_to_textFragment)
        }
        binding.chrcFloatingBotton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_hobbitFragment_to_characterFragment)
        }
        return view
    }

    private fun onAddButtonClicked() {
        clicked = !clicked
        setAnimation(clicked)
        setVisibility(clicked)
        setClickable(clicked)

    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            binding.ringFloatingButton.visibility= View.VISIBLE
            binding.chrcFloatingBotton.visibility= View.VISIBLE
        }else{
            binding.ringFloatingButton.visibility= View.INVISIBLE
            binding.chrcFloatingBotton.visibility= View.INVISIBLE
        }
    }

    private fun setAnimation(clicked:Boolean) {
        if(!clicked){
            binding.ringFloatingButton.startAnimation(fromBottom)
            binding.chrcFloatingBotton.startAnimation(fromBottom)
            binding.addFloatingButton.startAnimation(rotateOpen)
        }else{
            binding.ringFloatingButton.startAnimation(toBottom)
            binding.chrcFloatingBotton.startAnimation(toBottom)
            binding.addFloatingButton.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked:Boolean){
        if(!clicked){
            binding.ringFloatingButton.isClickable = true
            binding.chrcFloatingBotton.isClickable = true
        }else{
            binding.ringFloatingButton.isClickable = false
            binding.chrcFloatingBotton.isClickable = false
        }
    }


}