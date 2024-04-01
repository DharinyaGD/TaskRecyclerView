package com.example.taskrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.taskrecyclerview.databinding.FragmentCreateUserBinding

class CreateUserFragment : Fragment() {

    private lateinit var binding: FragmentCreateUserBinding
    private val viewModel: CreateUserViewModel by viewModels {
        CreateUserViewModelFactory(
            requireActivity().application,
            Repository(
                AppDataBase.getDataBase(requireContext().applicationContext).userDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_user, container, false)
        binding.create = UsersDataClass(userName = "", password = "")
        binding.lifecycleOwner = this
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            val username = binding.etCreateUserName.text.toString()
            val password = binding.etCreatePassword.text.toString()

            if (validateInput(username, password)) {
                viewModel.saveUser(username, password)

                binding.etCreateUserName.text.clear()
                binding.etCreatePassword.text.clear()
            }
        }
    }

    private fun validateInput(username: String, password: String): Boolean {
        if (username.isEmpty()) {
            binding.etCreateUserName.error = "Please enter a username"
            return false
        }

        if (password.isEmpty()) {
            binding.etCreatePassword.error = "Please enter a password"
            return false
        }
        return true
    }
}

// DataBindingUtil -  It is used to bind layout files with data variables in your Android application.
// Helps in connecting the layout XML files with the data in app's code.