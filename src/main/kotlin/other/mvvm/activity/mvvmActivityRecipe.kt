package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import mvvmItemXml
import other.mvvm.activity.res.layout.mvvmListXml
import other.mvvm.activity.res.layout.mvvmSimpleXml
import other.mvvm.activity.res.layout.mvvmTabLayoutXml
import other.mvvm.activity.src.*


fun RecipeExecutor.mvvmActivityRecipe(
    moduleName:String,
    title:String,
    activityClass:String,
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
    // 保存viewmodel
    when(type){
        ActivityType.Simple->{
            save(mvvmSimpleVM(moduleName,packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmSimpleXml(packageName, activityClass,moduleName), resOut.resolve("layout/${layout}.xml"))
        }
        ActivityType.TabLayout->{
            save(mvvmTabVM(moduleName,packageName), srcOut.resolve("${activityClass}VM.${ktOrJavaExt}"))
            save(mvvmTabLayoutXml(packageName, activityClass,moduleName), resOut.resolve("layout/${layout}.xml"))
        }
        ActivityType.RecyclerView->{
            save(mvvmListVM(moduleName, packageName), srcOut.resolve("${activityClass}VM.${ktOrJavaExt}"))
            save(mvvmListXml(packageName, activityClass,moduleName),resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleAdapter(moduleData.packageName,moduleName, packageName), srcOut.resolve("${activityClass}ViewModel.${ktOrJavaExt}"))
            save(mvvmItemXml(packageName,moduleName),resOut.resolve("${activityClass}ViewModel.${ktOrJavaExt}"))
        }
    }
    // 保存Contract
    save(mvvmContract(moduleName,activityClass, packageName), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))

    // 保存repository
    save(mvvmRepo(moduleName, packageName), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}