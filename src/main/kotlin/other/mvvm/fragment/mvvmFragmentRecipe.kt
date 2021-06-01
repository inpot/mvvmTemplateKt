package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import mvvmItemXml
import other.mvvm.activity.res.values.activityStringsXml
import other.mvvm.activity.src.*
import other.mvvm.fragment.res.layout.mvvmListFragmentXml
import other.mvvm.fragment.res.layout.mvvmSimpleFragmentXml
import other.mvvm.fragment.res.layout.mvvmTabLayoutFragmentXml
import other.mvvm.fragment.src.mvvmFragmentContract
import other.mvvm.fragment.src.mvvmFragmentKt


fun RecipeExecutor.mvvmFragmentRecipe(
    moduleName:String,//Caps first Letter
    title:String,
    layout:String,
    type:ActivityType,
    packageName: String,
    moduleData: ModuleTemplateData,
) {
    val (projectData, srcOut, resOut,manifestDir) = moduleData
    val ktOrJavaExt = projectData.language.extension

    val appPkg = moduleData.projectTemplateData.applicationPackage?:"No_appPkg"
    val mvvmFragment = mvvmFragmentKt(moduleName,appPkg, layout, packageName)
    // 保存Fragment
    save(mvvmFragment, srcOut.resolve("${moduleName}Fragment.${ktOrJavaExt}"))
    mergeXml(activityStringsXml(layout,title), resOut.resolve("values/strings.xml"))
    // 保存viewmodel
    when(type){
        ActivityType.Simple->{
            save(mvvmSimpleVM(moduleName,packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmSimpleFragmentXml(packageName,moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
        ActivityType.TabLayout->{
            save(mvvmTabVM(moduleName,packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmPageAdapter(moduleName,packageName), srcOut.resolve("${moduleName}PageAdapter.${ktOrJavaExt}"))
            save(mvvmTabLayoutFragmentXml(packageName,moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmTabModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
        ActivityType.RecyclerView->{
            save(mvvmListVM(moduleName, packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmListItemVM(moduleName, packageName), srcOut.resolve("${moduleName}ItemVM.${ktOrJavaExt}"))
            save(mvvmListFragmentXml(packageName,moduleName),resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleAdapter(appPkg,moduleName, packageName), srcOut.resolve("${moduleName}ListAdapter.${ktOrJavaExt}"))
            save(mvvmItemXml(packageName,moduleName),resOut.resolve("layout/list_item_${moduleName.toLowerCase()}.xml"))
            save(mvvmListModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
    }
    // 保存Contract
    save(mvvmFragmentContract(moduleName, packageName), srcOut.resolve("di/${moduleName}Constract.${ktOrJavaExt}"))
    // 保存Module

    // 保存repository
    save(mvvmRepo(moduleName, packageName), srcOut.resolve("model/${moduleName}Rep.${ktOrJavaExt}"))
}