package br.com.antoniodev.lojavirtual.presentation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import br.com.antoniodev.lojavirtual.databinding.ItemProdutoBinding
import br.com.antoniodev.lojavirtual.model.produto.Product
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory
import com.squareup.picasso.Picasso

class AdapterProduto(val onclickProduto: (Product)-> Unit): RecyclerView.Adapter<AdapterProduto.ViewHolderProduto>() {

    val listaProdutos = mutableListOf<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProduto {
         val layoutInflater = LayoutInflater.from(parent.context)
         val binidng = ItemProdutoBinding.inflate( layoutInflater, parent, false )
          return ViewHolderProduto(binidng)
    }

    override fun onBindViewHolder(holder: ViewHolderProduto, position: Int) {
            val produto = listaProdutos[position]
            holder.bind( produto )
    }

    override fun getItemCount() = listaProdutos.size

    inner class ViewHolderProduto(val binding: ItemProdutoBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(produto: Product){
               binding.tvNomeProduto.text = produto.title
               Picasso.get().load( produto.images[0] ).into( binding.ivProduto )

               binding.cardItem.setOnClickListener{

                   onclickProduto(produto)

               }
        }
    }
}