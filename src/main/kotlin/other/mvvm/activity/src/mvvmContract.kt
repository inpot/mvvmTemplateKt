package other.mvvm.activity.src

fun mvvmContract(
        moduleName:String,
        activityClass:String,
        packageName:String
)="""
package ${(packageName)}.di

import app.base.di.component.ActivityComp
import app.base.di.scope.PerActivity
import app.base.mvvm.repository.IRepository
import app.base.mvvm.view.IView
import ${(packageName)}.${activityClass}
import dagger.Component

interface ${moduleName}Contract {

    @PerActivity
    @Component(modules = [${moduleName}Module::class],
            dependencies = [ActivityComp::class])
    interface Comp : ActivityComp {
        fun inject(activity: ${activityClass}Activity)
    }

    interface View : IView
    interface Repository : IRepository
}
"""