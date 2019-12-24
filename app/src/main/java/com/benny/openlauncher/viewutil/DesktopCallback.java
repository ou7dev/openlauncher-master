package com.benny.openlauncher.viewutil;

import android.view.View;

import com.benny.openlauncher.model.Item;
import com.benny.openlauncher.interfaces.RevertibleAction;

public interface DesktopCallback<V extends View> extends RevertibleAction {
    boolean addItemToPoint(Item item, int x, int y);

    boolean addItemToPage(Item item, int page);

    boolean addItemToCell(Item item, int x, int y);

    void removeItem(V view, boolean animate);
}
