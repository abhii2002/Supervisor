package com.blissvine.supervisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.blissvine.supervisor.adapters.PhotoAdapter
import com.blissvine.supervisor.databinding.ActivityMainBinding
import com.blissvine.supervisor.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val photosAdapter : PhotoAdapter by lazy { PhotoAdapter() }

    private val viewModel : SharedViewModel by lazy {
        ViewModelProvider(this@MainActivity).get(SharedViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)


        viewModel.photosDetailsLiveData.observe(this@MainActivity){
            if (it.isSuccessful){
                Log.d("pll", it.body().toString())
                photosAdapter.setData(it.body()!!)
                binding.rvPhotoDetails.layoutManager =
                    LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                binding.rvPhotoDetails.adapter = photosAdapter
            }
        }
    }
}