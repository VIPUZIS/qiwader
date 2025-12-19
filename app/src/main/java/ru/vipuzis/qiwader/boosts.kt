package ru.vipuzis.qiwader

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.vipuzis.qiwader.data.model.MainViewModel

class boosts : AppCompatActivity() {

    private val mainVM: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_boosts)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val autoclickerPrice = 25000
        val bostsClicksPrice = 5000
        val bostsIncomePrice = 250000
        val ac = findViewById<Button>(R.id.btnautoclicker)
        val bstCl = findViewById<Button>(R.id.btnbostsClicks)
        val bostIncPr = findViewById<Button>(R.id.btnbostsIncomePrice)
    }
}