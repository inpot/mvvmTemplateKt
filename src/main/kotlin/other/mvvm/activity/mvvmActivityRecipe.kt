package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import mvvmItemXml
import other.mvvm.activity.res.layout.mvvmListXml
import other.mvvm.activity.res.layout.mvvmSimpleXml
import other.mvvm.activity.res.layout.mvvmTabLayoutXml
import other.mvvm.activity.res.values.activityStringsXml
import other.mvvm.activity.src.*


fun RecipeExecutor.mvvmActivityRecipe(
    moduleName:String,//Caps first Letter
    title:String,
    activityClass:String,//Caps first Letter
    layout:String,
    homeAsUp:Boolean,
    type:ActivityType,
    packageName: String,
    moduleData: ModuleTemplateData,
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )

    val mvvmActivity = mvvmAcitivityKt(moduleName,moduleData.packageName, activityClass, layout, homeAsUp, packageName)
    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    mergeXml(activityStringsXml(layout,title), resOut.resolve("values/strings.xml"))
    // 保存viewmodel
    when(type){
        ActivityType.Simple->{
            save(mvvmSimpleVM(moduleName,packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmSimpleXml(packageName, activityClass,moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
        ActivityType.TabLayout->{
            save(mvvmTabVM(moduleName,packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmPageAdapter(moduleName,packageName), srcOut.resolve("${moduleName}PageAdapter.${ktOrJavaExt}"))
            save(mvvmTabLayoutXml(packageName, activityClass,moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmTabModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
        ActivityType.RecyclerView->{
            save(mvvmListVM(moduleName, packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmListItemVM(moduleName, packageName), srcOut.resolve("${moduleName}ItemVM.${ktOrJavaExt}"))
            save(mvvmListXml(packageName, activityClass,moduleName),resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleAdapter(moduleData.packageName,moduleName, packageName), srcOut.resolve("${moduleName}ListAdapter.${ktOrJavaExt}"))
            save(mvvmItemXml(packageName,moduleName),resOut.resolve("layout/list_item_${moduleName}.xml"))
            save(mvvmListModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
    }
    // 保存Contract
    save(mvvmContract(moduleName,activityClass, packageName), srcOut.resolve("di/${moduleName}Constract.${ktOrJavaExt}"))
    // 保存Module

    // 保存repository
    save(mvvmRepo(moduleName, packageName), srcOut.resolve("model/${moduleName}Rep.${ktOrJavaExt}"))
}