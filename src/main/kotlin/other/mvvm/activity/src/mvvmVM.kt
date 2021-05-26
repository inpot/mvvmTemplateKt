package other.mvvm.activity.src

fun mvvmSimpleAdapterKt(
        applicationPackage:String?,
        activityClass:String,
        layoutName:String,
        packageName:String
)="""
package ${escapeKotlinIdentifiers(packageName)}

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import app.base.mvvm.vm.list.BaseListAdapter
import ${applicationPackage}.R

class ${moduleName?cap_first}ListAdapter : BaseListAdapter<T>() {

    override fun onCreateItemBinding(layoutInflater: LayoutInflater, parent: ViewGroup): ViewDataBinding
            = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_${moduleName?lower_case}, parent, false)

    override fun onCreateVM(position: Int, data:T) = ${moduleName?cap_first}ListItemVM(data, onItemClick)

}
"""