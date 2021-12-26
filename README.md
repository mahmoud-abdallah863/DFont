# DFont Library

Welcome fellow Android geeks. This library is built to make it easy to change text font in your app.

## Description
Imagine this use case with me. Your app needs to change text font, not just for a single TextView, you need to change it in all your app. With this library, you can easily change it for TextView, texts inside Button, etc..., in the whole app. Not only that, if you have a custom view with text inside it, you can define your custom function to change the text inside your custom view.

This library uses the kotlin **extension function** and **SharedPreferences**. SharedPreferences is used to store the font you chose, and extension function on View and ViewGroup classes will allow notifying the view/viewGroups that font has changed.

## How to use this library
### Initialize DFontSharedPreferences
 Before doing anything, `DFontSharedPreferences` need to be initialized, otherwise if you try to use any function inside `DFontSharedPreferences` object `UninitializedPropertyAccessException` will be thrown.
 ``` kotlin
 DFontSharedPreferences.init( /** context */ )
 ```
 After calling this function, a shared preferences variable will be created from the provided context, `dfont_sharedpreferences_name` as a name and mode = `Context.MODE_PRIVATE`.
 
 DFontSharedPreferences is an object, so you can initialize it anywhere and more than one, it will not effect anything.
 
 <br/>
 
 ### Saving typeface
 For now, the library supports pre-downloaded fonts, and saved a reference for them in `DFontSharedPreferences` as ints.
 By default `DFontSharedPreferences` won't have ny typeface saved. To save your font call `saveFont(...)` function as below
 ``` kotlin
 DFontSharedPreferences.saveFont(R.font.lato)
 ```
 This will save `R.font.lato` as an int value.
 
 <br/>
 
 ### Changing View text font
 ``` kotlin
 // using viewBinding
 binding.textView.notifyTypefaceChanged()
 
 // Old school
 findViewById<TextView>(R.id.title).notifyTypefaceChanged()
 ``` 
 `notifyTypefaceChanged` is an extension function on View class. This will check if we know how to change the view text font font, also check if a font is saved in `DFontSharedPreferences`. If all above conditions are true, typeface on this view will be changed.
 
 <br/>
 
 ### Changing text font in ViewGroup
 ``` kotlin
 // using viewBinding
 binding.root.notifyTypefaceChanged()
 
 // Old school
 findViewById<ConstraintLayout>(R.id.root).notifyTypefaceChanged()
 ```
 It's very similar to how we do it for views. You call `notifyTypefaceChanged`, which is an extension function on **ViewGroup** class. This function will loop over all this viewGroup child, and if one of it's chils is a viewGroup itself, it will also loop over it's childs. On each view child `view.notifyTypefaceChanged()` will be called.
 
 <br/>
 
 ### Changin text font on your Custom Views/ViewGroup
 It's very similar to the above. There is 1 extra step for views. Read this to understand what's really happening
 ``` kotlin
 // example of custom view full class name: com.example.yourApp.views.CustomView
 ChangeableTypefaceViews.customViewsMap[/** full class name */] = { 
 // function that will be executed when font changes
 }
 ```
 You need to define this before notiying typeface changed. It's a map, so defining this multiple times won't affect anything. But preferrably, define it once to avoid redundent code and feature bugs.
 
 <br/>
 
 ### Support custom view font change
 // explain here the idea of changing custom views text font.
