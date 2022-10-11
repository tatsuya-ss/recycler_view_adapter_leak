package com.example.recycler_view_adapter_leak

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recycler_view_adapter_leak.databinding.ActivitySubBinding

class SubActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainerView, SubFragment.newInstance())
            .commit()
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, SubActivity::class.java)
        }
    }
}