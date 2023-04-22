package com.example.flagquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.flagquiz.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding :  ActivityMain2Binding

    /*
    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this,R.anim.to_bottom_anim) }

    private var clicked = false
    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        binding.addFloatingButton.setOnClickListener{
            onAddButtonClicked()
        }
        binding.ringFloatingButton.setOnClickListener {
            Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
        }
        binding.chrcFloatingBotton.setOnClickListener {
           //  Toast.makeText(this,"clicked",Toast.LENGTH_LONG).show()
        }
            */


    }

    /*
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

*/
}
