
package other.mvvm.activity.src

fun mvvmItemKt(
        applicationPackage:String?,
        activityClass:String,
        layoutName:String,
        packageName:String
)="""
package ${escapeKotlinIdentifiers(packageName)}
import app.base.mvvm.vm.list.BaseItemVM
import app.base.view.OnItemClick

class ${moduleName?cap_first}ListItemVM(data:T, onItemClick: OnItemClick<T>?) : BaseItemVM<T>(data)
"""