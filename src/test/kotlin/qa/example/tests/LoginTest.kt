package qa.example.tests

import LocalTestBase
import io.qameta.allure.Allure.step
import io.qameta.allure.Step
import io.qameta.allure.model.Status
import kotlin.test.Test
import kotlin.test.assertEquals
import qa.example.pages.login.GoogleFind


class AllureSimpleTest(): LocalTestBase() {

    //private lateinit var driver: WebDriver

    @Test
    fun allureSimpleTest() {
        step("Simple step")
        val google = GoogleFind(driver)
        google.pesquisaGoogle()
        step("Simple step with status", Status.FAILED)
        simpleTestMethod("method parameter")
    }

    @Step("Simple test method with step annotation")
    fun simpleTestMethod(param: String) {
        step("Method parameter: $param")
        step("Simple step inside test method")
    }

}