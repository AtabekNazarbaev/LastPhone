package uz.texnopos.phoneinfo.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_apple.*
import kotlinx.android.synthetic.main.fragment_samsung.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.texnopos.phoneinfo.Adapter
import uz.texnopos.phoneinfo.R
import uz.texnopos.phonesinfo.database.MyDao
import uz.texnopos.phonesinfo.database.MyDatabase

class SamsungFragment : Fragment(R.layout.fragment_samsung) {

    private var mAdapter = Adapter()
    private lateinit var dao: MyDao
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        recyclerViewSamsung.adapter = mAdapter
        dao = MyDatabase.getInstance(requireContext()).phonesDao()
        setData()

    }

    private fun setData() {
        CoroutineScope(Dispatchers.Main).launch {
            mAdapter.models = withContext(Dispatchers.IO) {
                dao.getSortPhones(2)
            }
        }
    }
}
