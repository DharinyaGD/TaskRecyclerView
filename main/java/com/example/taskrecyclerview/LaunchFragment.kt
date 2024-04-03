package com.example.taskrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskrecyclerview.databinding.FragmentLaunchBinding

class LaunchFragment : Fragment() {

    private lateinit var binding: FragmentLaunchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLaunchBinding.inflate(inflater, container, false)

        binding.btnCreateUser.setOnClickListener {
            findNavController().navigate(R.id.action_launchFragment_to_createUserFragment)
        }
        binding.btnViewList.setOnClickListener {
            findNavController().navigate(R.id.action_launchFragment_to_userRvFragment)
        }
        return binding.root
    }
}