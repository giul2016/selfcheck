package selfcheck;

import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Blog {
  @Before
  public void setUp() {
    open("https://asolntsev.github.io/");
  }

  @Test
  public void canSwitchEnglishAndRussian() {
    $("#languages").find(byText("RUS")).click();
    $$(".sidebar-nav .sidebar-nav-item").shouldHave(texts("Blog", "Обо мне", "Опен-сорс", "Видео"));

    $("#languages").find(byText("ENG")).click();
    $$(".sidebar-nav .sidebar-nav-item").shouldHave(texts("Blog", "About", "Open source", "My videos"));
  }
}
