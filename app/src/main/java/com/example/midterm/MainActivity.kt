package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midterm.databinding.ActivityMainBinding
import com.example.midterm.fragments.FirstFragment
import com.example.midterm.fragments.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.FirstFragmentInterface {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager =supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.frame1.id,FirstFragment())
        fragmentManager.commit()
    }

    override fun edit() {
        val fragmentManager =supportFragmentManager.beginTransaction()
        fragmentManager.replace(binding.frame2.id,SecondFragment())
        fragmentManager.commit()
    }
}