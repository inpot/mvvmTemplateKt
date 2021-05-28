package other.mvvm.activity.res.values

fun manifestFile(module:String,currentPkg:String,layout:String)="""
<manifest>
    <application >
        <activity android:name="${currentPkg}.${module}Activity"
                android:label="@string/title_${layout}"
                android:theme="@style/AppTheme.PopupOverlay">
        </activity>
    </application>
</manifest>
"""
