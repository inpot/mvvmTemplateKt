package other.mvvm.activity.src

fun mvvmListItemVM(
    moduleName: String,
    packageName: String
) = """
package ${(packageName)}
import app.base.mvvm.vm.list.BaseItemVM
import app.base.view.OnItemClick

class ${moduleName}ListItemVM(data:T, onItemClick: OnItemClick<T>?) : BaseItemVM<T>(data)
"""