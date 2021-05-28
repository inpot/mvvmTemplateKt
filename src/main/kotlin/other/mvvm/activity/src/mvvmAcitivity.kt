package other.mvvm.activity.src

fun mvvmAcitivityKt(
        moduleName:String,
        appPackage:String,
        layoutName:String,
        homeAsUp:Boolean,
        packageName:String
)="""
package ${(packageName)}

import android.content.Context
import android.content.Intent
import android.os.Bundle
import app.base.BaseActivity
import ${appPackage}.databinding.Activity${moduleName}Binding
import ${(packageName)}.di.Dagger${moduleName}Contract_Comp
import ${(packageName)}.di.${moduleName}Contract
import ${(packageName)}.di.${moduleName}Module
import javax.inject.Inject
import ${appPackage}.R

class ${moduleName}Activity : BaseActivity(),${moduleName}Contract.View {

    @Inject
    lateinit var vm: ${moduleName}VM

    override fun buildComp() {
        Dagger${moduleName}Contract_Comp.builder().activityComp(activityComp).${moduleName.decapitalize()}Module(${moduleName}Module(this))
                .build().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:Activity${moduleName}Binding =  bindViewModel(R.layout.${layoutName},vm,${homeAsUp})
    }

    companion object {

        fun actionStart(context: Context){
            context.startActivity(Intent(context,${moduleName}Activity::class.java))
        }

    }
}
"""
