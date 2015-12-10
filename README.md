### RecyclerView CursorAdapter  
---
This library is an adaptation of [RecyclerView.Adapter](http://developer.android.com/intl/pt-br/reference/android/support/v7/widget/RecyclerView.Adapter.html) that uses a [CursorAdapter](http://developer.android.com/intl/pt-br/reference/android/widget/CursorAdapter.html) as its underlying data source. The benefit of this is that it now you can populate your RecyclerView with a [CursorLoader](http://developer.android.com/intl/pt-br/reference/android/content/CursorLoader.html), something that was previously only possible using a CursorAdapter and ListView.

### Usage
---
To add the library to your project, just include the following dependency in your build.gradle file:
```java
compile 'com.androidessence:recyclerviewcursoradapter:1.0.0'
```

### Implementation
---
In the same way that RecyclerView.Adapter requires a generic RecyclerView.ViewHolder, this adapter uses a RecyclerViewCursorViewHolder. It extends from RecyclerView.ViewHolder; The only difference is that it must implement a `bindCursor()` method which helps simplify the process of binding Cursor data to a ViewHolder object.

If you are using a single ViewHolder for your Adapter (which is all that is easily supported in the current version), you can make use of the `setupCursorAdapter()` function to easily implement the newView and bindView methods of the underlying CursorAdapter. All you need to do is specify the initial values for the CursorAdapter, and the layout resource for the root view of your ViewHolder. See the sample project for an example.

In onCreateViewHolder, you can return a ViewHolder that is defined by the view returned by `mCursorAdapter.newView()`. In `onBindViewHolder()`, it is your responsibility to make sure the CursorAdapter's Cursor is moved to the proper position, and that the ViewHolder is set prior to calling bindView in the CursorAdapter. Again, the sample project has snippets that do all of this.

Use the `swapCursor()` function to exchange the data inside the Adapter. This can be done using a CursorLoader, or using the result of any queries you run manually.

Currently there is support to easily control a RecyclerViewCursorAdapter that uses a single ViewHolder. However, nothing restricts the user from using multiple View types; Just don't use `setupCursorAdapter()` and instead instantiate the CursorAdapter in your own way and adjust onBindViewHolder and onCreateViewHolder accordingly.

### Contributors
---
[Adam McNeilly](http://github.com/AdamMc331)
