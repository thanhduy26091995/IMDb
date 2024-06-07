package di

import data.repositories.MoviesRepositoryImpl
import domain.repositories.IMoviesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.home.HomeViewModel

fun commonModule() = module {
    single<IMoviesRepository> {
        MoviesRepositoryImpl(get())
    }

    singleOf(::HomeViewModel)
}