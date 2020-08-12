package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(MainViewModel()::class.java)

        viewModel.textWelcome.observe(this, Observer{
            txtMvvm.text=it
            }
        )

        viewModel.login.observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext,"Sucesso!",Toast.LENGTH_LONG).show()
            }else
                Toast.makeText(applicationContext,"Ocorreu algum erro!",Toast.LENGTH_LONG).show()
        })
        buttonTxt.setOnClickListener {
            var login=editTextMvvm.text.toString()
            viewModel.login(login)
        }
    }
}
