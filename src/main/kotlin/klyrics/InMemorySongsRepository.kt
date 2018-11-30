package klyrics

class InMemorySongsRepository : SongsRepository {
    override fun all(): List<Song> {
        return listOf(
                Song("Jovanotti", "Bella", "Rap", "Italian"),
                Song("Jovanotti", "Serenata Rap", "Rap", "Italian"),
                Song("Articolo 31", "Volume", "Rap", "Italian"),
                Song("Shandon", "Nice Try", "Ska", "Italian"),
                Song("U2", "Pride", "Rock", "English"),
                Song("Aqua", "Barbie Girl", "Pop", "English"),
                Song("U2", "Prides", "Pop", "English"))
    }

}
