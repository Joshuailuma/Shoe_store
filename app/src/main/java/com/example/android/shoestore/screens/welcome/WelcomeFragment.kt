
package com.example.android.shoestore.screens.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.WelcomeFragmentBinding

/**
 * The first screen that displays*/
class WelcomeFragment : Fragment() {

    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_fragment,
            container,
            false
        )
        binding.gotItButton .setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeDestinationToInstructionDestination())
        }
        return binding.root
    }
}