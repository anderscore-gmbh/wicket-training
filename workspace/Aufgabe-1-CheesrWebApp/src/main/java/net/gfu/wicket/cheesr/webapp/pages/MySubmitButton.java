package net.gfu.wicket.cheesr.webapp.pages;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.Model;

public class MySubmitButton extends Button {

    Model model;

    public MySubmitButton(String id, Model model) {
        super(id);

        this.model = model;
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        model.setObject("onInitialize \n" + model.getObject() + "\n");
    }

    @Override
    protected void onConfigure() {
        super.onConfigure();
        model.setObject("onConfigure \n" + model.getObject() + "\n");
    }

    @Override
    protected void onRemove() {
        super.onRemove();
        model.setObject("onRemove \n" + model.getObject() + "\n");
    }

    @Override
    protected void onRender() {
        super.onRender();
        model.setObject("onRender \n" + model.getObject() + "\n");
    }
}
