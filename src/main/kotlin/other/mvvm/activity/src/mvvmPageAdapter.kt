package other.mvvm.activity.src

fun mvvmSimplePageAdapterKt(
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}

import android.view.View
<#if viewType=="recyclerView">
import app.base.mvvm.vm.list.BaseListVM
import androidx.recyclerview.widget.RecyclerView
import app.base.view.OnItemClick
import app.base.mvvm.vm.list.BaseListAdapter
<#elseif viewType=="topPager">
import androidx.fragment.app.FragmentStatePagerAdapter
import app.base.mvvm.vm.PagerVM
<#else>
import app.base.mvvm.vm.BaseVM
</#if>
import ${(packageName)}.di.${moduleName}Contract

<#if viewType=="recyclerView">
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

<#elseif viewType=="topPager">
class ${moduleName}VM() :PagerVM<${moduleName}Contract.Repository, ${moduleName}Contract.View >(){

}

<#else>
class ${moduleName}VM() :BaseVM<${moduleName}Contract.Repository, ${moduleName}Contract.View >(){


}
</#if>
"""