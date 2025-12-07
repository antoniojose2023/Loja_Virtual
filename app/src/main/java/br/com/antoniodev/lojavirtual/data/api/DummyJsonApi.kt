package br.com.antoniodev.lojavirtual.data.api

import br.com.antoniodev.lojavirtual.model.produto.RespostaProduto
import retrofit2.Response
import retrofit2.http.GET

interface DummyJsonApi {
      @GET("products")
      suspend fun getProduto(): Response<RespostaProduto>
}