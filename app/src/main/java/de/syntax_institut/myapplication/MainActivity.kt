package de.syntax_institut.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.syntax_institut.myapplication.adapter.ItemAdapter
import de.syntax_institut.myapplication.data.Datasource
import de.syntax_institut.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datasource = Datasource().loaddata()

        val recyclerView = binding.RecylerView

        binding.RecylerView.adapter = ItemAdapter(this,datasource)

        setContentView(binding.root)
    }
}