package com.example.navcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navcomponent.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding as FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root

        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString(HomeFragment.EXTRA_NAME)

        binding.apply {
            txtBundle.text = "Nama Kamu Adalah: $name"
            btnToFragment3.setOnClickListener { view ->
                if (editTextTextPersonName.text.isNullOrEmpty()) {
                    Toast.makeText(requireContext(), "Kolom masih Kosong", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val actionToFragmentKetiga =
                        SecondFragmentDirections.actionSecondFragmentToThirdFragment()
                    actionToFragmentKetiga.name = binding.editTextTextPersonName.text.toString()
                    view.findNavController().navigate(actionToFragmentKetiga)
                }
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle the up button here
        return NavigationUI.onNavDestinationSelected(
            item,
            requireView().findNavController()
        )
                || super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}