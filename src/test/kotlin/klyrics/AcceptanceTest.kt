package klyrics

import org.openqa.selenium.support.ui.Select;
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
        choseCategory("Pop")
        choseLanguage("English")
        clickSearch()
        click("Aqua - Barbie Girl")
        assertThatLyricsContains("You can brush my hair")
    }

    private fun click(value: String) =
            browser.findElement(By.linkText(value)).click()

    private fun choseCategory(value: String) {
        select("select-category", value)
    }

    private fun choseLanguage(value: String) {
        select("select-language", value)
    }

    private fun select(id: String, value: String) {
        Select(browser.findElement(By.id(id))).selectByVisibleText(value)
    }

    private fun assertThatLyricsContains(value: String) {
        assumeThat(browser.pageSource).contains(value)
    }

    private fun clickSearch() =
        browser.findElement(By.id("button-search")).click()

    private fun openPage(page: String) =
        browser.get("http://localhost:8080$page")
}