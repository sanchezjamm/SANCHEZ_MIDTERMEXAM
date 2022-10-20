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
import com.example.midterm.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var firstFragmentInterface: FirstFragmentInterface

    interface FirstFragmentInterface {
        fun edit()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        firstFragmentInterface = context as FirstFragmentInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container,false)
        sharedPreferences = requireActivity().getSharedPreferences(PREFERENCE,Context.MODE_PRIVATE)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSaveUser.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val username = binding.UsernameFrag1.text.toString()
        if (username == "") {
            binding.UsernameFrag1.error = "Required"
            return
        } else if (username.length < 6) {
            binding.UsernameFrag1.error = "Should be 6 char"
            return
        } else {
            val editor = sharedPreferences.edit()
            editor.putString(USERNAME,username)
            editor.apply()

            firstFragmentInterface.edit()

        }
    }
}