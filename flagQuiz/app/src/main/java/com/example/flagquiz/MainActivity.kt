package com.example.flagquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.flagquiz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        copyDatabase()

        binding.imageButton9.setOnClickListener{
            val newIntent = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(newIntent)
            finish()
        }

    }

    fun copyDatabase(){
        val copyHelper = DatabaseCopyHelper(this)
        try{
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch(e:Exception){
            e.printStackTrace()
        }
    }
}