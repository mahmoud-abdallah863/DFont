# DFont Library
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-1.0-4baaaa.svg)](CODE_OF_CONDUCT.md)
[![Contributing](https://img.shields.io/badge/contributing-docs-blue)](CONTRIBUTING.md)
[![License](https://img.shields.io/badge/license-MIT-red)](LICENSE)
![example workflow](https://github.com/mahmoud-abdallah863/DFont/actions/workflows/test-app-workflow.yml/badge.svg)
![example workflow](https://github.com/mahmoud-abdallah863/DFont/actions/workflows/build-app-workflow.yml/badge.svg)

Welcome fellow Android geeks. This library is built to make it easy to change text font in your app.

## Description
Imagine this use case with me. Your app needs to change text font, not just for a single TextView, you need to change
it in all your app. With this library, you can easily change it for TextView, texts inside Button, etc..., in the whole
app. Not only that, if you have a custom view with text inside it, you can define your custom function to change the 
text inside your custom view.

This library uses the kotlin **extension function** and **SharedPreferences**. SharedPreferences is used to store
the font you chose, and extension function on View and ViewGroup classes will allow notifying the view/viewGroups
that font has changed.

## Table of contents
- [How to use this library](#how_to_use_this_library)
    - [Initialize DFontSharedPreferences](#init_dfontSharedPrefs)
    - [Saving typeface](#saving_typeface)
    - [Change View text font](#change_view_text_font)
    - [Change text font in ViewGroup](#change_text_font_in_viewgroup)
    - [Change text font in Custom Views](#change_text_font_in_custom_views)
    - [Change text font in all activities/fragments](#change_text_font_on_all_activities)
    - [Support text font change in custom view](#custom_view_support)
- [Contribution](#contribution)
- [License](#license)


## <a name="how_to_use_this_library">How to use this library</a>
### <a name="init_dfontSharedPrefs">Initialize DFontSharedPreferences</a>
 Before doing anything, `DFontSharedPreferences` need to be initialized, otherwise if you try to use any function
 inside `DFontSharedPreferences` object `UninitializedPropertyAccessException` will be thrown.
 ``` kotlin
 DFontSharedPreferences.init( /** context */ )
 ```
 After calling this function, a shared preferences variable will be created from the provided context,
 `dfont_sharedpreferences_name` as a name and mode = `Context.MODE_PRIVATE`.
 
 DFontSharedPreferences is an object, so you can initialize it anywhere and more than once, it will not affect anything.
 
 
 ### <a name="saving_typeface">Saving typeface</a>
 For now, the library supports pre-downloaded fonts, and saved a reference for them in `DFontSharedPreferences` as
 ints. By default `DFontSharedPreferences` won't have ny typeface saved. To save your font call `saveFont(...)`
 function as below
 ``` kotlin
 DFontSharedPreferences.saveFont(R.font.lato)
 ```
 This will save `R.font.lato` as an int value.
 
 
 ### <a name="change_view_text_font">Change View text font</a>
 ``` kotlin
 // using viewBinding
 binding.textView.notifyTypefaceChanged()
 
 // Old school
 findViewById<TextView>(R.id.title).notifyTypefaceChanged()
 ``` 
 `notifyTypefaceChanged` is an extension function on View class. This will check if we know how to change the view
 text font, also check if a font is saved in `DFontSharedPreferences`. If all the above conditions are true, the typeface on
 this view will be changed.
 
 
 ### <a name="change_text_font_in_viewgroup">Change text font in ViewGroup</a>
 ``` kotlin
 // using viewBinding
 binding.root.notifyTypefaceChanged()
 
 // Old school
 findViewById<ConstraintLayout>(R.id.root).notifyTypefaceChanged()
 ```
 It's very similar to how we do it for views. You call `notifyTypefaceChanged`, which is an extension function on
 **ViewGroup** class. This function will loop over all this viewGroup child, and if one of its children is a 
 viewGroup itself, it will also loop over its children. On each view child `view.notifyTypefaceChanged()` will 
 be called.
 
 
 ### <a name="change_text_font_in_custom_views">Change text font in Custom Views</a>
 It's very similar to the above. There is 1 extra step for views. Read [this](#custom_view_support) to
 understand what's happening behind the scene.
 ``` kotlin
 ChangeableTypefaceViews.customViewsMap[/** full class name */] = { view ->
 // function that will be executed when font changes
 }
 ```
 You need to define this before notifying typeface changed. Cast `view` to your custom class to 
 be able to use its functions and variables. CustomViewsMap is a map, so defining this multiple times won't affect 
 anything. But preferably, define it once to avoid redundant code and feature bugs.
 
 
 ### <a name="change_text_font_on_all_activities">Change text font in all activities/fragments</a>
 For now, you need to call `root.notifyTypefaceChanged()` in `onResume()` function. Where `root` is your root view.
 This could be updated in the feature, to make it simpler to change text font.
 
 ### <a name="custom_view_support">Support text font change in custom view</a>
There are 2 types of views. Android build-in views and your custom views. For android views, we already know how to
change their font, but for your custom views, you need to provide your custom function for changing text font.

In `ChangeableTypefaceViews` we have `androidViews` set which stores class names for all build in android views
with a text, and `customViewsMap` map which is for your custom views. `customViewsMap` is as follows:
```kotlin
var customViewsMap: MutableMap<String, (view: View) -> Unit>
// key: your class full name (ex: android.widget.TextView)
// value: function will be called when we need to change this view text font
```
When you call View/ViewGroup `notifyTypefaceChanged()` function. First, we check if we know how to change
that view text font. So, we check if the view class name exists in `androidViews` set or `customViewsMap`
map, we will change its text font, else nothing will happen.


## <a name="contribution">Contribution</a>
You are more than welcome to contribute. It is still under development.
Check [this](https://github.com/mahmoud-abdallah863/DFont/blob/main/CONTRIBUTING.md) for more info.

## <a name="license">License</a>
MIT License

Copyright (c) 2021 Mahmoud Abdallah

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
