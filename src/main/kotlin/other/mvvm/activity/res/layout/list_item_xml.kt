package other.mvvm.activity.res.layout

fun mvvmItemXml(
    packageName: String,
    moduleName: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="${(packageName)}.${moduleName}ListItemVM" />

        <variable name="vm" type="${moduleName}ListItemVM" />

    </data>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:padding="8dp"
        android:text="@{vm.data}"
        android:textSize="16dp" />
</layout>
"""