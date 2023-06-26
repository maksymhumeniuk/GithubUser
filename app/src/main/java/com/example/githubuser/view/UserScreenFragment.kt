package com.example.githubuser.view

import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.AppExecutors
import com.example.githubuser.R
import com.example.githubuser.common.ui.RepoListAdapter
import com.example.githubuser.databinding.FragmentUserScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UserScreenFragment : BaseFragment<FragmentUserScreenBinding>(R.layout.fragment_user_screen) {

    @Inject
    lateinit var appExecutors: AppExecutors

    private val mainViewModel: MainViewModel by hiltNavGraphViewModels(R.id.nav_graph)

    private lateinit var adapter: RepoListAdapter

    override fun FragmentUserScreenBinding.initialize() {
        binding.viewModel = mainViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        adapter = RepoListAdapter(
            appExecutors = appExecutors
        ) { repo ->
            mainViewModel.repoDetails = repo
            findNavController().navigate(R.id.action_user_screen_to_register)
        }
        binding.repoList.adapter = adapter
        initSearchInputListener()
        initListListener()
    }

    private fun initListListener() {
        lifecycleScope.launch {
            mainViewModel.reposList.collectLatest {
                adapter.submitList(it)
            }
        }
    }

    private fun initSearchInputListener() {
        binding.input.setOnEditorActionListener { view: View, actionId: Int, _: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch(view)
                true
            } else {
                false
            }
        }
        binding.input.setOnKeyListener { view: View, keyCode: Int, event: KeyEvent ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                doSearch(view)
                true
            } else {
                false
            }
        }
    }

    private fun doSearch(v: View) {
        val userId = binding.input.text.toString()
        // Dismiss keyboard
        dismissKeyboard(v.windowToken)
        mainViewModel.doSearch(userId)
    }

    private fun dismissKeyboard(windowToken: IBinder) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(windowToken, 0)
    }
}