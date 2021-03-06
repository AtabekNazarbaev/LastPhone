package uz.texnopos.phoneinfo.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import uz.texnopos.phoneinfo.R
import uz.texnopos.phoneinfo.viewPager.AppleFragment
import uz.texnopos.phoneinfo.viewPager.RedmiFragment
import uz.texnopos.phoneinfo.viewPager.SamsungFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
       return when(position){
            0-> RedmiFragment()
            1-> SamsungFragment()
            else-> AppleFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }
}