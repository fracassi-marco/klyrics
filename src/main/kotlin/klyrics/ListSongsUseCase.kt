package klyrics

class ListSongsUseCase(private val repository: SongsRepository) {
    fun searchBy(category: String, language: String) : List<Song> {
        return repository
                .all()
                .filter { it.category.equals(category) }
                .filter { it.language.equals(language) }
    }
}
