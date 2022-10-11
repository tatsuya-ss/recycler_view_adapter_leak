package com.example.recycler_view_adapter_leak

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_adapter_leak.databinding.FragmentSubBinding

class SubFragment : Fragment(), SubAdapter.Listener {
    private var _binding: FragmentSubBinding? = null
    private val binding get() = _binding!!
    private val list = listOf<String>("aaa", "bbb", "ccc", "ddd", "eee")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = DataBindingUtil.inflate<FragmentSubBinding>(
        inflater,
        R.layout.fragment_sub,
        container,
        false
    ).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = SubAdapter(list, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onClick() {
        Log.d("Tatsuya", "onClick: ")
    }

    companion object {
        fun newInstance(): SubFragment {
            return SubFragment()
        }
    }
}