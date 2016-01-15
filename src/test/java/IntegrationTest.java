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
      click("a", withText("+ Add a Word"));
      assertThat(pageSource()).contains("add your own word");
  }

  @Test
  public void addsWordsSuccessfully() {
      goTo("http://localhost:4567/new");
      fill("#userword").with("expeditious");
      submit(".btn-warning");
      goTo("http://localhost:4567/expeditious");
      assertThat(pageSource()).contains("expeditious");
  }

  @Test
  public void individualWordPage() {
      goTo("http://localhost:4567/new");
      fill("#userword").with("expeditious");
      submit(".btn-warning");
      goTo("http://localhost:4567/expeditious");
      assertThat(pageSource()).contains("define this word");
  }

  @Test
  public void addsDefinitionsSuccessfully() {
      goTo("http://localhost:4567/new");
      fill("#userword").with("baton");
      submit(".btn-warning");
      goTo("http://localhost:4567/");
      click("a", withText("baton"));
      fill("#userdefinition").with("a kind of stick");
      fill("#userexample").with("the marshal had a baton");
      submit(".btn-warning");
      goTo("http://localhost:4567/baton");
      assertThat(pageSource()).contains("the marshal had a baton");
  }

  @Test
  public void addsMultipleDefinitions() {
      goTo("http://localhost:4567/new");
      fill("#userword").with("baton");
      submit(".btn-warning");
      click("a", withText("baton"));
      fill("#userdefinition").with("a kind of stick");
      fill("#userexample").with("the marshal had a baton");
      submit(".btn-warning");
      fill("#userdefinition").with("a thing you toss");
      fill("#userexample").with("she twirled the baton");
      assertThat(pageSource()).contains("she twirled the baton");
  }
}
