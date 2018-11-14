package klyrics

class HomepageUseCase(private val repository: SongsRepository) {
    fun categories() : Set<String> {
        return repository.all().groupBy { it.category }.keys
    }

    fun languages(): Set<String> {
        return repository.all().groupBy { it.language }.keys
    }
}
