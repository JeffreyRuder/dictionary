import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Dictionary");
  }

  @Test
  public void addAWordPage() {
      goTo("http://localhost:4567/");
      click("a", withText("Add a Word"));
      assertThat(pageSource()).contains("Now's your chance");
  }

  @Test
  public void addsWordsSuccessfully() {
      goTo("http://localhost:4567/new");
      fill("#word").with("expeditious");
      submit(".btn");
      assertThat(pageSource()).contains("expeditious");
  }

  @Test
  public void individualWordPage() {
      goTo("http://localhost:4567/new");
      fill("#word").with("expeditious");
      submit(".btn");
      click("a", withText("expeditious"));
      assertThat(pageSource).contains("Add Definition");
  }

  @Test
  public void addsDefinitionsSuccessfully() {
      goTo("http://localhost:4567/new");
      fill("#word").with("baton");
      submit(".btn");
      click("a", withText("baton"));
      fill("#definition").with("a kind of stick");
      fill("#example").with("the marshal had a baton");
      submit(".btn");
      assertThat(pageSource).contains("the marshal had a baton");
  }
}
