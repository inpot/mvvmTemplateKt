
package  other
import com.android.tools.idea.wizard.template.mvvmTemplateKt
import com.android.tools.idea.wizard.template.WizardmvvmTemplateKtProvider
import other.mvvm.activity.mvvmActivitymvvmmvvmTemplateKtKt
import other.mvvm.fragment.mvvmFragmentmvvmmvvmTemplateKtKt

class MvvmPluginmvvmTemplateKtProvider: WizardmvvmTemplateKtProvider(){

    override fun getmvvmTemplateKts(): List<mvvmTemplateKt> = listOf(
            // activity的模板
            mvvmActivitymvvmmvvmTemplateKtKt,
            // fragment的模板
            mvvmFragmentmvvmmvvmTemplateKtKt
    )


}