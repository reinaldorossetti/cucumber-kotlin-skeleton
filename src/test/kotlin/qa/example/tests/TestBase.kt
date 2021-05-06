import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.junit.After
import org.junit.Before
import java.util.concurrent.TimeUnit

open class LocalTestBase {

    lateinit var driver: WebDriver

    @Before
    fun setup() {
        // Before each test
        driver = ChromeDriver()
        driver.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
        driver.manage()?.window()?.maximize()
        driver.get("https://www.google.com/")
    }

    @After
    fun teardown() {
        // After each test
        driver.close()
    }
}