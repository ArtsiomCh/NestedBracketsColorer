import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase

class CodeInsightTest : LightCodeInsightFixtureTestCase() {

    override fun getTestDataPath(): String {
        return "testData"
    }

    fun testBracketsHighlighting() {
        myFixture.configureByFiles("AnnotatorTestData.java")
        myFixture.checkHighlighting(false, true, false, false)
    }
}
