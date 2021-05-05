package qa.example.tests

import io.qameta.allure.Allure.step
import io.qameta.allure.Step
import io.qameta.allure.model.Status
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class AllureSimpleTest {

    @Test
    @DisplayName("allureSimpleTest displayName")
    fun allureSimpleTest() {
        step("Simple step")
        step("Simple step with status", Status.FAILED)
        simpleTestMethod("method parameter")
    }

    @Step("Simple test method with step annotation")
    fun simpleTestMethod(param: String) {
        step("Method parameter: $param")
        step("Simple step inside test method")
    }

}