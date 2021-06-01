package other.mvvm.fragment.src

fun mvvmFragmentContract(
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}.di

import app.base.di.component.ActivityComp
import app.base.di.scope.PerActivity
import app.base.mvvm.repository.IRepository
import app.base.mvvm.view.IView
import ${(packageName)}.${moduleName}Fragment
import dagger.Component

interface ${moduleName}Contract {

    @PerActivity
    @Component(modules = [${moduleName}Module::class],
            dependencies = [ActivityComp::class])
    interface Comp : ActivityComp {
        fun inject(fragment: ${moduleName}Fragment)
    }

    interface View : IView
    interface Repository : IRepository
}
"""