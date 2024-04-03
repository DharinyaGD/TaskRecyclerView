package com.example.taskrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskrecyclerview.databinding.FragmentUserRvBinding
import kotlinx.coroutines.launch

class UserRvFragment : Fragment(R.layout.fragment_user_rv), RowClickListener {

    private lateinit var binding: FragmentUserRvBinding
    private lateinit var adapter: RvAdapter
    private lateinit var recyclerView: RecyclerView

    private var dataList: MutableList<UsersDataClass> = mutableListOf()

    private val viewModel: UserRvViewModel by viewModels {
        UserRvViewModelFactory(
            requireActivity().application,
            Repository(
                AppDataBase.getDataBase(requireContext().applicationContext).userDao()
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUserRvBinding.bind(view)

        recyclerView = binding.recyclerView
        adapter = RvAdapter(dataList, this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        lifecycleScope.launch {
            viewModel.userList.collect { userList ->
                dataList.clear()
                dataList.addAll(userList)
                adapter.notifyDataSetChanged()
            }
        }
    }
    override fun onDeleteUserClickListener(user: UsersDataClass) {
        viewModel.deleteUserInfo(user)
    }
}

// notifyDataSetChanged() - typically called after you modify the dataset (add, remove, or change items)
// to inform the RecyclerView that it needs to update its layout based on the new data.