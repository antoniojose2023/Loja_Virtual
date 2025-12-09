package br.com.antoniodev.lojavirtual.presentation.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import br.com.antoniodev.lojavirtual.R
import br.com.antoniodev.lojavirtual.databinding.ActivityProdutoBinding
import br.com.antoniodev.lojavirtual.presentation.AdapterProduto
import br.com.antoniodev.lojavirtual.presentation.viewmodel.ViewModelProduto
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProdutoActivity : AppCompatActivity() {
    private val binding by lazy { ActivityProdutoBinding.inflate( layoutInflater ) }
    private lateinit var adapterProduto: AdapterProduto
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


        viewModelProduto.produtosPromocionais.observe(this){ produtos ->
            if(produtos != null){
                configRecyclerViewHorizontal()
                adapterProduto.listaProdutos.clear()
                adapterProduto.listaProdutos.addAll( produtos )
                adapterProduto.notifyDataSetChanged()
            }
        }


        viewModelProduto.produtos.observe(this){ produtos ->
                 if(produtos != null){
                       configRecyclerViewVertical()
                       adapterProduto.listaProdutos.clear()
                       adapterProduto.listaProdutos.addAll( produtos )
                       adapterProduto.notifyDataSetChanged()
                 }
        }



    }

    private fun configRecyclerViewHorizontal() {
           adapterProduto = AdapterProduto(){product ->
                    val intent = Intent(this, ProdutoDetalheActivity::class.java)
                    intent.putExtra("idProduto", product.id)
                    startActivity( intent )
           }
           binding.rvProdutosPromocao.layoutManager = LinearLayoutManager( this, RecyclerView.HORIZONTAL, false )
           binding.rvProdutosPromocao.adapter = adapterProduto
    }

    private fun configRecyclerViewVertical() {
           adapterProduto = AdapterProduto(){product ->
               val intent = Intent(this, ProdutoDetalheActivity::class.java)
               intent.putExtra("idProduto", product.id)
               startActivity( intent )
           }
           binding.rvProdutos.layoutManager = LinearLayoutManager( this, RecyclerView.VERTICAL, false )
           binding.rvProdutos.adapter = adapterProduto
    }

    override fun onStart() {
        viewModelProduto.getProdutos()
        viewModelProduto.getProdutosPromocionais()
        super.onStart()
    }
}