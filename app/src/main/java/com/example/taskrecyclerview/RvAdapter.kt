package com.example.taskrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskrecyclerview.databinding.CardViewBinding

class RvAdapter(
    private var dataList: List<UsersDataClass>,
    private val listener: RowClickListener
) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardViewBinding.inflate(inflater, parent, false)
        return RvViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class RvViewHolder(
        private val binding: CardViewBinding,
        private val listener: RowClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: UsersDataClass) {
            binding.user = data

            binding.ivDelete.setOnClickListener {
                listener.onDeleteUserClickListener(data)
            }
        }
    }
}
interface RowClickListener {
    fun onDeleteUserClickListener(user: UsersDataClass)
}

// executePendingBindings() - Evaluates the pending bindings,
// updating any Views that have expressions bound to modified variables.