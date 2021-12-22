package com.mahmoud.dfont.services

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.mahmoud.dfont.utils.DFontKeys.DFONT_TAG


object ChangeableTypefaceViews {

    /**
     * List of build-in android views that has text.
     *
     * Thus, we already know how to change their typeface.
     */
    private var androidViews: Set<String> = setOf(
        "android.widget.TextView",
        "android.widget.Button",
        "com.google.android.material.textview.MaterialTextView",
        "com.google.android.material.button.MaterialButton"
    )


    /**
     * Map to store views that are not in [androidViews] and your custom view
     *
     * Map<K, V>:
     * - K : Class full name
     * - V : function that will be executed when [changeTypeface] is called
     */
    var customViewsMap: MutableMap<String, () -> Unit> = mutableMapOf()


    /**
     * This function returns true if the view class name is in [androidViews] or
     * [customViewsMap]
     *
     * False will be returned in 2 cases:
     *  - The view is a custom view that has not been added to [customViewsMap]
     *  - Build in view that does not have a text. ex: [LinearLayout]
     */
    fun hasTypeface(view: View): Boolean {
        return androidViews.contains(view.javaClass.name) ||
                customViewsMap.containsKey(view.javaClass.name)
    }


    /**
     * Ideally this function will be called when notifyTypefaceChanged() has
     * been called.
     *
     * Consider using View or ViewGroup notifyTypefaceChanged() extension function and not to call this method
     * directly.
     *
     * @param[view] the view that you want to change it's text typeface
     * @param[context] context view exists it
     * @param[typeface] typeface that you wan to change view text to
     *
     *
     * @see [com.mahmoud.dfont.extensions.notifyTypefaceChanged]
     */
    fun changeTypeface(view: View, context: Context, typeface: Int) {
        val viewClassName = view.javaClass.name

        if (!hasTypeface(view)) {
            Log.d(DFONT_TAG, "changeTypeface: $viewClassName does not have a typeface. " +
                    "Either it is a custom view that you did not add to customViewsMap, " +
                    "or it is a build-in view that does not have a text. " +
                    "Make sure not to call this function directly. Consider using View or ViewGroup " +
                    "notifyTypefaceChanged() function")
            return
        }

        when {
            androidViews.contains(viewClassName) -> {
                when (view){
                    is TextView -> view.typeface = ResourcesCompat.getFont(context, typeface)
                }
            }

            customViewsMap.containsKey(viewClassName) -> {
                val customFunction = customViewsMap[viewClassName]!!
                customFunction()
                Log.d(DFONT_TAG, "changeTypeface: $viewClassName -> called custom function")
            }
        }
    }

}