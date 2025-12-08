package br.com.antoniodev.lojavirtual.di

import br.com.antoniodev.lojavirtual.data.api.DummyJsonApi
import br.com.antoniodev.lojavirtual.data.respository.IRepositoryProduto
import br.com.antoniodev.lojavirtual.data.respository.RepositoryProdutoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providerDummyApi(retrofit: Retrofit): DummyJsonApi{
           return retrofit.create(DummyJsonApi::class.java)
    }

    @Provides
    fun providerRepositoryProduto(dummyJsonApi: DummyJsonApi): IRepositoryProduto{
          return RepositoryProdutoImpl(dummyJsonApi)
    }

}