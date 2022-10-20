package com.example.midterm.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.midterm.PREFERENCE
import com.example.midterm.R
import com.example.midterm.USERNAME
import com.example.midterm.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
   private lateinit var binding : FragmentSecondBinding
   private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater,container, false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = sharedPreferences.getString(USERNAME,"")
        binding.usernameFrag2.text = String.format("Username: %s", username )
    }
}