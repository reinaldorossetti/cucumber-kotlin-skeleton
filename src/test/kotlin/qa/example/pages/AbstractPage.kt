package qa.example.pages

import qa.example.extensions.WithExtensions
import qa.example.extensions.WithPageUrl
import qa.example.extensions.WithWebDriver
import org.openqa.selenium.WebDriver
import io.qameta.allure.Step

abstract class AbstractPage(driver: WebDriver) : WithPageUrl, WithWebDriver, WithExtensions {

    override fun baseUrl(): String = config.getString("application.url")

    fun openUrl() = openUrl(pageUrl())

    @Step
    private fun openUrl(url: String) {
        log.info("open page: " + pageUrl())
        driver.get(url)
    }

}