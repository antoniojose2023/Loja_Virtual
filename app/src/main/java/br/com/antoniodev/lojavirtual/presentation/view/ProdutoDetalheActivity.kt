package br.com.antoniodev.lojavirtual.presentation.view

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.antoniodev.lojavirtual.R
import br.com.antoniodev.lojavirtual.databinding.ActivityProdutoDetalheBinding
import br.com.antoniodev.lojavirtual.presentation.viewmodel.ViewModelProduto
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProdutoDetalheActivity : AppCompatActivity() {

    private val binding by lazy{ ActivityProdutoDetalheBinding.inflate(layoutInflater) }

   var idProduto: Int? = null
   private val viewModelProduto: ViewModelProduto by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras

        if(bundle != null){
            idProduto = bundle.getInt("idProduto", 0)
        }

//        viewModelProduto.getProdutoPorId( idProduto!! )

        viewModelProduto.produto.observe(this){ produto ->
             if(produto != null){
                  binding.tvNomeProdutoDetalhes.text = produto.title
                  binding.tvDescricaoProdutoDetalhes.text = produto.description
                  Picasso.get().load(produto.images[0]).into( binding.ivProdutoDetalhes )
             }
        }


    }

    override fun onStart() {
        viewModelProduto.getProdutoPorId( idProduto!! )
        super.onStart()
    }
}