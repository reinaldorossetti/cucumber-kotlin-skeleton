package qa.example.extensions

import org.openqa.selenium.WebDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface WithLog {
    abstract val driver: WebDriver?
    val log: Logger

    fun logger(): Logger {
        return LoggerFactory.getLogger(this.javaClass.name)
    }
}