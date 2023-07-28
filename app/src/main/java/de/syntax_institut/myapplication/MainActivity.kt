package de.syntax_institut.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.marginBottom
import de.syntax_institut.myapplication.adapter.ItemAdapter
import de.syntax_institut.myapplication.adapter.WareAdapter
import de.syntax_institut.myapplication.data.Datasource
import de.syntax_institut.myapplication.data.WareDatasource
import de.syntax_institut.myapplication.data.model.Wareitem
import de.syntax_institut.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {





    companion object{
        private val datasource2 :MutableList<Wareitem> =WareDatasource().dataload()
        public fun getDatsource():MutableList<Wareitem>{
            return this.datasource2
        }
    }


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val datasource = Datasource().loaddata()

        val wareAdapter=WareAdapter(datasource2)

        val itemAdapter=ItemAdapter(this,datasource,datasource2)

        binding.warenkorbRV.adapter =wareAdapter

        if (datasource2.isEmpty()){
            binding.dividerV.bottom = 0
        }
        else{
            binding.dividerV.bottom = 80
        }

        binding.RecylerView.adapter = itemAdapter

        itemAdapter.setonlistchaendlistener(wareAdapter)

        setContentView(binding.root)
    }
}