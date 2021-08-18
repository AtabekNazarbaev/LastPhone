package uz.texnopos.phoneinfo.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_apple.*
import kotlinx.coroutines.*
import uz.texnopos.phoneinfo.Adapter
import uz.texnopos.phoneinfo.R
import uz.texnopos.phonesinfo.database.MyDao
import uz.texnopos.phonesinfo.database.MyDatabase
import android.view.View as View

class AppleFragment : Fragment(R.layout.fragment_apple) {

    private lateinit var dao: MyDao
    private var mAdapter = Adapter()
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        appleRecyclerView.adapter = mAdapter
        dao = MyDatabase.getInstance(requireContext()).phonesDao()
        setData()

    }

    private fun setData() {
        CoroutineScope(Dispatchers.Main).launch {
            mAdapter.models = withContext(Dispatchers.IO) {
                dao.getSortPhones(3)
            }
        }
    }
}