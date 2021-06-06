
package  other
import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvvm.activity.mvvmActivitymvvmTemplateKt
import other.mvvm.fragment.mvvmFragmentmvvmTemplateKt

class MvvmPluginTemplateProvider: WizardTemplateProvider(){

    override fun getTemplates(): List<Template> = listOf(
            // activity的模板
            mvvmActivitymvvmTemplateKt,
            // fragment的模板
            mvvmFragmentmvvmTemplateKt
    )


}