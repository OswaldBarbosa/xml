package br.senai.sp.jandira.retrofitreqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var services: Services

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        services = RetrofitHelper.getInstance().create(Services::class.java)

        //button get
        findViewById<Button>(R.id.buttonGet).setOnClickListener {
            getUserByID()
        }

        //button put
        findViewById<Button>(R.id.buttonPut).setOnClickListener {
            Log.e("senaijandira", "teste put")
        }


        //button delete
        findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            Log.e("senaijandira", "teste delete")
        }

        //button post
        findViewById<Button>(R.id.buttonPost).setOnClickListener {
            Log.e("senaijandira", "teste post")
        }

    }

    private fun getUserByID() {
        lifecycleScope.launch {
            val results = services.getUserByID(2)

            if (results.isSuccessful) {
                Log.e("senaijandira", "${results.body()?.data}")
            } else {
                Log.e("senaijandira", "${results.message()}")
            }

        }
    }

}