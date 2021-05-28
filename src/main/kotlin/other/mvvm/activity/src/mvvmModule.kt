package other.mvvm.activity.src

fun mvvmSimpleModule(
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import app.base.di.scope.PerActivity
import dagger.Module
import dagger.Provides
import ${(packageName)}.${moduleName}VM
import ${(packageName)}.model.${moduleName}Rep

@Module
class ${moduleName}Module(val view:${moduleName}Contract.View){

    @Provides
    @PerActivity
    fun provideVM(repository: ${moduleName}Rep):${moduleName}VM{
        var vm =
        when (view){
            is Fragment -> ViewModelProviders.of(view).get(${moduleName}VM::class.java)
            is FragmentActivity -> ViewModelProviders.of(view).get(${moduleName}VM::class.java)
            else -> ${moduleName}VM()
        }
        vm.initialize(repository,view)
        return vm
    }

}
"""
fun mvvmListModule(
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}.di

import androidx.recyclerview.widget.RecyclerView
import app.base.di.modules.LayoutManagerModules
import app.base.di.scope.ListType
import ${(packageName)}.${moduleName}ListAdapter
import javax.inject.Named

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import app.base.di.scope.PerActivity
import dagger.Module
import dagger.Provides
import ${(packageName)}.${moduleName}VM
import ${(packageName)}.model.${moduleName}Rep

@Module(includes = [LayoutManagerModules::class])
class ${moduleName}Module(val view:${moduleName}Contract.View){

    @Provides
    @PerActivity
    fun provideVM(repository: ${moduleName}Rep, @Named(ListType.VERTICAL) layoutManager:RecyclerView.LayoutManager):${moduleName}VM{
        var vm =
        when (view){
            is Fragment -> ViewModelProviders.of(view).get(${moduleName}VM::class.java)
            is FragmentActivity -> ViewModelProviders.of(view).get(${moduleName}VM::class.java)
            else -> ${moduleName}VM()
        }
        vm.initialize(repository,view, layoutManager, ${moduleName}ListAdapter())
        return vm
    }
}
"""
fun mvvmTabModule(
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}.di

import androidx.fragment.app.FragmentManager
import ${(packageName)}.${moduleName}PagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import app.base.di.scope.PerActivity
import dagger.Module
import dagger.Provides
import ${(packageName)}.${moduleName}VM
import ${(packageName)}.model.${moduleName}Rep

@Module
class ${moduleName}Module(val view:${moduleName}Contract.View){

    @Provides
    @PerActivity
    fun provideVM(repository: ${moduleName}Rep,fragmentManager:FragmentManager):${moduleName}VM{
        var vm =
        when (view){
            is Fragment -> ViewModelProviders.of(view).get(${moduleName}VM::class.java)
            is FragmentActivity -> ViewModelProviders.of(view).get(${moduleName}VM::class.java)
            else -> ${moduleName}VM()
        }
        vm.initialize(repository,view, ${moduleName}PagerAdapter())
        return vm
    }
}
"""