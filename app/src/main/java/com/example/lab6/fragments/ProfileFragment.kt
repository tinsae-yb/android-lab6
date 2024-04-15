package com.example.lab6.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.lab6.databinding.FragmentProfileBinding
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        lifecycleScope.launch {
            viewModel.loginStatus.collect{
                if(it == LoginStatus.SIGN_OUT){
                    childFragmentManager.beginTransaction().replace(
                        binding.fragmentContainerView.id,
                        LoginFragment(){
                            viewModel.login(it)
                        }
                    ).commit()
                }else if(it == LoginStatus.LOGGED_IN){
                    childFragmentManager.beginTransaction().replace(
                        binding.fragmentContainerView.id,
                        ProfileInformationFragment(viewModel.name.value)
                    ).commit()
                }
            }
        }


    }


}