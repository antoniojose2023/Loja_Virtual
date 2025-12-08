package br.com.antoniodev.lojavirtual.model.produto

data class RespostaProduto(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)