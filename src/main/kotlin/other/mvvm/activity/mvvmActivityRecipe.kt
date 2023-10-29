package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.mvvm.activity.res.layout.mvvmItemXml
import other.mvvm.activity.res.layout.mvvmListXml
import other.mvvm.activity.res.layout.mvvmSimpleXml
import other.mvvm.activity.res.layout.mvvmTabLayoutXml
import other.mvvm.activity.src.*


fun RecipeExecutor.mvvmActivityRecipe(
    moduleName: String,//Caps first Letter
    title: String,
    layout: String,
    homeAsUp: Boolean,
    type: ActivityType,
    packageName: String,
    moduleData: ModuleTemplateData,
) {
    val (projectData, srcOut, resOut, manifestDir) = moduleData
    val ktOrJavaExt = projectData.language.extension
    generateManifest(
        activityClass = "${moduleName}Activity",
//        activityTitle = title,
        packageName = packageName,
        isLauncher = false,
        hasNoActionBar = true,
        isNewModule = false,
        moduleData = moduleData,
        generateActivityTitle = true,
    )

    val appPkg = moduleData.projectTemplateData.applicationPackage?:"No_AppPkg"
    val mvvmActivity = mvvmAcitivityKt(moduleName, appPkg, layout, homeAsUp, packageName)
    // 保存Activity
    save(mvvmActivity, srcOut.resolve("${moduleName}Activity.${ktOrJavaExt}"))
    // 保存viewmodel
    when (type) {
        ActivityType.Simple -> {
            save(mvvmSimpleVM(moduleName, packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmSimpleXml(packageName, moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
        ActivityType.TabLayout -> {
            save(mvvmTabVM(moduleName, packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmPageAdapter(moduleName, packageName), srcOut.resolve("${moduleName}PageAdapter.${ktOrJavaExt}"))
            save(mvvmTabLayoutXml(packageName, moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmTabModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
        ActivityType.RecyclerView -> {
            save(mvvmListVM(moduleName, packageName), srcOut.resolve("${moduleName}VM.${ktOrJavaExt}"))
            save(mvvmListItemVM(moduleName, packageName), srcOut.resolve("${moduleName}ItemVM.${ktOrJavaExt}"))
            save(mvvmListXml(packageName, moduleName), resOut.resolve("layout/${layout}.xml"))
            save(mvvmSimpleAdapter(appPkg, moduleName, packageName), srcOut.resolve("${moduleName}ListAdapter.${ktOrJavaExt}"))
            save(mvvmItemXml(packageName, moduleName), resOut.resolve("layout/list_item_${moduleName.toLowerCase()}.xml"))
            save(mvvmListModule(moduleName, packageName), srcOut.resolve("di/${moduleName}Module.${ktOrJavaExt}"))
        }
    }
    // 保存Contract
    save(mvvmContract(moduleName, packageName), srcOut.resolve("di/${moduleName}Constract.${ktOrJavaExt}"))

    // 保存repository
    save(mvvmRepo(moduleName, packageName), srcOut.resolve("model/${moduleName}Rep.${ktOrJavaExt}"))
}