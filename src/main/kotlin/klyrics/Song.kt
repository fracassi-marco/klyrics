package klyrics

data class Song(val author: String, val title: String, val category: String, val language: String, var lyrics: String = "") {
    fun code() : String {
        return "${normalize(author)}-${normalize(title)}"
    }

    private fun normalize(value: String): String  = value.toLowerCase().replace(" ", "-")
}
