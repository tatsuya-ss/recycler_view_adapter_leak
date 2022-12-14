package com.example.recycler_view_adapter_leak

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_adapter_leak.databinding.AdapterSubBinding

class SubAdapter(
    private val list: List<String>,
    private val listener: Listener
) :
    RecyclerView.Adapter<SubAdapter.SubViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubViewHolder {
        val binding = AdapterSubBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false,
        )
        return SubViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: SubViewHolder, position: Int) {
        holder.setup(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SubViewHolder(
        private val binding: AdapterSubBinding,
        private val listener: Listener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setup(text: String) {
            binding.textView.text = text
            binding.textView.setOnClickListener {
                listener.onClick()
            }
        }
    }

    interface Listener {
        fun onClick()
    }
}