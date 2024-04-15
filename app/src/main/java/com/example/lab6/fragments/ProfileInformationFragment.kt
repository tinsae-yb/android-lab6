package com.example.lab6.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab6.R
import com.example.lab6.databinding.FragmentProfileInformationBinding


class ProfileInformationFragment(val username: String) : Fragment() {

    lateinit var binding:  FragmentProfileInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileInformationBinding.inflate(inflater, container, false)
        binding.userNameTextView.text = username
        return binding.root
    }

}