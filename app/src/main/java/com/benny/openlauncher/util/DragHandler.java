package com.benny.openlauncher.util;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.view.DragEvent;
import android.view.View;

import com.benny.openlauncher.activity.HomeActivity;
import com.benny.openlauncher.model.Item;
import com.benny.openlauncher.widget.AppItemView;

public final class DragHandler {
    private static final String DRAG_DROP_EXTRA = "DRAG_DROP_EXTRA";
    private static final String DRAG_DROP_INTENT = "DRAG_DROP_INTENT";
    public static final DragHandler INSTANCE = new DragHandler();
    public static Bitmap _cachedDragBitmap;

    public static <T extends Parcelable> void startDrag(View view, Item item, DragAction.Action action, @Nullable final AppItemView.LongPressCallBack eventAction) {
        _cachedDragBitmap = loadBitmapFromView(view);

        if (HomeActivity.Companion.getLauncher() != null)
            HomeActivity.Companion.getLauncher().getItemOptionView().startDragNDropOverlay(view, item, action);

        if (eventAction != null)
            eventAction.afterDrag(view);
    }

    private static Bitmap loadBitmapFromView(View view) {
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        String tempLabel = null;
        if (view instanceof AppItemView) {
            tempLabel = ((AppItemView) view).getLabel();
            ((AppItemView) view).setLabel(" ");
        }
        view.layout(0, 0, view.getWidth(), view.getHeight());
        view.draw(canvas);
        if (view instanceof AppItemView) {
            ((AppItemView) view).setLabel(tempLabel);
        }
        view.getParent().requestLayout();
        return bitmap;
    }

    public <T extends Parcelable> T getDraggedObject(DragEvent dragEvent) {

        ClipData.Item cdi = dragEvent.getClipData().getItemAt(0);
        if (cdi != null) {
            Intent intent = cdi.getIntent();
            intent.setExtrasClassLoader(Item.class.getClassLoader());
            return intent.getParcelableExtra(DRAG_DROP_EXTRA);
        }
        return null;
    }
}