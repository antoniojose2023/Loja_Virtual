package br.com.antoniodev.lojavirtual.presentation.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.antoniodev.lojavirtual.presentation.view.ProdutoActivity
import br.com.antoniodev.lojavirtual.R
import br.com.antoniodev.lojavirtual.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate( layoutInflater ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.fbtnProdutos.setOnClickListener {
             startActivity(Intent(this, ProdutoActivity::class.java))
             overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        binding.fbtnCarinho.setOnClickListener {

        }

        binding.fbtnUsuario.setOnClickListener {

        }

        binding.fbtnPostagem.setOnClickListener {

        }


    }
}