# DFont Library
[![Contributor Covenant](https://img.shields.io/badge/Contributor%20Covenant-1.0-4baaaa.svg)](CODE_OF_CONDUCT.md)
[![Contributing](https://img.shields.io/badge/contributing-docs-blue)](CONTRIBUTING.md)
[![License](https://img.shields.io/badge/license-MIT-red)](LICENSE)
![example workflow](https://github.com/mahmoud-abdallah863/DFont/actions/workflows/test-app-workflow.yml/badge.svg)
![example workflow](https://github.com/mahmoud-abdallah863/DFont/actions/workflows/build-app-workflow.yml/badge.svg)

Welcome fellow Android geeks. We built this library to make it easy for you to change text font
in your app.

## Description
Imagine this use case with me. Your app needs to change text font, not just for a single TextView.
You need to change it in all your app. With this library, you can easily change it for texts
in TextView, Button, etc..., in the whole app. Not only that, if you have a custom view with
text inside it, you can define your custom function to change the text inside your custom view.

This library uses the kotlin **extension function** and **SharedPreferences**. SharedPreferences is used to store
the font. Extension function on View and ViewGroup classes will allow notifying the view/viewGroups
that font has changed.

## Table of contents
- [How to use this library](#how_to_use_this_library)
    - [Initialize DFontSharedPreferences](#init_dfontSharedPrefs)
    - [Saving typeface](#saving_typeface)
    - [Change View text font](#change_view_text_font)
    - [Change text font in ViewGroup](#change_text_font_in_viewgroup)
    - [Change text font in Custom Views](#change_text_font_in_custom_views)
    - [Change text font in all activities/fragments](#change_text_font_on_all_activities)
    - [How we know if we can change view text font](#how_we_know_if_we_can_change_view_text_font)
- [Contribution](#contribution)
- [License](#license)


## <a name="how_to_use_this_library">How to use this library</a>
### <a name="init_dfontSharedPrefs">Initialize DFontSharedPreferences</a>
 Before doing anything, `DFontSharedPreferences` need to be initialized, otherwise if you try to
 use any function inside `DFontSharedPreferences` object `UninitializedPropertyAccessException`
 will be thrown.
 ``` kotlin
 DFontSharedPreferences.init( /** context */ )
 ```
 After calling this function, a shared preferences variable will be created from the provided
 context.
 
 DFontSharedPreferences is an object, so you can initialize it anywhere and more than once, it will not affect anything.
 
 
 ### <a name="saving_typeface">Saving typeface</a>
 For now, the library only supports pre-downloaded fonts, and saved a reference for them in `DFontSharedPreferences` as
 ints. By default `DFontSharedPreferences` won't have any typeface saved. To save your font call `saveFont(...)`
 function as below
 ``` kotlin
 DFontSharedPreferences.saveFont(R.font.lato)
 ```
 
 
 ### <a name="change_view_text_font">Change View text font</a>
 ``` kotlin
 // using viewBinding
 binding.textView.notifyTypefaceChanged()
 
 // Old school
 findViewById<TextView>(R.id.title).notifyTypefaceChanged()
 ``` 
 `notifyTypefaceChanged()` is an extension function on View class. In it we check if we know
 how to change the view text font, also check if a font is saved in`DFontSharedPreferences`.
 If all the above conditions are true, the typeface on this view will be changed.

See also: [How we know if we can change view text font](#how_we_know_if_we_can_change_view_text_font)
 
 
 ### <a name="change_text_font_in_viewgroup">Change text font in ViewGroup</a>
 ``` kotlin
 // using viewBinding
 binding.root.notifyTypefaceChanged()
 
 // Old school
 findViewById<ConstraintLayout>(R.id.root).notifyTypefaceChanged()
 ```
 It's very similar to how we do it for views. You call `notifyTypefaceChanged()`, which is an extension function on
 **ViewGroup** class. This function will loop over all viewGroup children. On each view child
 `view.notifyTypefaceChanged()` will be called.
 
 
 ### <a name="change_text_font_in_custom_views">Change text font in Custom Views</a>
 It's very similar to the above. There is 1 extra step for views. Read
 [this](#how_we_know_if_we_can_change_view_text_font) to understand what's happening behind
 the scene.
 ``` kotlin
 ChangeableTypefaceViews.customViewsMap[/** full class name */] = { view ->
 // function that will be executed when font changes
 }
 ```
 You need to define this before notifying typeface changed. Cast `view` to your custom class to 
 be able to use its functions and variables. CustomViewsMap is a map, so defining this multiple times won't affect 
 anything. But preferably, define it once to avoid redundant code and/or weird behaviour.
 
 
 ### <a name="change_text_font_on_all_activities">Change text font in all activities/fragments</a>
 For now, you need to call `root.notifyTypefaceChanged()` in `onResume()` function. Where `root` is your root view.
 This could be updated in the feature, to make it simpler to change text font.

### <a name="how_we_know_if_we_can_change_view_text_font">How we know if we can change view text font</a>
There are 2 types of views. Android build-in views and your custom views.
For android views, we already know if the view has a text.
But for your custom views, we can't know. That's why you need to tell us that a custom view `X` has
a text and how to change it's font. 

When you call `notifyTypefaceChanged()` function on a view/viewGroup, the first thing we do is check if that
view has a text. Using this function:
```kotlin
fun hasTypeface(view: View): Boolean {
    return androidViews.contains(view.javaClass.name) ||
            customViewsMap.containsKey(view.javaClass.name)
}
```
A view has a text if it is in `androidViews` or `customViewsMap`.

```kotlin
private var androidViews: Set<String>
// Pre-populated set with hardcoded built-in class names that have text.
```

```kotlin
var customViewsMap: MutableMap<String, (view: View) -> Unit> = mutableMapOf()
/**
 * First, `customViewsMap` is public, and it's a mutable map, which means you can modify it.
 * Key is the class name, and the value is a function.
 * Read [how to support your custom view](#custom_view_support)
 */
```

## <a name="contribution">Contribution</a>
You are more than welcome to contribute. 
Check [this](https://github.com/mahmoud-abdallah863/DFont/blob/main/CONTRIBUTING.md) for more info,
and tasks you can work on. If you like :)

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
