package com.example.android.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.LoginFragmentBinding

/*
* Fragment for Loin screen*/
class LoginFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.login_fragment, container, false)

        binding.signinButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }
        binding.signupButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
        }
        return binding.root
    }
}
