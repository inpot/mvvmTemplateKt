package other.mvvm.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import org.jetbrains.kotlin.util.capitalizeDecapitalize.capitalizeFirstWord


val mvvmActivityTemplate
    get() = template {
        revision = 1
        name = "MVVM Activity"
        description = "适用于https://github.com/inpot/base的MVVM Template"
        minApi = MIN_API
        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)


        val moduleName = stringParameter {
            name = "Module Name"
            default = "Main"
            help = "只输入名字，不要包含Activity"
            constraints = listOf(Constraint.NONEMPTY)
        }
        val activityClass = moduleName.value.capitalizeFirstWord()


        val activityTitle= stringParameter {
            name = "Title"
            default = "MainActivity"
            help = "Title for Activity"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.toLowerCase())}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmActivityRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    packageName.value)
        }
    }


val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }