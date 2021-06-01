
package  other
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvvm.activity.mvvmActivityTemplate
import other.mvvm.activity.mvvmFragmentTemplate

class MvvmPluginTemplateProvider: WizardTemplateProvider(){

    override fun getTemplates(): List<Template> = listOf(
            // activity的模板
            mvvmActivityTemplate,
            // fragment的模板
            mvvmFragmentTemplate
    )
}