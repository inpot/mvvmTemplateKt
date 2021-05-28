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
            help = "Only Prefix , Do not contain \'VM\',\'Module\',\'Repo\',\'Contract\', Plugin will append it "
            constraints = listOf(Constraint.NONEMPTY)
            //suggest = { packageName.substring(packageName.indexOfLast { it == '.' }).capitalize()}
        }

        val activityClass = stringParameter {
            name = "Activity Class Name"
            default = "Main"
            help = "Prefix for Activity, do not contain \'Activity\', Plugin will append it"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = {"${moduleName.value.capitalize()}"}
        }

        val activityTitle= stringParameter {
            name = "Title"
            default = "MainActivity"
            help = "Title for Activity"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${activityClass.value}" }
        }


        val activityType = enumParameter<ActivityType> {
            name = "Activity Type"
            default = ActivityType.Simple
            help = "Choose a type, SimpleActivity,RecyclerViewActivity Or TabLayout"
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            help = "Layout Xml File Name"
            default = "${activityToLayout(activityClass.value.toLowerCase())}"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${activityToLayout(activityClass.value.toLowerCase())}" }
        }

        var homeAsUp = booleanParameter {
            name = "Home As Up"
            default = true
            help = "If true, the toolbar will have a back button"
        }

        val currentPkg = defaultPackageNameParameter

        widgets(
            TextFieldWidget(moduleName),
            TextFieldWidget(activityTitle),
            TextFieldWidget(activityClass),
            TextFieldWidget(layoutName),
            EnumWidget(activityType),
            CheckBoxWidget(homeAsUp),
            PackageNameWidget(currentPkg)
        )
//        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            mvvmActivityRecipe(
                moduleName.value.capitalize(),//CapsFirst
                activityTitle.value,
                activityClass.value.capitalize(),//CapsFirst
                layoutName.value,//without Caps Letter,and use "_" to connect word
                homeAsUp.value,
                activityType.value,
                currentPkg.value,
                data as ModuleTemplateData
            )
        }
    }

val defaultPackageNameParameter get() = stringParameter {
            name = "Package name"
            visible = { !isNewModule }
            default = "com.mycompany.myapp"
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

enum class ActivityType{ Simple,RecyclerView,TabLayout }