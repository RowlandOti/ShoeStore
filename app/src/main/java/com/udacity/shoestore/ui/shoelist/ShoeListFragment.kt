package com.udacity.shoestore.ui.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoelistBinding

class ShoeListFragment : Fragment() {

    private lateinit var viewModel: ShoeListViewModel

    private lateinit var binding: FragmentShoelistBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoelistBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(ShoeListViewModel::class.java)

        viewModel.getShoeList().observe(viewLifecycleOwner,
            Observer {

            })

        binding.fab.setOnClickListener {
            this.findNavController()
                .navigate(ShoeListFragmentDirections.toShoeDetail())
        }
    }
}