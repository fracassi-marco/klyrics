package klyrics

import io.github.bonigarcia.wdm.WebDriverManager
import org.assertj.core.api.Assumptions.assumeThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.phantomjs.PhantomJSDriver

class AcceptanceTest {

    private lateinit var browser: PhantomJSDriver
    private lateinit var klyrics: KLyrics

    @Before
    fun before() {
        WebDriverManager.phantomjs().setup()
        browser = PhantomJSDriver()
        klyrics = KLyrics()
        klyrics.start()
    }

    @After
    fun after() {
        browser.close()
        klyrics.stop()
    }

    @Test
    fun shouldFindLyrics() {
        openPage("/")
        writeAuthor("Aqua")
        writeTitle("Barbie Girl")
        clickSearch()
        assertThatLyricsContains("You can brush my hair")
    }

    private fun assertThatLyricsContains(value: String) {
        assumeThat(browser.pageSource).contains(value)
    }

    private fun clickSearch() =
        browser.findElement(By.id("button-search")).click()

    private fun writeTitle(value: String) =
        browser.findElement(By.id("input-title")).sendKeys(value)

    private fun writeAuthor(value: String) =
        browser.findElement(By.id("input-author")).sendKeys(value)

    private fun openPage(page: String) =
        browser.get("http://localhost:8080$page")
}