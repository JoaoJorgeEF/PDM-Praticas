package br.edu.ifpb.carregandointerrogacao

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var isCarregando: TextView
    private lateinit var imageView: ImageView
    private lateinit var ifCabo: IntentFilter
    private var caboReceiver: CaboReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.isCarregando = findViewById(R.id.isCarregando)
        this.imageView = findViewById(R.id.imageView)
    }

    override fun onResume() {
        super.onResume()
        if (this.caboReceiver == null){
            this.caboReceiver = CaboReceiver()
            this.ifCabo = IntentFilter().apply {
                addAction(Intent.ACTION_POWER_CONNECTED)
                addAction(Intent.ACTION_POWER_DISCONNECTED)
            }
        }
        registerReceiver(this.caboReceiver, this.ifCabo)
    }

    inner class CaboReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action.equals(Intent.ACTION_POWER_CONNECTED)){
                this@MainActivity.isCarregando.text = "Connected! Charging device"
                this@MainActivity.imageView.setColorFilter(getResources().getColor(androidx.appcompat.R.color.dim_foreground_material_light))

            }else{
                this@MainActivity.isCarregando.text = "Disconnected! Not charging."
                this@MainActivity.imageView.setColorFilter(getResources().getColor(androidx.appcompat.R.color.dim_foreground_material_dark))
            }
        }
    }
}