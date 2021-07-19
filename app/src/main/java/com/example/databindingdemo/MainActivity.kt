package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var aPerson: Person = Person("Ali","950302145000","Ali@gmail","No.12,Jalan Abc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //binds the entire UI's content into "binding" variable

        binding.personData = aPerson

        binding.btnUpdate.setOnClickListener(){
            aPerson.email = "AliOnbtnUpdateChange@gmail.com"
            binding.apply { invalidateAll() } //Apply any changes to the binding
        }
    }
}