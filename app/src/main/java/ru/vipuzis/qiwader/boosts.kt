package ru.vipuzis.qiwader

import android.content.Intent
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
        val btnbackbyboostsbutton = findViewById<Button>(R.id.backbyboosts)
        val intentback = Intent(this, HomePage::class.java)
        btnbackbyboostsbutton.setOnClickListener {
            startActivity(intentback)
        }
        val autoclickerPrice = 25000
        val bostsClicksPrice = 5000
        val bostsIncomePrice = 250000
        val ac = findViewById<Button>(R.id.btnautoclicker)
        val bstCl = findViewById<Button>(R.id.btnbostsClicks)
        val bostIncPr = findViewById<Button>(R.id.btnbostsIncomePrice)

        ac.setOnClickListener {
            if(!mainVM.isUsedAutoclickerPrice.value!!){
                mainVM.buyMultiple(5, 120, mainVM.isUsedAutoclickerPrice)
            }
        }
        bstCl.setOnClickListener {
            if(!mainVM.isUsedBostsClicksPrice.value!!){
                mainVM.buyMultiple(15, 1000, mainVM.isUsedBostsClicksPrice)
            }
        }
        bostIncPr.setOnClickListener {
            if(!mainVM.isUserBostsIncomePrice.value!!){
                mainVM.buyMultiple(50, 10000, mainVM.isUserBostsIncomePrice)
            }
        }
    }
}