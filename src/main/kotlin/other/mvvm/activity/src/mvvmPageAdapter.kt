package other.mvvm.activity.src

fun mvvmPageAdapter(
        moduleName:String,
        packageName:String
)="""
package ${(packageName)}

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class  ${moduleName}PagerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        TODO()
    }

    override fun getCount(): Int {
        TODO()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        TODO()
    }

}
"""