package other.mvvm.fragment.src

fun mvvmFragmentKt(
        moduleName:String,
        appPackage:String,
        layoutName:String,
        packageName:String
)="""
package ${(packageName)}

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.base.BaseFragment
import ${appPackage}.databinding.Fragment${moduleName}Binding
import ${(packageName)}.di.Dagger${moduleName}Contract_Comp
import ${(packageName)}.di.${moduleName}Contract
import ${(packageName)}.di.${moduleName}Module
import javax.inject.Inject
import ${appPackage}.R

class ${moduleName}Fragment: BaseFragment(),${moduleName}Contract.View {

    @Inject
    lateinit var vm: ${moduleName}VM

    override fun buildComp() {
        Dagger${moduleName}Contract_Comp.builder().activityComp(activityComp()).${moduleName.decapitalize()}Module(${moduleName}Module(this))
                .build().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: Fragment${moduleName}Binding = bindViewModel(inflater,container,R.layout.${layoutName}, vm)
        return binding.root
    }

}
"""
