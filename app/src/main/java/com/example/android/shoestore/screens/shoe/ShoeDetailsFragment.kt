package com.example.android.shoestore.screens.shoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.shoestore.databinding.FragmentShoeDetailsBinding
import com.example.android.shoestore.R

/**
 * Screen Where new shoes can be added
 */
class ShoeDetailsFragment : Fragment() {
    private lateinit var viewModel: ShoeViewModel
    private lateinit var shoeName: String
    private lateinit var shoeCompany: String
    private lateinit var shoeSize: String
    private lateinit var shoeDescription: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view and obtain an instance of the binding class.
        val binding = DataBindingUtil.inflate<FragmentShoeDetailsBinding>(
            inflater,
            R.layout.fragment_shoe_details,
            container,
            false
        )
        // Request VM from library
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        binding.lifecycleOwner = requireActivity()
        binding.clickListener = viewModel

        // We previously stored the texfield data unto the view model. Now we are retrieving it
        // to eventualy be passed to the main screen
        viewModel.shoeName.observe(viewLifecycleOwner, Observer { name->
            if (name != null) {
                shoeName = name
            }
        })

        viewModel.shoeCompany.observe(viewLifecycleOwner, Observer { company->
            if (company != null) {
                shoeCompany = company
            }
        })

        viewModel.shoeSize.observe(viewLifecycleOwner, Observer { size->
            if (size != null) {
                shoeSize = size
            }
        })

        viewModel.shoeDescription.observe(viewLifecycleOwner, Observer { description->
            if (description != null) {
                shoeDescription = description
            }
        })

        // When cancel button is pressed
        binding.buttonCancel .setOnClickListener {
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeFragment("","","",""))
            // Clear the fields after navigation is complete
            viewModel.navigationComplete()
        }
        binding.buttonSave.setOnClickListener {
            // Add the tis list to the model class
            viewModel.addShoe(mutableListOf(shoeName, shoeCompany, shoeSize, shoeDescription))
            findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeFragment(shoeName, shoeCompany, shoeSize, shoeDescription))
            // Clear the fields after navigation is complete
            viewModel.navigationComplete()
        }
        return binding.root
    }
}