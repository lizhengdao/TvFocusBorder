package com.owen.focus;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author ZhouSuQiang
 * @date 2017/11/6
 */
public interface FocusBorder {

    void setVisible(boolean visible);

    boolean isVisible();

    void onFocus(@NonNull View focusView, @Nullable Options options);
    
    void boundGlobalFocusListener(@NonNull OnFocusCallback callback);
    
    void unBoundGlobalFocusListener();

    interface OnFocusCallback {
        @Nullable Options onFocus(View oldFocus, View newFocus);
    }
    
    abstract class Options {}
    
    class Builder {
        public final ColorFocusBorder.Builder asColor() {
            return new ColorFocusBorder.Builder();
        }
        
        public final DrawableFocusBorder.Builder asDrawable() {
            return new DrawableFocusBorder.Builder();
        }
    }
    
    class OptionsFactory {
        public static Options get() {
            return AbsFocusBorder.Options.get(1f, 1f);
        }

        public static Options get(float scaleX, float scaleY) {
            return AbsFocusBorder.Options.get(scaleX, scaleY);
        }
        
        public static Options get(float scaleX, float scaleY, float roundRadius) {
            return ColorFocusBorder.Options.get(scaleX, scaleY, roundRadius);
        }
    }
}
