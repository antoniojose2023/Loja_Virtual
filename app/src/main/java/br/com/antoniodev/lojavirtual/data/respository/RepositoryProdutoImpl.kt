package br.com.antoniodev.lojavirtual.data.respository

import br.com.antoniodev.lojavirtual.data.api.DummyJsonApi
import br.com.antoniodev.lojavirtual.model.produto.Product
import javax.inject.Inject

class RepositoryProdutoImpl @Inject constructor(val dummyJsonApi: DummyJsonApi): IRepositoryProduto {
    override suspend fun getProdutos(): List<Product> {
         val response = dummyJsonApi.getProduto()

         if(response.isSuccessful && response.body() != null){
               val produtos = response.body()?.products
               if (produtos != null && produtos.isNotEmpty()) {
                      return produtos

               }
         }

         return emptyList()
    }

    override suspend fun getProdutoPorId(idProduto: Int): Product {
        val response = dummyJsonApi.getProdutoPorId( idProduto )
        var produto: Product? = null

       if(response.isSuccessful && response.body() != null){
                produto = response.body()
       }

       return produto!!

    }
}