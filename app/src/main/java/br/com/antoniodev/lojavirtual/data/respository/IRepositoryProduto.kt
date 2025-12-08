package br.com.antoniodev.lojavirtual.data.respository

import br.com.antoniodev.lojavirtual.model.produto.Product

interface IRepositoryProduto {

    suspend fun getProdutos(): List<Product>
}