package com.tuto.gwt.polymer.widgetui.client.composite;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.polymer.paper.widget.PaperDialog;
import com.vaadin.polymer.paper.widget.PaperDrawerPanel;
import com.vaadin.polymer.paper.widget.PaperInput;
import com.vaadin.polymer.paper.widget.PaperTextarea;

public class Main extends Composite {

    private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);

    interface MainUiBinder extends UiBinder<Widget, Main> {
    }

    @UiField
    PaperDrawerPanel drawerPanel;
    @UiField
    HTMLPanel content;

    @UiField
    PaperDialog addItemDialog;
    @UiField
    PaperInput titleInput;
    @UiField
    PaperTextarea descriptionInput;

    public Main() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("addButton")
    protected void onAddButtonClick(ClickEvent e) {
	addItemDialog.open();
    }

    @UiHandler("confirmAddButton")
    protected void onConfirmAddButtonClick(ClickEvent e) {
	if (!titleInput.getValue().isEmpty()) {
	    addItem(titleInput.getValue(), descriptionInput.getValue());
	    // clear text fields
	    titleInput.setValue("");
	    descriptionInput.setValue("");
	}
    }

    private void addItem(String title, String description) {
	Item item = new Item();
	item.setTitle(title);
	item.setDescription(description);
	content.add(item);
    }
}
