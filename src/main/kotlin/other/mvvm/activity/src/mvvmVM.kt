package other.mvvm.activity.src

import other.mvvm.activity.ActivityType

fun mvvmSimpleVM(moduleName: String, packageName: String)="""
package ${(packageName)}

import android.view.View
import app.base.mvvm.vm.BaseVM
import ${(packageName)}.di.${moduleName}Contract

class ${moduleName}VM() :BaseVM<${moduleName}Contract.Repository, ${moduleName}Contract.View >(){
TODO()
}
"""

fun mvvmTabVM(moduleName: String, packageName: String)="""
    
package ${(packageName)}

import android.view.View
import androidx.fragment.app.FragmentStatePagerAdapter
import app.base.mvvm.vm.PagerVM
import ${(packageName)}.di.${moduleName}Contract

class ${moduleName}VM() :PagerVM<${moduleName}Contract.Repository, ${moduleName}Contract.View >(){
TODO()
}
"""
fun mvvmListVM(moduleName: String, packageName: String)="""
package ${(packageName)}

import android.view.View
import app.base.mvvm.vm.list.BaseListVM
import androidx.recyclerview.widget.RecyclerView
import app.base.view.OnItemClick
import app.base.mvvm.vm.list.BaseListAdapter
import ${(packageName)}.di.${moduleName}Contract

class ${moduleName}VM() :BaseListVM<${moduleName}Contract.Repository, ${moduleName}Contract.View, T>(),OnItemClick<T>{

    init {
       adapter.onItemClick = this
    }

    override fun onLoadData(page: Int) {
        TODO()
    }

    override fun onItemClick(view:View, data: T){
        TODO()
    }

}
"""
