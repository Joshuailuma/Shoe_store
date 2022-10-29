package com.example.android.shoestore.screens.shoe

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.FragmentShoeBinding
import kotlin.random.Random

/**
 * The screen where list of shoes are displayed
 */
class ShoeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding :FragmentShoeBinding  = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe,
            container,
            false
        )
        // Request VM from library
        var viewModel: ShoeViewModel  = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        viewModel.shoes.observe(viewLifecycleOwner, Observer{ shoes->
            for (i in shoes){

                // Get ListView id
                val myLayout= binding.rootView

                // Creating a LinearLayout.LayoutParams object for text view
                var params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT)

                // Create a new TextView instance programmatically
                val textView = TextView(context?.applicationContext)

                // Get each text from the loop
                textView.text = i.toString()
                // Set an id for the text view
                textView.id = Random.nextInt()
                // Finally, add the text view to the view group
                myLayout.addView(textView)
            }
        })

        // When FAB is pressed
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToShoeDetailsFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options, menu)
    }

    //Hook button with about
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Go to login screen when pressed
            findNavController().navigate(ShoeFragmentDirections.actionShoeFragmentToLoginDestination())
        return super.onOptionsItemSelected(item)
    }
}