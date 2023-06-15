package com.example.uts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val novel = intent.getParcelableExtra<NovelClass>(MainActivity.INTENT_PARCELABLE)

        val novelimg = findViewById<ImageView>(R.id.image)
        val novelname = findViewById<TextView>(R.id.tv_name)
        val noveldate = findViewById<TextView>(R.id.tv_date)
        val novelauthor = findViewById<TextView>(R.id.tv_author)
        val noveldesc = findViewById<TextView>(R.id.tv_description)

        novelimg.setImageResource(novel?.novelimg!!)
        novelname.text = novel.novelname
        noveldate.text = novel.noveldate
        novelauthor.text = novel.novelauthor
        noveldesc.text = novel.noveldesc

        val buttonOpenLink = findViewById<Button>(R.id.buttonOpenLink)
        buttonOpenLink.setOnClickListener {
            val url = "https://shopee.co.id/Buku-Novel-Tere-Liye-Bumi-Bulan-Matahari-Bintang-Ceroz-Dan-Batozar-Komet-Komet-Minor-Selena-Nebula-Si-Putih-Lumpu-Bibi-Gill-Matahari-Minor-Sagaras-Original-Best-Seller-i.254959171.9870247804"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {

        onBackPressed()
        return true
    }
}