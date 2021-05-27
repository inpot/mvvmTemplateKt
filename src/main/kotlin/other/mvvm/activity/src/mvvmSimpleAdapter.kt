package other.mvvm.activity.src

fun mvvmSimpleAdapter(
        applicationPackage:String?,
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import app.base.mvvm.vm.list.BaseListAdapter
import ${applicationPackage}.R

class ${moduleName}ListAdapter : BaseListAdapter<T>() {

    override fun onCreateItemBinding(layoutInflater: LayoutInflater, parent: ViewGroup): ViewDataBinding
            = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_${moduleName}, parent, false)

    override fun onCreateVM(position: Int, data:T) = ${moduleName}ListItemVM(data, onItemClick)

}

"""