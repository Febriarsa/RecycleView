package com.example.recycleview

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = DisasterAdapter(generateDataDummy()) { disaster ->
            Toast.makeText(this@MainActivity, "You Click On ${disaster.nameDisaster}", Toast.LENGTH_SHORT).show()
        }

        with(binding) {
            rvDisaster.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generateDataDummy(): List<Disaster> {
        return listOf(
            Disaster(nameDisaster = "Cake", disasterImage = R.drawable.cake),
            Disaster(nameDisaster = "Headphone", disasterImage = R.drawable.headphones),
            Disaster(nameDisaster = "Lamp", disasterImage = R.drawable.lamp),
            Disaster(nameDisaster = "Moon", disasterImage = R.drawable.moon),
            Disaster(nameDisaster = "Smile", disasterImage = R.drawable.smile),
            Disaster(nameDisaster = "Stars", disasterImage = R.drawable.stars)
        )
    }
}
