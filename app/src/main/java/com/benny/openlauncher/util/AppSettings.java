package com.benny.openlauncher.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;

import com.benny.openlauncher.AppObject;
import com.benny.openlauncher.R;
import com.benny.openlauncher.manager.Setup;
import com.benny.openlauncher.widget.AppDrawerController;
import com.benny.openlauncher.widget.PagerIndicator;

import net.gsantner.opoc.preference.SharedPreferencesPropertyBackend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AppSettings extends SharedPreferencesPropertyBackend {
    public AppSettings(Context context) {
        super(context, "app");
    }

    public static AppSettings get() {
        return new AppSettings(AppObject.get());
    }

    public int getDesktopColumnCount() {
        return getInt(R.string.pref_key__desktop_columns, 5);
    }

    public int getDesktopRowCount() {
        return getInt(R.string.pref_key__desktop_rows, 6);
    }

    public int getDesktopIndicatorMode() {
        return getIntOfStringPref(R.string.pref_key__desktop_indicator_style, PagerIndicator.Mode.DOTS);
    }

    public boolean isDesktopRotate() {
        return getBool(R.string.pref_key__desktop_rotate, false);
    }

    public boolean isDesktopShowGrid() {
        return getBool(R.string.pref_key__desktop_show_grid, true);
    }

    public boolean isDesktopFullscreen() {
        return getBool(R.string.pref_key__desktop_fullscreen, false);
    }

    public boolean isDesktopShowIndicator() {
        return getBool(R.string.pref_key__desktop_show_position_indicator, true);
    }

    public boolean isDesktopShowLabel() {
        return getBool(R.string.pref_key__desktop_show_label, true);
    }

    public boolean getSearchBarEnable() {
        return getBool(R.string.pref_key__search_bar_enable, true);
    }

    public String getSearchBarBaseURI() {
        return getString(R.string.pref_key__search_bar_base_uri, R.string.pref_default__search_bar_base_uri);
    }

    public boolean getSearchBarForceBrowser() {
        return getBool(R.string.pref_key__search_bar_force_browser, false);
    }

    public boolean getSearchBarShouldShowHiddenApps() {
        return getBool(R.string.pref_key__search_bar_show_hidden_apps, false);
    }

    public boolean isSearchBarTimeEnabled() {
        return true;
    }

    @SuppressLint("SimpleDateFormat")
    public SimpleDateFormat getUserDateFormat() {
        String line1 = getString(R.string.pref_key__date_bar_date_format_custom_1, rstr(R.string.pref_default__date_bar_date_format_custom_1));
        String line2 = getString(R.string.pref_key__date_bar_date_format_custom_2, rstr(R.string.pref_default__date_bar_date_format_custom_2));

        try {
            return new SimpleDateFormat((line1 + "'\n'" + line2).replace("''", ""), Locale.getDefault());
        } catch (Exception ex) {
            return new SimpleDateFormat("'Invalid pattern''\n''Invalid Pattern'");
        }
    }

    public int getDesktopDateMode() {
        return getIntOfStringPref(R.string.pref_key__date_bar_date_format_type, 1);
    }

    public int getDesktopDateTextColor() {
        return getInt(R.string.pref_key__date_bar_date_text_color, Color.WHITE);
    }

    public int getDesktopBackgroundColor() {
        return getInt(R.string.pref_key__desktop_background_color, Color.TRANSPARENT);
    }

    public int getDesktopFolderColor() {
        return getInt(R.string.pref_key__desktop_folder_color, Color.WHITE);
    }

    public int getFolderLabelColor() {
        return getInt(R.string.pref_key__desktop_folder_label_color, Color.BLACK);
    }

    public int getDesktopInsetColor() {
        return getInt(R.string.pref_key__desktop_inset_color, ContextCompat.getColor(_context, R.color.transparent));
    }

    public int getMinibarBackgroundColor() {
        return getInt(R.string.pref_key__minibar_background_color, ContextCompat.getColor(_context, R.color.colorPrimary));
    }

    public int getDesktopIconSize() {
        return getIconSize();
    }

    public boolean getDockEnable() {
        return getBool(R.string.pref_key__dock_enable, true);
    }

    public int getDockColumnCount() {
        return getInt(R.string.pref_key__dock_columns, 5);
    }

    public int getDockRowCount() {
        return getInt(R.string.pref_key__dock_rows, 1);
    }

    public boolean isDockShowLabel() {
        return getBool(R.string.pref_key__dock_show_label, false);
    }

    public int getDockColor() {
        return getInt(R.string.pref_key__dock_background_color, Color.TRANSPARENT);
    }

    public int getDockIconSize() {
        return getIconSize();
    }

    public int getDrawerColumnCount() {
        return getInt(R.string.pref_key__drawer_columns, 5);
    }

    public int getDrawerRowCount() {
        return getInt(R.string.pref_key__drawer_rows, 6);
    }

    public int getDrawerStyle() {
        return getIntOfStringPref(R.string.pref_key__drawer_style, AppDrawerController.Mode.GRID);
    }

    public boolean isDrawerShowCardView() {
        return getBool(R.string.pref_key__drawer_show_card_view, true);
    }

    public boolean isDrawerRememberPosition() {
        return getBool(R.string.pref_key__drawer_remember_position, true);
    }

    public boolean isDrawerShowIndicator() {
        return getBool(R.string.pref_key__drawer_show_position_indicator, true);
    }

    public boolean isDrawerShowLabel() {
        return getBool(R.string.pref_key__drawer_show_label, true);
    }

    public int getDrawerBackgroundColor() {
        return getInt(R.string.pref_key__drawer_background_color, rcolor(R.color.darkTransparent));
    }

    public int getDrawerCardColor() {
        return getInt(R.string.pref_key__drawer_card_color, Color.WHITE);
    }

    public int getDrawerLabelColor() {
        return getInt(R.string.pref_key__drawer_label_color, Color.WHITE);
    }

    public int getDrawerFastScrollColor() {
        return getInt(R.string.pref_key__drawer_fast_scroll_color, ContextCompat.getColor(Setup.appContext(), R.color.materialRed));
    }

    public int getDrawerIconSize() {
        return getIconSize();
    }

    public boolean isGestureFeedback() {
        return getBool(R.string.pref_key__gesture_feedback, false);
    }

    public boolean getGestureDockSwipeUp() {
        return getBool(R.string.pref_key__gesture_quick_swipe, true);
    }

    public Object getGestureDoubleTap() {
        return getGesture(R.string.pref_key__gesture_double_tap);
    }

    public Object getGestureSwipeUp() {
        return getGesture(R.string.pref_key__gesture_swipe_up);
    }

    public Object getGestureSwipeDown() {
        return getGesture(R.string.pref_key__gesture_swipe_down);
    }

    public Object getGesturePinch() {
        return getGesture(R.string.pref_key__gesture_pinch);
    }

    public Object getGestureUnpinch() {
        return getGesture(R.string.pref_key__gesture_unpinch);
    }

    public Object getGesture(int key) {
        // return either ActionItem or Intent
        String result = getString(key, "");
        Object gesture = LauncherAction.getActionItem(result);
        // no action was found so it must be an intent string
        if (gesture == null) {
            gesture = Tool.getIntentFromString(result);
            if (AppManager.getInstance(_context).findApp((Intent) gesture) == null) gesture = null;
        }
        // reset the setting if invalid value
        if (gesture == null) {
            setString(key, null);
        }
        return gesture;
    }

    public String getTheme() {
        return getString(R.string.pref_key__theme, "0");
    }

    public int getPrimaryColor() {
        return getInt(R.string.pref_key__primary_color, _context.getResources().getColor(R.color.colorPrimary));
    }

    public int getIconSize() {
        return getInt(R.string.pref_key__icon_size, 48);
    }

    public String getIconPack() {
        return getString(R.string.pref_key__icon_pack, "");
    }

    public void setIconPack(String value) {
        setString(R.string.pref_key__icon_pack, value);
    }

    public float getOverallAnimationSpeedModifier() {
        return (float) (getInt(R.string.pref_key__overall_animation_speed_modifier, 30) / 100.0);
    }

    public String getLanguage() {
        return getString(R.string.pref_key__language, "");
    }

    // internal preferences below here
    public boolean getMinibarEnable() {
        return getBool(R.string.pref_key__minibar_enable, true);
    }

    public void setMinibarEnable(boolean value) {
        setBool(R.string.pref_key__minibar_enable, value);
    }

    public ArrayList<LauncherAction.ActionDisplayItem> getMinibarArrangement() {
        ArrayList<String> minibarString = getStringList(R.string.pref_key__minibar_items);
        ArrayList<LauncherAction.ActionDisplayItem> minibarObject = new ArrayList<>();
        for (String action : minibarString) {
            LauncherAction.ActionDisplayItem item = LauncherAction.getActionItem(action);
            if (item != null) {
                minibarObject.add(item);
            }
        }
        if (minibarObject.isEmpty()) {
            for (LauncherAction.ActionDisplayItem item : LauncherAction.actionDisplayItems) {
                if (LauncherAction.defaultArrangement.contains(item._action)) {
                    minibarObject.add(item);
                }
            }
            setMinibarArrangement(minibarString);
        }
        return minibarObject;
    }

    public void setMinibarArrangement(ArrayList<String> value) {
        setStringList(R.string.pref_key__minibar_items, value);
    }

    public boolean isResetSearchBarOnOpen() {
        return false;
    }

    public boolean isSearchUseGrid() {
        return getBool(R.string.pref_key__desktop_search_use_grid, false);
    }

    public void setSearchUseGrid(boolean enabled) {
        setBool(R.string.pref_key__desktop_search_use_grid, enabled);
    }

    public ArrayList<String> getHiddenAppsList() {
        return getStringList(R.string.pref_key__hidden_apps);
    }

    public void setHiddenAppsList(ArrayList<String> value) {
        setStringList(R.string.pref_key__hidden_apps, value);
    }

    public int getDesktopPageCurrent() {
        return getInt(R.string.pref_key__desktop_current_position, 0);
    }

    public void setDesktopPageCurrent(int value) {
        setInt(R.string.pref_key__desktop_current_position, value);
    }

    public boolean isDesktopLock() {
        return getBool(R.string.pref_key__desktop_lock, false);
    }

    public void setDesktopLock(boolean value) {
        setBool(R.string.pref_key__desktop_lock, value);
    }

    public boolean getAppRestartRequired() {
        return getBool(R.string.pref_key__queue_restart, false);
    }

    @SuppressLint("ApplySharedPref")
    public void setAppRestartRequired(boolean value) {
        // MUST be committed
        _prefApp.edit().putBoolean(_context.getString
                (R.string.pref_key__queue_restart), value).commit();
    }

    @SuppressLint("ApplySharedPref")
    public void setAppShowIntro(boolean value) {
        // MUST be committed
        _prefApp.edit().putBoolean(_context.getString(R.string.pref_key__show_intro), value).commit();
    }

    public boolean isAppFirstLaunch() {
        return getBool(R.string.pref_key__first_start, true);
    }

    @SuppressLint("ApplySharedPref")
    public void setAppFirstLaunch(boolean value) {
        // MUST be committed
        _prefApp.edit().putBoolean(_context.getString(R.string.pref_key__first_start), value).commit();
    }

    public boolean enableImageCaching() {
        return true;
    }
}
