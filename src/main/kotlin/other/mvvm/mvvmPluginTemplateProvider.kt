
package  other
import com.android.tools.idea.wizard.template.mvvmTemplateKt
import com.android.tools.idea.wizard.template.WizardmvvmTemplateKtProvider
import other.mvvm.activity.mvvmActivitymvvmTemplateKt
import other.mvvm.fragment.mvvmFragmentmvvmTemplateKt

class MvvmPluginmvvmTemplateKtProvider: WizardmvvmTemplateKtProvider(){

    override fun getmvvmTemplateKts(): List<mvvmTemplateKt> = listOf(
            // activity的模板
            mvvmActivitymvvmTemplateKt,
            // fragment的模板
            mvvmFragmentmvvmTemplateKt
    )
}