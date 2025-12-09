package br.com.antoniodev.lojavirtual.data.api

import br.com.antoniodev.lojavirtual.model.produto.Product
import br.com.antoniodev.lojavirtual.model.produto.RespostaProduto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DummyJsonApi {
      @GET(/* value = */ "products")
      suspend fun getProduto(): Response<RespostaProduto>

      @GET("products/{id}")
      suspend fun getProdutoPorId(@Path("id") idProduto: Int): Response<Product>
}