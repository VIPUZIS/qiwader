package ru.vipuzis.qiwader

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.vipuzis.qiwader.data.model.MainViewModel
import kotlin.toString


class HomePage : AppCompatActivity() {
    private val mainVM: MainViewModel by viewModels()

    @SuppressLint("MissingInflastedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val textCount = findViewById<TextView>(R.id.bits_q)

        val btnnxtboostsbutton = findViewById<Button>(R.id.nxtboosts)
        val intentthispage1 = Intent(this, boosts::class.java)
        btnnxtboostsbutton.setOnClickListener {
            startActivity(intentthispage1)
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

        mainVM.count.observe(this) { count ->
            textCount.text = "Bits: " + count.toString()
        }

        val el_tap = findViewById<ImageView>(R.id.el_tap)

        el_tap.setOnClickListener {
            mainVM.plus()
        }
    }

}