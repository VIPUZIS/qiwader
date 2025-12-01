package ru.vipuzis.qiwader

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var count = 0
        var multiple = 1

        val textCount = findViewById<TextView>(R.id.bits_q)
        val imageLevel1 = findViewById<ImageView>(R.id.el_tap)
        imageLevel1.setOnClickListener {
            count += Plus(multiple)
            textCount.setText("Bits: " + count.toString())
        }

        val btnnxtboostsbutton = findViewById<Button>(R.id.nxtboosts)
        val intentthispage1 = Intent(this, boosts::class.java)
        btnnxtboostsbutton.setOnClickListener {
            startActivity(intent)
        }
        val btndntmplsbutton = findViewById<Button>(R.id.dntmplsbtn)
        val intentthispage2 = Intent(this, dntmepls::class.java)
        btndntmplsbutton.setOnClickListener {
            startActivity(intentthispage2)
        }

        val btnmyprgrssbutton = findViewById<Button>(R.id.myprgrss)
        val intentthispage3 = Intent(this, progress::class.java)
        btnmyprgrssbutton.setOnClickListener {
            startActivity(intentthispage3)
        }
    }
    fun Plus(multiple: Int): Int {
        return 1*multiple
    }



}