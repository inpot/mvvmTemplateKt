package other.mvvm.activity.res.layout

fun mvvmSimpleXml(
        packageName: String,
        activityClass: String,
        moduleName:String

) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="${(packageName)}.${moduleName}VM" />

        <import type="android.view.View"/>

        <variable name="vm" type="${moduleName}VM" />

    </data>


    <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="${(packageName)}.${activityClass}Activity">
        <com.google.android.material.appbar.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <androidx.appcompat.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:layout_scrollFlags="scroll|enterAlways"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />
        </com.google.android.material.appbar.AppBarLayout>
        <androidx.constraintlayout.widget.ConstraintLayout
            android:id="@+id/content"
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginEnd="8dp"
            android:layout_marginStart="8dp"
            android:layout_marginTop="8dp"
            android:text="@string/app_name"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
        </androidx.constraintlayout.widget.ConstraintLayout>
    </androidx.coordinatorlayout.widget.CoordinatorLayout>
</layout>
"""
fun mvvmListXml(
        packageName: String,
        activityClass: String,
        moduleName:String

) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="${(packageName)}.${moduleName}VM" />

        <import type="android.view.View"/>

        <variable name="vm" type="${moduleName}VM" />

    </data>


    <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="${(packageName)}.${activityClass}Activity">
        <com.google.android.material.appbar.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <androidx.appcompat.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:layout_scrollFlags="scroll|enterAlways"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />
        </com.google.android.material.appbar.AppBarLayout>
        <androidx.swiperefreshlayout.widget.SwipeRefreshLayout
            android:id="@+id/refreshLayout"
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:refreshListener="@{vm.refreshingListener}"
            app:refreshing="@={vm.refreshing}">

            <FrameLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent">

                <include
                    layout="@layout/empty_view"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    app:isVisible="@{vm.status == 0}"
                    tools:visibility="gone" />

                <include
                    layout="@layout/error_view"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_gravity="center"
                    app:isVisible="@{vm.status == -1}" />

                <androidx.recyclerview.widget.RecyclerView
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    app:layout_behavior="@string/appbar_scrolling_view_behavior"
                    app:adapter="@{vm.adapter}"
                    android:visibility="@{vm.status == 1 ? View.VISIBLE : View.GONE}"
                    app:layoutManager="@{vm.layoutManager}" />

            </FrameLayout>
        </androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
    </androidx.coordinatorlayout.widget.CoordinatorLayout>
</layout>
"""
fun mvvmTabLayoutXml(
        packageName: String,
        activityClass: String,
        moduleName:String
        
) = """
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <import type="${(packageName)}.${moduleName}VM" />

        <import type="android.view.View"/>

        <variable name="vm" type="${moduleName}VM" />

    </data>


    <androidx.coordinatorlayout.widget.CoordinatorLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:context="${(packageName)}.${activityClass}Activity">
        <com.google.android.material.appbar.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:theme="@style/AppTheme.AppBarOverlay">

            <androidx.appcompat.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                app:layout_scrollFlags="scroll|enterAlways"
                android:background="?attr/colorPrimary"
                app:popupTheme="@style/AppTheme.PopupOverlay" />
            <com.google.android.material.tabs.TabLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@android:color/white"
                app:adapter="@{vm.pagerAdapter}"
                app:tabIndicatorColor="#333"
                app:tabSelectedTextColor="#333"
                app:tabTextColor="#aaa"
                app:tabIndicatorHeight="1.5dp"
                app:viewPager="@{@id/view_pager}" />
        </com.google.android.material.appbar.AppBarLayout>
        <androidx.viewpager.widget.ViewPager
            android:id="@+id/view_pager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior"
            app:offscreenPageLimit="@{vm.pagerAdapter.count}" />
    </androidx.coordinatorlayout.widget.CoordinatorLayout>
</layout>
"""