package com.udacity.shoestore.ui.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.data.model.Shoe
import com.udacity.shoestore.databinding.FragmentShoedetailBinding
import com.udacity.shoestore.ui.shoelist.ShoeListViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var shoeListViewModel: ShoeListViewModel
    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: FragmentShoedetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val item = menu.findItem(R.id.logout)
        item?.isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoedetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoeListViewModel = ViewModelProviders.of(requireActivity()).get(ShoeListViewModel::class.java)
        viewModel = ViewModelProviders.of(requireActivity()).get(ShoeDetailViewModel::class.java)

        binding.viewModel = viewModel

        binding.cancelButton.setOnClickListener {
            this.findNavController().popBackStack(R.id.shoeListFragment, false)
        }

        binding.saveButton.setOnClickListener {
            viewModel.getShoe().value?.let {
                shoeListViewModel.addShoeToList(it)
                this.findNavController().popBackStack(R.id.shoeListFragment, false)
            }
        }
    }
}