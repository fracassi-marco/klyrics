package klyrics

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SongTest {
    @Test
    fun shouldComposeCode() {
        val song = Song("U2", "Beautiful day", "Rock", "English")

        assertThat(song.code()).isEqualTo("u2-beautiful-day")
    }
}