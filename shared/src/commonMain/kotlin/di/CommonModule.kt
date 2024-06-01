package di

import data.repositories.MoviesRepositoryImpl
import domain.repositories.IMoviesRepository
import org.koin.dsl.module

fun commonModule() = module {
    single<IMoviesRepository> {
        MoviesRepositoryImpl(get())
    }
}