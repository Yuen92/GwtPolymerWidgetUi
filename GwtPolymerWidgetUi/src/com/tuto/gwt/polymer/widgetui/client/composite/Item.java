package com.tuto.gwt.polymer.widgetui.client.composite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.iron.widget.event.IronChangeEvent;
import com.vaadin.polymer.paper.widget.PaperCheckbox;

public class Item extends Composite {

    private static ItemUiBinder uiBinder = GWT.create(ItemUiBinder.class);

    interface ItemUiBinder extends UiBinder<Widget, Item> {
    }

    @UiField
    Element title;
    @UiField
    Element description;
    @UiField
    PaperCheckbox done;

    public Item() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("done")
    protected void change(IronChangeEvent ev) {
	if (done.getActive()) {
	    title.addClassName("done");
	} else {
	    title.removeClassName("done");
	}
    }

    public String getTitle() {
	return title.getInnerText();
    }

    public void setTitle(String s) {
	title.setInnerText(s);
    }

    public String getDescription() {
	return description.getInnerText();
    }

    public void setDescription(String s) {
	description.setInnerText(s);
    }

    public boolean isDone() {
	return done.getActive();
    }

    public void setDone(boolean b) {
	done.setActive(b);
    }
}
