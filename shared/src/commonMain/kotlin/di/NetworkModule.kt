package di

import data.repositories.MoviesRepositoryImpl
import domain.repositories.IMoviesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import presentation.home.HomeViewModel

fun networkModule(enableLog: Boolean) = module {
    single {
        HttpClient {
            expectSuccess = true
            addDefaultResponseValidation()

            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "imdb-top-100-movies.p.rapidapi.com"
                    headers {
                        header(
                            "X-RapidAPI-Key",
                            ""
                        )
                        header("X-RapidAPI-Host", "imdb-top-100-movies.p.rapidapi.com")
                    }
                }
            }

            if (enableLog) {
                install(Logging) {
                    level = LogLevel.ALL
                    logger = object : Logger {
                        override fun log(message: String) {
                            // TODO Save or print log here
                        }
                    }
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                    }
                )
            }
        }
    }
}