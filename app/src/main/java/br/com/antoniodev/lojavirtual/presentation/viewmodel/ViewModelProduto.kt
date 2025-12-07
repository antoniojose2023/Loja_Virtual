package br.com.antoniodev.lojavirtual.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.antoniodev.lojavirtual.data.api.DummyJsonApi
import br.com.antoniodev.lojavirtual.data.respository.IRepositoryProduto
import br.com.antoniodev.lojavirtual.data.respository.RepositoryProdutoImpl
import br.com.antoniodev.lojavirtual.model.produto.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelProduto @Inject constructor (val repositoryProdutoImpl: IRepositoryProduto): ViewModel() {

    private var _produtos = MutableLiveData<List<Product>>()
    val produtos: LiveData<List<Product>> = _produtos

    private var _produtosPromocionais = MutableLiveData<List<Product>>()
    val produtosPromocionais: LiveData<List<Product>> = _produtosPromocionais

    fun getProdutos(){
        viewModelScope.launch(Dispatchers.IO){
            val listaProdutos = repositoryProdutoImpl.getProdutos()
            _produtos.postValue( listaProdutos )
        }
    }

    fun getProdutosPromocionais(){
        viewModelScope.launch(Dispatchers.IO){
            val listaProdutos = repositoryProdutoImpl.getProdutos()
            _produtosPromocionais.postValue( listaProdutos )
        }
    }

}