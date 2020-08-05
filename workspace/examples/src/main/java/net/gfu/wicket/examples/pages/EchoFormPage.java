package net.gfu.wicket.examples.pages;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

public class EchoFormPage extends WebPage {
    private static final long serialVersionUID = 1L;

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        response.render(CssHeaderItem.forReference(new CssResourceReference(EchoFormPage.class, "../assets/bootstrap.min.css")));
        response.render(CssHeaderItem.forReference(new CssResourceReference(EchoFormPage.class, "../assets/bootstrap-theme.min.css")));
        response.render(CssHeaderItem.forReference(new CssResourceReference(EchoFormPage.class, "../assets/style.css")));
        response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(EchoFormPage.class, "../assets/jquery-3.3.1.slim.min.js")));
        response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(EchoFormPage.class, "../assets/bootstrap.min.js")));
        response.render(JavaScriptHeaderItem.forReference(new JavaScriptResourceReference(EchoFormPage.class, "../assets/popper.min.js")));
    }

    private Form<String> form;
    private Label message;

    public EchoFormPage(){
        Model<String> inputModel = new Model<>();
        TextField<String> textField = new TextField<>("echo-input", inputModel);

        form = new Form<>("form");
        form.add(textField);

        message = new Label("echo-message", inputModel);

        add(form);
        add(message);
    }
}
