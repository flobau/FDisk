package at.fdisk.core.webapp;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

/**
 *
 */
public class HelloWorldPage extends WebPage {
    public HelloWorldPage() {
        add(new Label("helloMessage", "Hello WicketWorld!"));
    }
}