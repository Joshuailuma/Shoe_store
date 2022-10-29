
package com.example.android.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.InstructionFragmentBinding

/**
 * Fragment for instruction screen
 */
class InstructionFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
                inflater,
                R.layout.instruction_fragment,
                container,
                false
        )
        binding.nextButton.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionDestinationToShoeFragment("","","",""))
        }
        return binding.root
    }
}
